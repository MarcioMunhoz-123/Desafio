import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteSubmarinoNOK {	

	private WebDriver driver;

	@Before
	public void Teste() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.submarino.com.br/");
		Thread.sleep(2000);

	}

	@Test
	public void Teste_Produto() throws InterruptedException {

		driver.findElement(By.id("h_search-input")).sendKeys("Smartphone Xiaomi Redmi 8A");
		driver.findElement(By.id("h_search-btn")).click();
		driver.findElement(By.xpath("//*[@class='ProductInfo-bwhjk3-6 ieeQoP TextUI-sc-12tokcy-0 CIZtP']")).click();
		String atual = driver.findElement(By.id("product-name-default")).getText();

		boolean encontrou = false;
		if (atual.equals("Smartphone Xiaomi Redmi 8A_NOK")) {
			encontrou = true;
		}

		assertTrue(encontrou);
	}

	@Test
	public void Teste_Carrinho() throws InterruptedException {

		// colocar no carrinho e validar
		driver.findElement(By.id("h_search-input")).sendKeys("Smartphone Xiaomi Redmi 8A");
		driver.findElement(By.id("h_search-btn")).click();
		driver.findElement(By.xpath("//*[@class='ProductInfo-bwhjk3-6 ieeQoP TextUI-sc-12tokcy-0 CIZtP']")).click();
		driver.findElement(By.xpath("//*[@class='SvgWrapper-sc-1i9za0i-2 gyoPMm ViewUI-sc-1ijittn-6 iXIDWU']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='Wrapper-sc-1i9za0i-3 ibqKJd ViewUI-sc-1ijittn-6 iXIDWU']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='Wrapper-sc-1i9za0i-3 ibqKJd ViewUI-sc-1ijittn-6 iXIDWU']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("cep")).click();
		String carrinho = driver.findElement(By.xpath("//*[@class='link-default clearfix']")).getText();

		boolean encontrou_A = false;
		if (carrinho.equals("Smartphone Xiaomi Redmi 8A_NOK")) {
			encontrou_A = true;
		}

		assertTrue(encontrou_A);
		driver.quit();
	}

}
