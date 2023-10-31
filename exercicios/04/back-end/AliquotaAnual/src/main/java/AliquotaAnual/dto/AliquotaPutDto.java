package AliquotaAnual.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@NoArgsConstructor
@SuperBuilder
public class AliquotaPutDto {
    private UUID id;
    private Double rendimentos;
}