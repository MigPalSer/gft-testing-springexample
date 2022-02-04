package selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

public class SeleniumTest {

	private WebDriver driver;
	
	@Test
	void holaSelenium() {
	    System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver");
	    driver = new ChromeDriver();
	    driver.get("https://the-internet.herokuapp.com/");	  
	    assertTrue(driver.getTitle().equals(""));
	    driver.quit();
	}
	
}
