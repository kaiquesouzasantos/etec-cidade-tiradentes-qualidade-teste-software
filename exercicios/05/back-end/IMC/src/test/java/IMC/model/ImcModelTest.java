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
                () -> assertNull(new ImcModel().getNome()),
                () -> assertEquals(expected.getNome(), ImcUtil.NOME),
                () -> assertEquals(expected.getAltura(), ImcUtil.ALTURA),
                () -> assertEquals(expected.getPeso(), ImcUtil.PESO)
        );
    }

    @Test
    public void update() {
        var expected = ImcUtil.factoryModel();

        expected.setNome(ImcUtil.NOME_ALTERNATIVO);
        expected.setPeso(ImcUtil.PESO_ALTERNATIVO);
        expected.setAltura(ImcUtil.ALTURA_ALTERNATIVA);

        assertAll(
                () -> assertEquals(expected.getNome(), ImcUtil.NOME_ALTERNATIVO),
                () -> assertEquals(expected.getAltura(), ImcUtil.ALTURA_ALTERNATIVA),
                () -> assertEquals(expected.getPeso(), ImcUtil.PESO_ALTERNATIVO),

                () -> assertNotEquals(expected.getNome(), ImcUtil.NOME),
                () -> assertNotEquals(expected.getPeso(), ImcUtil.PESO),
                () -> assertNotEquals(expected.getAltura(), ImcUtil.ALTURA)
        );
    }
}
