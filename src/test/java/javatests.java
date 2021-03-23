import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import  org.apache.commons.lang3.StringUtils;
import java.util.*;
import java.util.stream.Collectors;


public class javatests {
    public WebDriver webDriver;

    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://www.saucedemo.com");
        WebElement Name= webDriver.findElement(By.xpath("//input[@id='user-name']"));
        Name.sendKeys("standard_user");
        WebElement Password= webDriver.findElement(By.xpath("//input[@id='password']"));
        Password.sendKeys("secret_sauce");
        WebElement submit = webDriver.findElement(By.id("login-button"));
        submit.click();
    }

@Test
public void SortedAZ(){
      select selectPage = new select(webDriver);
      selectPage.selectedAZ();
      filterAtoZ();




}
@Test
public void SortedZA(){
    select selectPage = new select(webDriver);
    selectPage.selectedZA();
    filterZtoA();
}

@Test
public void SortedHignToLow(){
    select selectPage = new select(webDriver);
    selectPage.selectedHighToLow();
    filterHignToLow();

}

@Test
public void SortedLowToHigh(){
    select selectPage = new select(webDriver);
    selectPage.selectedLowToHigh();
    filterLowToHigh();

}

    public void filterAtoZ() {
        List<WebElement> allcount = webDriver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        for (int i = 0; i < allcount.size(); i++) {
            String sortedbysite = allcount.get(i).getText();
            Collection<String> collection = Arrays.asList(sortedbysite);
            List<String> sortedBymetod = collection.stream().sorted().collect(Collectors.toList());
            Assert.assertEquals( StringUtils.join(sortedBymetod," "),sortedbysite);

        }
    }
    public void filterZtoA(){
        List<WebElement> allcount = webDriver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        for (int i = 0; i < allcount.size(); i++){
            String sortedbysite = allcount.get(i).getText();
            Collection<String> collection= Arrays.asList(sortedbysite);
            List<String> sortedByRevers=collection.stream().sorted((o1, o2) -> -o1.compareTo(o2)).collect(Collectors.toList());
            Assert.assertEquals(StringUtils.join(sortedByRevers," "),sortedbysite);
        }
    }

    public void filterHignToLow(){
        List<WebElement> allcount = webDriver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for (int i =0;i<allcount.size();i++){
            String sortedbysite = allcount.get(i).getText();
             List<String> collection= Arrays.asList(sortedbysite);
             List<String> sortedByRevers=collection.stream().sorted((o1, o2) -> -o1.compareTo(o2)).collect(Collectors.toList());
             Assert.assertEquals(StringUtils.join(sortedByRevers," "),sortedbysite);

        }
    }

    public void filterLowToHigh() {
        List<WebElement> allcount = webDriver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for (int i = 0; i < allcount.size(); i++) {
            String sortedbysite = allcount.get(i).getText();
            Collection<String> collection = Arrays.asList(sortedbysite);
            List<String> sortedBymetod = collection.stream().sorted().collect(Collectors.toList());
            Assert.assertEquals(StringUtils.join(sortedBymetod, " "), sortedbysite);


        }
    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}
