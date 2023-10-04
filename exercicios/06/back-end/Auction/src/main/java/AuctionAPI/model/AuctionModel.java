package AuctionAPI.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "auction_auction")
public class AuctionModel {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private LocalDateTime start, finish;
    private UUID product;
    private UUID bidChampion;

    @Transient private List<BidModel> allBids;
    @Transient private BidModel highestBid;
    @Transient private BigDecimal bidAverageValue;
    @Transient private int countBids;
}
