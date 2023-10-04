package AuctionAPI.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductDto {
    private String name, description, manufacturer;
    private BigDecimal minimumPrice;
}