public class TooMuchSaleException extends Exception {
    public TooMuchSaleException() {
        super("The total discount exceeds 50%.");
    }
}
