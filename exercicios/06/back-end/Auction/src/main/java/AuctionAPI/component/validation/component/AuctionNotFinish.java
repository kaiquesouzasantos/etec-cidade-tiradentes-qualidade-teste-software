package AuctionAPI.component.validation.component;

import AuctionAPI.repository.AuctionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AuctionNotFinish {
    private final AuctionRepository auctionRepository;

    public boolean isValid(UUID value) {
        return componentFinish(value);
    }

    private boolean componentFinish(UUID id){
        return auctionRepository.findById(id).get().getFinish().equals(null);
    }
}