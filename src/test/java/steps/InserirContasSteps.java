package steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class InserirContasSteps {
	
	WebDriver driver;
	
	@Dado("^que estou acessando a aplicação$")
	public void queEstouAcessandoAAplicação() throws Throwable {		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.get("https://srbarriga.herokuapp.com/");
	}

	@Quando("^informo o usuário \"([^\"]*)\"$")
	public void informoOUsuário(String email) throws Throwable {
	    driver.findElement(By.id("email")).sendKeys(email);	    
	}

	@Quando("^a senha \"(.*)\"$")
	public void aSenha(String senha) throws Throwable {
	    driver.findElement(By.id("senha")).sendKeys(senha);
	}

	@Quando("^seleciono entrar$")
	public void selecionoEntrar() throws Throwable {
	    driver.findElement(By.cssSelector(".btn.btn-primary")).click();
	}

	@Então("^visualizo a página inicial$")
	public void visualizoAPáginaInicial() throws Throwable {
	    String texto = driver.findElement(By.xpath("/html/body/div[1]")).getText();
	    Assert.assertEquals("Bem vindo, Dayanne Costa!", texto);
	}

	@Quando("^seleciono Contas$")
	public void selecionoContas() throws Throwable {
	    driver.findElement(By.linkText("Contas")).click();
	}

	@Quando("^seleciono Adicionar$")
	public void selecionoAdicionar() throws Throwable {
		driver.findElement(By.linkText("Adicionar")).click();
	}

	@Quando("^informo a conta \"([^\"]*)\"$")
	public void informoAConta(String arg1) throws Throwable {
	    driver.findElement(By.id("nome")).sendKeys(arg1);
	}

	@Quando("^seleciono Salvar$")
	public void selecionoSalvar() throws Throwable {
	    driver.findElement(By.cssSelector(".btn.btn-primary")).click();
	}

	@Então("^a conta é inserida com sucesso$")
	public void aContaÉInseridaComSucesso() throws Throwable {
	    String expected = driver.findElement(By.xpath("/html/body/div[1]")).getText();
	    Assert.assertEquals("Conta adicionada com sucesso!", expected);
	    
	}

	@Então("^sou notificar que o nome da conta é obrigatório$")
	public void souNotificarQueONomeDaContaÉObrigatório() throws Throwable {
	    String mensagem = driver.findElement(By.xpath("/html/body/div[1]")).getText();
	    Assert.assertEquals("Informe o nome da conta", mensagem);
	   
	}
	
	@Então("^sou notificado que já existe uma conta com esse nome$")
	public void souNotificadoQueJáExisteUmaContaComEsseNome() throws Throwable {
		String mensagem = driver.findElement(By.xpath("/html/body/div[1]")).getText();
	    Assert.assertEquals("Já existe uma conta com esse nome!", mensagem);
	    
	}
	
	@After(order = 1)
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshots/"+cenario.getId()+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After(order = 0)
	public void closeBrowser() {
		driver.quit();
	}

}
