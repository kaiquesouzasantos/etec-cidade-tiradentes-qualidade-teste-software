package AuctionAPI.component.validation.component;

import AuctionAPI.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailExists {
    private final UserRepository userRepository;

    public boolean isValid(String value) {
        return existsByEmail(value);
    }

    private boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }
}