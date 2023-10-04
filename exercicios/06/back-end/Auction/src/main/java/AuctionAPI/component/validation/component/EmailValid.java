package AuctionAPI.component.validation.component;

public class EmailValid {
    public static boolean isValid(String value){
        return value.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
    }
}