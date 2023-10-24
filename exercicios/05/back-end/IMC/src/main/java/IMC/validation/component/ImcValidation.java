package IMC.validation.component;

import IMC.respository.ImcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ImcValidation {
    private final ImcRepository repository;

    public boolean isValid(UUID value) {
        return existsById(value);
    }

    private  boolean existsById(UUID id) {
        return repository.existsById(id);
    }
}
