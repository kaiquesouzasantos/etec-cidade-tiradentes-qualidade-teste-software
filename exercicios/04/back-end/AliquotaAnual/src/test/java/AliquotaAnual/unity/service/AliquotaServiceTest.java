package AliquotaAnual.unity.service;

import AliquotaAnual.component.rule.AliquotaRule;
import AliquotaAnual.dto.AliquotaDto;
import AliquotaAnual.service.AliquotaService;
import AliquotaAnual.unity.util.AliquotaUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AliquotaServiceTest {
    @Autowired private AliquotaService service;

    @Test
    public void save() {
        var expected = service.save(AliquotaUtil.factoryDto());
        var alioquota = AliquotaRule.getAliquota(expected.getRendimentos());
        var parcela = AliquotaRule.getParcela(expected.getRendimentos(), alioquota);

        assertAll(
                () -> assertEquals(expected.getNome(), AliquotaUtil.NOME),
                () -> assertEquals(expected.getCpf(), AliquotaUtil.CPF),
                () -> assertEquals(expected.getRendimentos(), AliquotaUtil.RENDIMENTOS),
                () -> assertEquals(expected.getAliquota(), alioquota),
                () -> assertEquals(expected.getParcela(), parcela)
        );
    }

    @Test
    public void compartilhamentoEquivalencia() {
        assertAll(
                () -> assertThrows(
                        Exception.class, () -> service.save(AliquotaDto.builder().build())
                ),
                () -> assertThrows(
                        Exception.class, () -> service.save(AliquotaUtil.factoryDto(
                                AliquotaUtil.NOME.concat("123"), AliquotaUtil.CPF, 0.0)
                        )
                ),
                () -> assertThrows(
                        Exception.class, () -> service.save(AliquotaUtil.factoryDto(
                                AliquotaUtil.NOME, AliquotaUtil.CPF, -1.0)
                        )
                ),
                () -> assertThrows(
                        Exception.class, () -> service.save(AliquotaUtil.factoryDto(
                                AliquotaUtil.NOME, "000.000.000-00", 0.0)
                        )
                )
        );
    }

    @Test
    public void analiseValorLimite() {
        assertAll(
                () -> assertEquals(
                        service.save(AliquotaUtil.factoryDto(22847.75)).getAliquota(),
                        0.0
                ),
                () -> assertEquals(
                        service.save(AliquotaUtil.factoryDto(22847.76)).getAliquota(),
                        0.0
                ),
                () -> assertEquals(
                        service.save(AliquotaUtil.factoryDto(22847.77)).getAliquota(),
                        7.5
                ),
                () -> assertEquals(
                        service.save(AliquotaUtil.factoryDto(33919.79)).getAliquota(),
                        7.5
                ),
                () -> assertEquals(
                        service.save(AliquotaUtil.factoryDto(33919.80)).getAliquota(),
                        7.5
                ),
                () -> assertEquals(
                        service.save(AliquotaUtil.factoryDto(33919.81)).getAliquota(),
                        15.0
                ),
                () -> assertEquals(
                        service.save(AliquotaUtil.factoryDto(45012.59)).getAliquota(),
                        15.0
                ),
                () -> assertEquals(
                        service.save(AliquotaUtil.factoryDto(45012.60)).getAliquota(),
                        15.0
                ),
                () -> assertEquals(
                        service.save(AliquotaUtil.factoryDto(55976.15)).getAliquota(),
                        22.5
                ),
                () -> assertEquals(
                        service.save(AliquotaUtil.factoryDto(55976.16)).getAliquota(),
                        22.5
                ),
                () -> assertEquals(
                        service.save(AliquotaUtil.factoryDto(55976.17)).getAliquota(),
                        27.5
                ),
                () -> assertEquals(
                        service.save(AliquotaUtil.factoryDto(55976.18)).getAliquota(),
                        27.5
                ),
                () -> assertEquals(
                    service.save(AliquotaUtil.factoryDto(55976.19)).getAliquota(),
                    27.5
                )
        );
    }
}
