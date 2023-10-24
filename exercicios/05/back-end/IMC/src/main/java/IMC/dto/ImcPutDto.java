package IMC.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ImcPutDto {
    private UUID id;
    private String nome;
    private Double peso, altura;
}