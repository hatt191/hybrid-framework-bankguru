package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Address {
	public static String address;
	
	public static void main(String[] args) {
		setAddress("Ho Chi Minh");
		System.out.println(getAddress());
		
		setAddress("Ha Noi");
		System.out.println(getAddress());
		
		WebDriver driver = null;
		driver = new ChromeDriver();
		driver.findElement(By.xpath("")).click();
	}
	
	public static void setAddress(String add) {
		address = add;
	}
	
	public static String getAddress() {
		return address;
	}
}
