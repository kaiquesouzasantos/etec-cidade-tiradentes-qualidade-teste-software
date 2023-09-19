package IMC.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImcDto {
    private String nome;
    private Double peso, altura;
}