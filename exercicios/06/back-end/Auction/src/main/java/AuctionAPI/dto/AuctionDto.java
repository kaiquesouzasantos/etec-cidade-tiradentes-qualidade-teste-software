package AuctionAPI.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AuctionDto {
    private UUID product;
}