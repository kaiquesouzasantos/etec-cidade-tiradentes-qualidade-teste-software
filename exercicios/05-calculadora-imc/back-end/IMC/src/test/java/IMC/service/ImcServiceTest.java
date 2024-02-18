package IMC.service;

import IMC.util.ImcUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ImcServiceTest {
    @Autowired
    private ImcService service;

    @Test
    public void save() {
        var expected = service.save(ImcUtil.factoryDto());

        assertAll(
                () -> assertEquals(expected.getNome(), ImcUtil.NOME),
                () -> assertEquals(expected.getAltura(), ImcUtil.ALTURA),
                () -> assertEquals(expected.getPeso(), ImcUtil.PESO),
                () -> assertEquals(expected.getImc(), ImcUtil.IMC),
                () -> assertEquals(expected.getEstado(), ImcUtil.ESTADO)
        );
    }

    @Test
    public void compartilhamentoEquivalencia() {
        assertAll(
                () -> assertThrows(
                        Exception.class,
                        () -> service.save(ImcUtil.factoryDto(null, null, null))
                ),
                () -> assertThrows(
                        Exception.class,
                        () -> service.save(ImcUtil.factoryDto(ImcUtil.NOME, -1.0, ImcUtil.ALTURA))
                ),
                () -> assertThrows(
                        Exception.class,
                        () -> service.save(ImcUtil.factoryDto(ImcUtil.NOME, ImcUtil.PESO, -1.0))
                ),
                () -> assertThrows(
                        Exception.class,
                        () -> service.save(ImcUtil.factoryDto(ImcUtil.NOME.concat("1"), ImcUtil.PESO, ImcUtil.ALTURA))
                ),
                () -> assertThrows(
                        Exception.class,
                        () -> service.save(ImcUtil.factoryDto(ImcUtil.NOME, ImcUtil.PESO, null))
                ),
                () -> assertThrows(
                        Exception.class,
                        () -> service.save(ImcUtil.factoryDto(ImcUtil.NOME, ImcUtil.PESO, 101.0))
                )
        );
    }

    @Test
    public void analiseValorLimite() {
        assertAll(
                () -> assertEquals(
                        service.save(ImcUtil.factoryDto(ImcUtil.NOME, 73.8, ImcUtil.ALTURA)).getEstado(),
                        "Magreza"
                ),
                () -> assertEquals(
                        service.save(ImcUtil.factoryDto(ImcUtil.NOME, 73.9, ImcUtil.ALTURA)).getEstado(),
                        "Magreza"
                ),
                () -> assertEquals(
                        service.save(ImcUtil.factoryDto(ImcUtil.NOME, 74.0, ImcUtil.ALTURA)).getEstado(),
                        "Peso Normal"
                ),
                () -> assertEquals(
                        service.save(ImcUtil.factoryDto(ImcUtil.NOME, 99.8, ImcUtil.ALTURA)).getEstado(),
                        "Peso Normal"
                ),
                () -> assertEquals(
                        service.save(ImcUtil.factoryDto(ImcUtil.NOME, 99.9, ImcUtil.ALTURA)).getEstado(),
                        "Peso Normal"
                ),
                () -> assertEquals(
                        service.save(ImcUtil.factoryDto(ImcUtil.NOME, 119.8, ImcUtil.ALTURA)).getEstado(),
                        "Sobrepeso"
                ),
                () -> assertEquals(
                        service.save(ImcUtil.factoryDto(ImcUtil.NOME, 119.9, ImcUtil.ALTURA)).getEstado(),
                        "Sobrepeso"
                ),
                () -> assertEquals(
                        service.save(ImcUtil.factoryDto(ImcUtil.NOME, 120.0, ImcUtil.ALTURA)).getEstado(),
                        "Obesidade Grau I"
                ),
                () -> assertEquals(
                        service.save(ImcUtil.factoryDto(ImcUtil.NOME, 139.8, ImcUtil.ALTURA)).getEstado(),
                        "Obesidade Grau I"
                ),
                () -> assertEquals(
                        service.save(ImcUtil.factoryDto(ImcUtil.NOME, 139.9, ImcUtil.ALTURA)).getEstado(),
                        "Obesidade Grau I"
                ),
                () -> assertEquals(
                        service.save(ImcUtil.factoryDto(ImcUtil.NOME, 140.0, ImcUtil.ALTURA)).getEstado(),
                        "Obesidade Grau II"
                ),
                () -> assertEquals(
                        service.save(ImcUtil.factoryDto(ImcUtil.NOME, 159.8, ImcUtil.ALTURA)).getEstado(),
                        "Obesidade Grau II"
                ),
                () -> assertEquals(
                        service.save(ImcUtil.factoryDto(ImcUtil.NOME, 159.9, ImcUtil.ALTURA)).getEstado(),
                        "Obesidade Grau II"
                ),
                () -> assertEquals(
                        service.save(ImcUtil.factoryDto(ImcUtil.NOME, 160.0, ImcUtil.ALTURA)).getEstado(),
                        "Obesidade Grau III"
                ),
                () -> assertEquals(
                        service.save(ImcUtil.factoryDto(ImcUtil.NOME, 160.1, ImcUtil.ALTURA)).getEstado(),
                        "Obesidade Grau III"
                )
        );
    }
}
