import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Travelpage_TC01 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver(); //launching chrome browser
        driver.manage().window().maximize();   //maximising the window
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");  //launching the application
        driver.findElement(By.id("autosuggest")).sendKeys("ind"); //selecting the country option
        Thread.sleep(3000); //waiting to load the page
        List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a")); //finding the all available options for the given country text
        for ( WebElement option : options){
           if( option.getText().equalsIgnoreCase("INDIA")){
               option.click();
               break;
           }
        }
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); //click from departure element
        driver.findElement(By.cssSelector("a[value='HYD']")).click(); // clicking on the from departure city
        Thread.sleep(1000);
        driver.findElement(By.xpath( "(//a[@value='JAI'])[2]")).click(); // clicking on the To arraival city
        driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']")).click();  // clicking travel date
        driver.findElement(By.id("divpaxinfo")).click(); // clicking on the passenger dropdown
        Thread.sleep(1000);
        for(int a=1;a<=4;a++){
        driver.findElement(By.id("hrefIncAdt")).click();  //selecting adults count=5
        }
        Thread.sleep(1000);
        for(int b=1;b<=3;b++){
            driver.findElement(By.id("hrefIncChd")).click(); //selecting adults child=3
        }
        Thread.sleep(1000);
        for(int c=1;c<=2;c++){
            driver.findElement(By.id("hrefIncInf")).click(); //selecting adults infants=2
        }
        driver.findElement(By.id("btnclosepaxoption")).click(); //clicking the done button
        String textmsg = driver.findElement(By.id("divpaxinfo")).getText();  //getting the text msg from passenger dropdown
        Assert.assertEquals(textmsg,"5 Adult, 3 Child, 2 Infant");  //validating the text msg from passenger dropdown
        WebElement currencyoptions = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));  // clicking on the currency dropdown
        Select currency = new Select(currencyoptions);  //providing the currency dropdown knowledge to select class
        currency.selectByIndex(3);           //selecting  currency = USD
        String text = currency.getFirstSelectedOption().getText();
        Assert.assertEquals(text,"USD");
        currency.selectByVisibleText("AED"); //selecting  currency = AED
        String text1 = currency.getFirstSelectedOption().getText();
        Assert.assertEquals(text1,"AED");
        currency.selectByValue("INR");       //selecting  currency = INR
        String text2 = currency.getFirstSelectedOption().getText();
        Assert.assertEquals(text2,"INR");
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();   //selecting  family and friends check box
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();  //selecting  search button
        driver.quit();   //closing the browser







    }



}
