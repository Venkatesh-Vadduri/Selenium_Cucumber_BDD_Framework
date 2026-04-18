import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Travelpage_TC01 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(3000);
        List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
        for ( WebElement option : options){
           if( option.getText().equalsIgnoreCase("INDIA")){
               option.click();
               break;
           }
        }
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.cssSelector("a[value='HYD']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath( "(//a[@value='JAI'])[2]")).click();
        driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']")).click();
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);
        for(int a=1;a<=4;a++){
        driver.findElement(By.id("hrefIncAdt")).click();
        }
        Thread.sleep(1000);
        for(int b=1;b<=3;b++){
            driver.findElement(By.id("hrefIncChd")).click();
        }
        Thread.sleep(1000);
        for(int c=1;c<=2;c++){
            driver.findElement(By.id("hrefIncInf")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        String textmsg = driver.findElement(By.id("divpaxinfo")).getText();
        Assert.assertEquals(textmsg,"5 Adult, 3 Child, 2 Infant");
        WebElement currencyoptions = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select currency = new Select(currencyoptions);
        currency.selectByIndex(3);
        String text = currency.getFirstSelectedOption().getText();
        Assert.assertEquals(text,"USD");
        currency.selectByVisibleText("AED");
        String text1 = currency.getFirstSelectedOption().getText();
        Assert.assertEquals(text1,"AED");
        currency.selectByValue("INR");
        String text2 = currency.getFirstSelectedOption().getText();
        Assert.assertEquals(text2,"INR");
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
        driver.quit();







    }



}
