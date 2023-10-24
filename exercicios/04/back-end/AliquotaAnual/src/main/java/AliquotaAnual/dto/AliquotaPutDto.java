package AliquotaAnual.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AliquotaPutDto {
    private UUID id;
    private String nome;
    private Double rendimentos;
    private String cpf;
}