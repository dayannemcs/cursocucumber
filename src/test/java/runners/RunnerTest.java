package runners;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features/inserir_conta.feature",
		glue = "steps",
		tags = {"~@ignore"},
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		monochrome = false,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)
public class RunnerTest {
	
	@BeforeClass	
	public static void reset () {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		driver.get("https://srbarriga.herokuapp.com/");
		driver.findElement(By.id("email")).sendKeys("dayanne.info@gmail.com");	 
		driver.findElement(By.id("senha")).sendKeys("curso123");
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
	}

}
