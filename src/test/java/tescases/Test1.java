package tescases;

import java.io.IOException;

import org.testng.annotations.Test;

import utilities.Base;

public class Test1 extends Base {
	
	@Test
	public void FirstTest() throws IOException {
	driver = initializeDriver();
	driver.get("https://mvnrepository.com/");
	driver.quit();
	}

}
