package AuctionAPI.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@SuperBuilder
public class ProductDto {
    private String name, description, manufacturer;
    private BigDecimal minimumPrice;
}