package AuctionAPI.component.validation.component;

import AuctionAPI.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BidExists {
    private final UserRepository userRepository;

    public boolean isValid(String value) {
        return existsUsuarioByEmail(value);
    }

    private boolean existsUsuarioByEmail(String email){
        return userRepository.existsByEmail(email);
    }
}