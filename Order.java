
/*
Задача: Эмуляция интернет-магазина
написать классы покупатель, товар и заказ;
создать массив покупателей, массив товаров и массив заказов;
создать статический метод “совершить покупку” со строковыми параметрами,
соответствующими полям объекта заказа. Метод должен вернуть объект заказа
Если в метод передан несуществующий покупатель,
товар или отрицательное количество, метод должен выбросить соответствующее исключение;
Вызвать метод совершения покупки несколько раз таким образом,
чтобы заполнить массив покупок возвращаемыми значениями. Обработать исключения.
Вывести в консоль итоговое количество совершённых покупок после выполнения приложения.

 */
public class Order {
    private Buyer buyer;
    private Item item;
    private int amountItems;
    private int cost;

    private static int counter;

    public Order(Buyer buyer, Item item, int amountItems) {
        this.buyer = buyer;
        this.item = item;
        this.amountItems = amountItems;
        calculateCost();
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAmountItems() {
        return amountItems;
    }

    public void setAmountItems(int amountItems) {
        this.amountItems = amountItems;
        calculateCost();
    }

    public int getCost() {
        return cost;
    }

    private void calculateCost() {
        int itemPrice = item.getPrice();
        Item.Discount discount = item.getDiscount();

        // Применяем скидку к стоимости, учитывая количество товаров
        double discountPercentage = (100 - discount.getValue()) / 100.0;
        cost = (int) (itemPrice * amountItems * discountPercentage);
    }

    @Override
    public String toString() {
        return "Order{" +
                "buyer=" + buyer +
                ", item=" + item +
                ", amountItems=" + amountItems +
                ", cost=" + cost +
                '}';
    }
}
