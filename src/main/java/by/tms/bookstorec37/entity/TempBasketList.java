package by.tms.bookstorec37.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
@AllArgsConstructor
//@NoArgsConstructor
public class TempBasketList {

    private static List<Basket> tempBasketList = new ArrayList<>();

    public void addBasketToBasketList (Basket basket) {
//        tempBasketList.removeAll(tempBasketList);
        tempBasketList.add(basket);
    }

    public Basket getBasketByUserId (long userId) {
        for (Basket basket : tempBasketList) {
            if (basket.getUserId() == userId) {
                return basket;
            }
        }
        return null;
    }

    public void removeBasketByUserId (long userId) {
        for (Basket basket : tempBasketList) {
            if (basket.getUserId() == userId) {
                tempBasketList.remove(basket);
            }
        }
    }

    public boolean basketExistByUserId (long userId) {
        for (Basket basket : tempBasketList) {
            if (basket.getUserId() == userId) {
                return true;
            }
        }
        return false;
    }
}
