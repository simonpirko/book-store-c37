package by.tms.bookstorec37.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "categories")
public class Category {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
}