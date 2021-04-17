package by.tms.bookstorec37.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table

public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long userId;
    @OneToMany (cascade = CascadeType.ALL)
    private Set<Book> bookSet;


    public Basket(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public Basket(long userId, Set<Book> bookSet) {
        this.userId = userId;
        this.bookSet = bookSet;
    }

    public Basket(long userId) {
        this.userId = userId;
    }




}