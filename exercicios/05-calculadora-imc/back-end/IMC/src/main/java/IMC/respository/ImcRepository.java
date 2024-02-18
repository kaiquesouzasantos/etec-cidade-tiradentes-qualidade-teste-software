package IMC.respository;

import IMC.model.ImcModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImcRepository extends JpaRepository<ImcModel, UUID> {
}
