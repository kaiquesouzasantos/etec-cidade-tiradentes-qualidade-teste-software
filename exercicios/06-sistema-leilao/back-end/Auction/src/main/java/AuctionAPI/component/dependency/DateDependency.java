package AuctionAPI.component.dependency;

import java.time.LocalDateTime;

public class DateDependency {
    public static LocalDateTime getDate() {
        return LocalDateTime.now();
    }
}
