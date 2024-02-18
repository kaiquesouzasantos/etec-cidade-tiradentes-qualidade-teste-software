package AliquotaAnual.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AliquotaDto {
    private String nome;
    private Double rendimentos;
    private String cpf;
}