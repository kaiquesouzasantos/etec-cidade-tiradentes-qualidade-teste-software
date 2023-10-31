package AliquotaAnual.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class AliquotaPostDto {
    private String nome;
    private Double rendimentos;
    private String cpf;
}