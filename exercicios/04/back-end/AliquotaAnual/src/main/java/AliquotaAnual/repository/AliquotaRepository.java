package AliquotaAnual.repository;

import AliquotaAnual.model.AliquotaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface AliquotaRepository extends JpaRepository<AliquotaModel, UUID> {

}
