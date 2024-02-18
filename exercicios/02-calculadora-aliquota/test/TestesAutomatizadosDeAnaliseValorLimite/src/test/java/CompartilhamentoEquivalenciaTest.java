import component.PageActions;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@Slf4j
public class CompartilhamentoEquivalenciaTest {
    private PageActions pageActions;
    private final String NOME = "TESTE", CPF = "51248547829";

    @BeforeEach
    private void setUp() {
        pageActions = new PageActions();
    }

    @Test
    public void ts01() {
        Assertions.assertThrows(
                Exception.class,
                () -> pageActions.retornaAliquota("", "", "")
        );
    }

    @Test
    public void ts02() {
        Assertions.assertThrows(
                Exception.class,
                () -> pageActions.retornaAliquota(NOME, "-1", CPF)
        );
    }

    @Test
    public void ts03() {
        Assertions.assertThrows(
                Exception.class,
                () -> pageActions.retornaAliquota(NOME, "0", "000.000.000-00")
        );
    }

    @Test
    public void ts04() {
        Assertions.assertThrows(
                Exception.class,
                () -> pageActions.retornaAliquota(NOME.concat("123"), "0", CPF)
        );
    }

    @Test
    public void ts05() {
        Assertions.assertThrows(
                Exception.class,
                () -> pageActions.retornaAliquota(NOME, "0a", CPF)
        );
    }

    @AfterEach
    private void tearUp(){
        pageActions.fechaJanela();
    }
}