package AuctionAPI.component.validation.component;

public class StringValidation {
    public static boolean isValid(String value) {
        return value.matches("^[a-zA-Z]+$");
    }
}
