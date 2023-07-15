import java.util.Random;

public class Item {
    private String name;
    private int price;
    private Category category;
    private static Discount discount;

    public enum Category {
        ELECTRONICS,
        CLOTHING,
        BOOKS,
        HOME_APPLIANCES,
        SPORTS_EQUIPMENT
        // Добавьте другие категории по вашему выбору
    }

    public enum Discount {
        NONE(0),
        FIVE_PERCENT(5),
        TEN_PERCENT(10),
        FIFTEEN_PERCENT(15),
        TWENTY_PERCENT(20);

        private final int value;

        Discount(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public Item(String name, int price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        Item.discount = discount;
    }

    public static Discount applyRandomDiscount() {
        Random random = new Random();
        int index = random.nextInt(Discount.values().length);
        discount = Discount.values()[index];
        return null;
    }
}
