package AliquotaAnual.selenium.test;

import component.PageActions;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CompartilhamentoEquivalenciaTest {
    private PageActions pageActions;
    private final String NOME = "TESTE", CPF = "51248547829";

    @BeforeEach
    private void setUp() {
        pageActions = new PageActions();
    }

    @Test
    public void ts01() {
        assertThrows(
                Exception.class,
                () -> pageActions.retornaAliquota("", "", "")
        );
    }

    @Test
    public void ts02() {
        assertThrows(
                Exception.class,
                () -> pageActions.retornaAliquota(NOME, "-1", CPF)
        );
    }

    @Test
    public void ts03() {
        assertThrows(
                Exception.class,
                () -> pageActions.retornaAliquota(NOME, "0", "000.000.000-00")
        );
    }

    @Test
    public void ts04() {
        assertThrows(
                Exception.class,
                () -> pageActions.retornaAliquota(NOME.concat("123"), "0", CPF)
        );
    }

    @Test
    public void ts05() {
        assertThrows(
                Exception.class,
                () -> pageActions.retornaAliquota(NOME, "0a", CPF)
        );
    }

    @AfterEach
    private void tearUp(){
        pageActions.fechaJanela();
    }
}