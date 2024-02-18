package AuctionAPI.repository;

import AuctionAPI.model.BidModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BidRepository extends JpaRepository<BidModel, UUID> {
    Optional<List<BidModel>> findAllByAuction(UUID auction);

    @Query(nativeQuery = true, value = "SELECT * FROM bid WHERE bid.auction = :auction AND bid.bigAmount = (SELECT DISTINCT MAX(bid.bigAmount) FROM bid WHERE bid.auction = :auction)")
    Optional<BidModel> findByAuctionAndMaxBidAmount(@Param("auction") UUID auction);

    @Query(nativeQuery = true, value = "SELECT AVG(bid.bigAmount) FROM big WHERE bid.auction = :auction")
    Optional<BigDecimal> bidAverageValue(@Param("auction") UUID auction);
}
