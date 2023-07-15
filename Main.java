import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Shampoo", 120, Item.Category.HOME_APPLIANCES));
        items.add(new Item("Toothpaste", 90, Item.Category.HOME_APPLIANCES));
        items.add(new Item("Banana", 75, Item.Category.HOME_APPLIANCES));


        items.get(0).setDiscount(Item.applyRandomDiscount());
        items.get(1).setDiscount(Item.applyRandomDiscount());
        items.get(2).setDiscount(Item.applyRandomDiscount());

        ArrayList<Buyer> buyers = new ArrayList<>();
        buyers.add(new Buyer("Ilia", 1000));
        buyers.add(new Buyer("Sabina", 5000));

        Shop shop = new Shop(items, buyers);
        try {
            shop.deal("Ilia", "Shampoo", 1);


//            shop.deal("Ilia", "Shampoo", -1);
            shop.deal("Ilia", "Car", 1);
            shop.deal("Anton", "Toothpaste", 1);
        } catch (NoBuyerFoundException e) {
            e.printStackTrace();
        } catch (NoItemFoundException e) {
            e.printStackTrace();
        } catch (IllegalAmountException e) {
            e.printStackTrace();
        } catch (TooMuchSaleException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-------------");
        System.out.println("Total deals: " + Order.getCounter());
    }


}