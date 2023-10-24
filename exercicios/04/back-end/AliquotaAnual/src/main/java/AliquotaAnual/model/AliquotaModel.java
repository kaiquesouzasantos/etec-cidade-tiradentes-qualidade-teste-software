package AliquotaAnual.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.*;
import java.util.UUID;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "tbl_aliquota")
public class AliquotaModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome, cpf;
    private Double rendimentos, aliquota, parcela;
}
