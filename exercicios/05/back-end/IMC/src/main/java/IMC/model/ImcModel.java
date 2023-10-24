package IMC.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.*;
import java.util.UUID;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "tbl_imc")
public class ImcModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String nome, estado;
    private Double peso, altura, imc;
}
