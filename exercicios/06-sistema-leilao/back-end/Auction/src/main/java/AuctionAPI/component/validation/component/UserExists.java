package AuctionAPI.component.validation.component;

import AuctionAPI.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserExists {
    private final UserRepository userRepository;

    public boolean isValid(UUID value) {
        return existsById(value);
    }

    private boolean existsById(UUID id){
        return userRepository.existsById(id);
    }
}