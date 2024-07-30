package handlingWindowAssignment;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowHandling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		driver.findElement(By.cssSelector("a[href='/windows']")).click();
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		Set<String> stringTraverse = driver.getWindowHandles();
		Iterator<String> i = stringTraverse.iterator();
		String parentId = i.next();
		driver.switchTo().window(i.next());
		
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
		
		
		
	}

}
