package IMC.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class ImcModel {
    private String nome, estadp;
    private Double peso, altura, imc;
}
