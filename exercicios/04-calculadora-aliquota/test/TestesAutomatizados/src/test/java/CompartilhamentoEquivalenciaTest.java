import component.PageActions;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
public class CompartilhamentoEquivalenciaTest {
    private PageActions pageActions;
    private final String NOME = "TESTE", ALTURA = "2.0", PESO = "100.0";

    @BeforeEach
    private void setUp() {
        pageActions = new PageActions();
    }

    @Test
    public void ts01() {
        Assertions.assertThrows(
                Exception.class,
                () -> pageActions.retornaEstadoCorporal("", "", "")
        );
    }

    @Test
    public void ts02() {
        Assertions.assertThrows(
                Exception.class,
                () -> pageActions.retornaEstadoCorporal(NOME, "-1", ALTURA)
        );
    }

    @Test
    public void ts03() {
        Assertions.assertThrows(
                Exception.class,
                () -> pageActions.retornaEstadoCorporal(NOME, PESO, "-1")
        );
    }

    @Test
    public void ts04() {
        Assertions.assertThrows(
                Exception.class,
                () -> pageActions.retornaEstadoCorporal(NOME.concat("1"), PESO, ALTURA)
        );
    }

    @Test
    public void ts05() {
        Assertions.assertThrows(
                Exception.class,
                () -> pageActions.retornaEstadoCorporal(NOME, PESO.concat("a"), ALTURA)
        );
    }

    @Test
    public void ts06() {
        Assertions.assertThrows(
                Exception.class,
                () -> pageActions.retornaEstadoCorporal(NOME, PESO, ALTURA.concat("a"))
        );
    }

    @Test
    public void ts07() {
        Assertions.assertThrows(
                Exception.class,
                () -> pageActions.retornaEstadoCorporal(NOME, PESO, "101")
        );
    }

    @AfterEach
    private void tearUp(){
        pageActions.fechaJanela();
    }
}