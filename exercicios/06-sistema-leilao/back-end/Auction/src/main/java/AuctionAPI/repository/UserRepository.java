package AuctionAPI.repository;

import java.util.UUID;

import AuctionAPI.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
    boolean existsByEmail(String email);
}
