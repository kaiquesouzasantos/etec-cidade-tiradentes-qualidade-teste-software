package AuctionAPI.component.validation.component;

import java.math.BigDecimal;

public class PositiveOrZero {
    public static boolean isValid(BigDecimal value){
        return value.doubleValue() >= 0.0;
    }
}
