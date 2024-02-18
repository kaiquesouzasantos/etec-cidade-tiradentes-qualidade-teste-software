package AuctionAPI.component.validation.component;

import AuctionAPI.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductExists {
    private final ProductRepository productRepository;

    public boolean isValid(UUID value) {
        return existsById(value);
    }

    private boolean existsById(UUID id){
        return productRepository.existsById(id);
    }
}