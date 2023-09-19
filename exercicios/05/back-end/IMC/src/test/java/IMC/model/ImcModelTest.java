package IMC.model;

import IMC.util.ImcUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ImcModelTest {
    @Test
    public void construct() {
        var expected = ImcUtil.factoryModel();

        assertAll(
                () -> assertEquals(expected.getNome(), ImcUtil.NOME),
                () -> assertEquals(expected.getCpf(), ImcUtil.CPF),
                () -> assertEquals(expected.getRendimentos(), ImcUtil.RENDIMENTOS)
        );
    }

    @Test
    public void update() {
        var expected = ImcUtil.factoryModel();

        expected.setNome(ImcUtil.NOME_ALTERNATIVO);
        expected.setCpf(ImcUtil.CPF_ALTERNATIVO);
        expected.setRendimentos(ImcUtil.RENDIMENTOS_ALTERNATIVO);

        assertAll(
                () -> assertEquals(expected.getNome(), ImcUtil.NOME_ALTERNATIVO),
                () -> assertEquals(expected.getCpf(), ImcUtil.CPF_ALTERNATIVO),
                () -> assertEquals(expected.getRendimentos(), ImcUtil.RENDIMENTOS_ALTERNATIVO),

                () -> assertNotEquals(expected.getNome(), ImcUtil.NOME),
                () -> assertNotEquals(expected.getCpf(), ImcUtil.CPF),
                () -> assertNotEquals(expected.getRendimentos(), ImcUtil.RENDIMENTOS)
        );
    }
}
