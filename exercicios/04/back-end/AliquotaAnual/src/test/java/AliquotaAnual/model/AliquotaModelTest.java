package AliquotaAnual.model;

import AliquotaAnual.util.AliquotaUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AliquotaModelTest {
    @Test
    public void construct() {
        var expected = AliquotaUtil.factoryModel();

        assertAll(
                () -> assertNull(new AliquotaModel().getNome()),
                () -> assertEquals(expected.getNome(), AliquotaUtil.NOME),
                () -> assertEquals(expected.getCpf(), AliquotaUtil.CPF),
                () -> assertEquals(expected.getRendimentos(), AliquotaUtil.RENDIMENTOS)
        );
    }

    @Test
    public void update() {
        var expected = AliquotaUtil.factoryModel();

        expected.setNome(AliquotaUtil.NOME_ALTERNATIVO);
        expected.setCpf(AliquotaUtil.CPF_ALTERNATIVO);
        expected.setRendimentos(AliquotaUtil.RENDIMENTOS_ALTERNATIVO);

        assertAll(
                () -> assertEquals(expected.getNome(), AliquotaUtil.NOME_ALTERNATIVO),
                () -> assertEquals(expected.getCpf(), AliquotaUtil.CPF_ALTERNATIVO),
                () -> assertEquals(expected.getRendimentos(), AliquotaUtil.RENDIMENTOS_ALTERNATIVO),

                () -> assertNotEquals(expected.getNome(), AliquotaUtil.NOME),
                () -> assertNotEquals(expected.getCpf(), AliquotaUtil.CPF),
                () -> assertNotEquals(expected.getRendimentos(), AliquotaUtil.RENDIMENTOS)
        );
    }
}
