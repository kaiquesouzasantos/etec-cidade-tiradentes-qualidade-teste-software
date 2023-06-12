import component.PageActions;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

@Slf4j
public class AnaliseValorLimiteTest {
    private PageActions pageActions;
    private final String NOME = "TESTE", ALTURA = "2.0";

    @BeforeEach
    private void setUp() {
        pageActions = new PageActions();
    }

    @Test
    public void ts01() {
        Assertions.assertEquals(
                "Magreza",
                pageActions.retornaEstadoCorporal(NOME, "73.8", ALTURA)
        );
    }

    @Test
    public void ts02() {
        Assertions.assertEquals(
                "Magreza",
                pageActions.retornaEstadoCorporal(NOME, "73.9", ALTURA)
        );
    }

    @Test
    public void ts03() {
        Assertions.assertEquals(
                "Peso Normal",
                pageActions.retornaEstadoCorporal(NOME, "74.0", ALTURA)
        );
    }

    @Test
    public void ts04() {
        Assertions.assertEquals(
                "Peso Normal",
                pageActions.retornaEstadoCorporal(NOME, "99.8", ALTURA)
        );
    }

    @Test
    public void ts05() {
        Assertions.assertEquals(
                "Peso Normal",
                pageActions.retornaEstadoCorporal(NOME, "99.9", ALTURA)
        );
    }

    @Test
    public void ts06() {
        Assertions.assertEquals(
                "Sobrepeso",
                pageActions.retornaEstadoCorporal(NOME, "100.0", ALTURA)
        );
    }

    @Test
    public void ts07() {
        Assertions.assertEquals(
                "Sobrepeso",
                pageActions.retornaEstadoCorporal(NOME, "119.8", ALTURA)
        );
    }

    @Test
    public void ts08() {
        Assertions.assertEquals(
                "Sobrepeso",
                pageActions.retornaEstadoCorporal(NOME, "119.9", ALTURA)
        );
    }

    @Test
    public void ts09() {
        Assertions.assertEquals(
                "Obesidade Grau I",
                pageActions.retornaEstadoCorporal(NOME, "120.0", ALTURA)
        );
    }

    @Test
    public void ts10() {
        Assertions.assertEquals(
                "Obesidade Grau I",
                pageActions.retornaEstadoCorporal(NOME, "139.8", ALTURA)
        );
    }

    @Test
    public void ts11() {
        Assertions.assertEquals(
                "Obesidade Grau I",
                pageActions.retornaEstadoCorporal(NOME, "139.9", ALTURA)
        );
    }

    @Test
    public void ts12() {
        Assertions.assertEquals(
                "Obesidade Grau II",
                pageActions.retornaEstadoCorporal(NOME, "140.0", ALTURA)
        );
    }

    @Test
    public void ts13() {
        Assertions.assertEquals(
                "Obesidade Grau II",
                pageActions.retornaEstadoCorporal(NOME, "159.8", ALTURA)
        );
    }

    @Test
    public void ts14() {
        Assertions.assertEquals(
                "Obesidade Grau II",
                pageActions.retornaEstadoCorporal(NOME, "159.9", ALTURA)
        );
    }

    @Test
    public void ts15() {
        Assertions.assertEquals(
                "Obesidade Grau III",
                pageActions.retornaEstadoCorporal(NOME, "160.0", ALTURA)
        );
    }

    @Test
    public void ts16() {
        Assertions.assertEquals(
                "Obesidade Grau II",
                pageActions.retornaEstadoCorporal(NOME, "159.9", ALTURA)
        );
    }

    @Test
    public void ts17() {
        Assertions.assertEquals(
                "Obesidade Grau III",
                pageActions.retornaEstadoCorporal(NOME, "160.0", ALTURA)
        );
    }

    @Test
    public void ts18() {
        Assertions.assertEquals(
                "Obesidade Grau III",
                pageActions.retornaEstadoCorporal(NOME, "160.1", ALTURA)
        );
    }

    @AfterEach
    private void tearUp(){
        pageActions.fechaJanela();
    }
}
