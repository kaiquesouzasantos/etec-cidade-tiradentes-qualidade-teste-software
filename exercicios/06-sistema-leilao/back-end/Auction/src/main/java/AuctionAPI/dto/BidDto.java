package AuctionAPI.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@SuperBuilder
public class BidDto {
    private UUID user, auction;
    private BigDecimal bigAmount;
}