package AuctionAPI.repository;

import AuctionAPI.model.AuctionModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<AuctionModel, UUID> {

}
