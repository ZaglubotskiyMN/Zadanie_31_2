import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class select {
    private WebDriver webDriver;


    private  WebElement selectall;



    public select(WebDriver webDriver){
        this.webDriver=webDriver;
        selectall=webDriver.findElement(By.xpath("//select[@class='product_sort_container']"));
    }


    public void selectedAZ(){
        Select SortSelect= new Select(selectall);
        SortSelect.selectByValue("az");

    }

    public void selectedZA(){
        Select SortSelect= new Select(selectall);
        SortSelect.selectByValue("za");
    }

    public void selectedLowToHigh(){
        Select SortSelect= new Select(selectall);
        SortSelect.selectByValue("lohi");
    }

    public void selectedHighToLow(){
        Select SortSelect= new Select(selectall);
        SortSelect.selectByValue("hilo");
    }
}
