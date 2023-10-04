package AuctionAPI.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class BidDto {
    private UUID user, auction;
    private BigDecimal bigAmount;
}