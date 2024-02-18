package AuctionAPI.component.validation.component;

import AuctionAPI.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailNotExists {
    private final UserRepository userRepository;

    public boolean isValid(String value) {
        return notExistsByEmail(value);
    }

    private boolean notExistsByEmail(String email){
        return !userRepository.existsByEmail(email);
    }
}