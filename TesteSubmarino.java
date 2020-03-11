import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteSubmarino {	

	@Test
	public void Teste_Produto() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.submarino.com.br/");
		Thread.sleep(2000);
		driver.findElement(By.id("h_search-input")).sendKeys("Smartphone Xiaomi Redmi 8A");
		driver.findElement(By.id("h_search-btn")).click();
		driver.findElement(By.xpath("//*[@class='ProductInfo-bwhjk3-6 ieeQoP TextUI-sc-12tokcy-0 CIZtP']")).click();
		String atual = driver.findElement(By.id("product-name-default")).getText();

		assertEquals("Smartphone Xiaomi Redmi 8A", atual);
		Thread.sleep(2000);
        //colocar no carrinho e validar
		System.out.println("Incerindo produto no carrinho");
		driver.findElement(By.xpath("//*[@class='SvgWrapper-sc-1i9za0i-2 gyoPMm ViewUI-sc-1ijittn-6 iXIDWU']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='Wrapper-sc-1i9za0i-3 ibqKJd ViewUI-sc-1ijittn-6 iXIDWU']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='Wrapper-sc-1i9za0i-3 ibqKJd ViewUI-sc-1ijittn-6 iXIDWU']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("cep")).click();
		String carrinho = driver.findElement(By.xpath("//*[@class='link-default clearfix']")).getText();
		assertEquals("Smartphone Xiaomi Redmi 8A", carrinho);
		driver.quit();
	
			
	}

}
