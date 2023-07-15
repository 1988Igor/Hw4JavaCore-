import java.util.ArrayList;

import java.util.ArrayList;

public class Shop {

    private final ArrayList<Item> stock;
    private final ArrayList<Buyer> customers;

    public Shop(ArrayList<Item> stock, ArrayList<Buyer> customers) {
        this.stock = stock;
        this.customers = customers;
    }

    public Order deal(String buyerName, String itemName, int amount) throws NoBuyerFoundException, NoItemFoundException, IllegalAmountException, TooMuchSaleException {
        if (amount <= 0) {
            throw new IllegalAmountException("Amount is: " + amount + "\nExpected > 0");
        }

        Buyer buyer = findBuyer(buyerName);
        Item item = findItem(itemName);

        // Применяем случайную скидку к категории товара
        item.applyRandomDiscount();

        // Проверяем сумму скидок на товары в заказе
        if (calculateTotalDiscount() > 50) {
            throw new TooMuchSaleException();
        }

        return new Order(buyer, item, amount);
    }

    private Buyer findBuyer(String buyerName) throws NoBuyerFoundException {
        for (Buyer buyer : customers) {
            if (buyer.getName().equals(buyerName)) {
                return buyer;
            }
        }
        throw new NoBuyerFoundException("No such Buyer found");
    }

    private Item findItem(String itemName) throws NoItemFoundException {
        for (Item item : stock) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        throw new NoItemFoundException("Shop doesn't have " + itemName);
    }

    private int calculateTotalDiscount() {
        int totalDiscount = 0;
        for (Item item : stock) {
            if (item.getDiscount() != null) {
                totalDiscount += item.getDiscount().getValue();
            }
        }
        return totalDiscount;
    }
}
