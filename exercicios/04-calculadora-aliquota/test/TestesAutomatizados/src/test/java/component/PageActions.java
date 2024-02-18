package component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageActions {
    private WebDriver driver;
    private final String PATH_DRIVER = System.getProperty("user.dir") +"\\drivers\\chromedriver.exe";
    private final String NOME_PROPRIEDADE = "webdriver.chrome.driver";
    private final String SITE = "http://127.0.0.1:5500/04/front-end/index.html";

    public PageActions() {
        System.setProperty(NOME_PROPRIEDADE, PATH_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(SITE);
    }

    public String retornaEstadoCorporal(String nome, String peso, String altura) {
        try {
            insereValor("nome", nome);
            insereValor("peso", peso);
            insereValor("altura", altura);

            clicaBotao("btnCalcular");

            ativaMouseOver("indice");
        } catch (Exception ignored){}

        return driver.findElement(By.id("categoria")).getAttribute("value");
    }

    public void fechaJanela() {
        driver.quit();
    }

    private void insereValor(String name, String valor) {
        driver
                .findElement(By.name(name))
                .sendKeys(valor);
    }

    private void clicaBotao(String name) {
        driver
                .findElement(By.id(name))
                .click();
    }

    private void ativaMouseOver(String name) {
        new Actions(driver).moveToElement(
                esperaVisibilidadeElemento(By.id(name))
        ).perform();
    }

    public WebElement esperaVisibilidadeElemento(By name) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(name));
    }
}
