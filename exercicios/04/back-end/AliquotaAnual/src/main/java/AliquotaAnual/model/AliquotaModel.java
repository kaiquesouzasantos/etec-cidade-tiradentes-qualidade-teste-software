package AliquotaAnual.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class AliquotaModel {
    private String nome, cpf;
    private Double rendimentos, aliquota, parcela;
}
