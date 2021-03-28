import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class javatests {
    public WebDriver webDriver;

    @Before
    public void start() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://www.saucedemo.com");
        new StartPage(webDriver).enterlogpass("standard_user","secret_sauce");
    }

@Test
public void SortedAZ(){
      select selectPage = new select(webDriver);
      selectPage.selectedAZ();
      select.filterAtoZ();
      Assert.assertTrue(select.filterAtoZ());


}
@Test
public void SortedZA(){
    select selectPage = new select(webDriver);
    selectPage.selectedZA();
    select.filterZtoA();
    Assert.assertTrue(select.filterZtoA());
}

@Test
public void SortedHignToLow(){
    select selectPage = new select(webDriver);
    selectPage.selectedHighToLow();
    select.filterHignToLow();

}

@Test
public void SortedLowToHigh(){
    select selectPage = new select(webDriver);
    selectPage.selectedLowToHigh();
    select.filterLowToHigh();

}

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}
