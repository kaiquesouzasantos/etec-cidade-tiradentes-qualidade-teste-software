package AuctionAPI.component.validation.component;

import AuctionAPI.repository.AuctionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AuctionExists {
    private final AuctionRepository auctionRepository;

    public boolean isValid(UUID value) {
        return existsById(value);
    }

    private boolean existsById(UUID id){
        return auctionRepository.existsById(id);
    }
}