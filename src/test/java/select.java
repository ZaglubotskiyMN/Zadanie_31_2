import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class select {
    private static WebDriver webDriver;


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

    public static boolean filterAtoZ() {
        List<WebElement> allcount = webDriver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        for (int i = 0; i < allcount.size(); i++) {
            String sortedbysite = allcount.get(i).getText();
            ArrayList<String> list= new ArrayList<>();
            list.add(sortedbysite);
            List<String> sortedBymetod = list.stream().sorted().collect(Collectors.toList());
            String finalsorted = StringUtils.join(sortedBymetod,"");
            boolean b= finalsorted.equals(sortedbysite);
            //System.out.println(b);
        }
        return true;
    }

    public static boolean filterZtoA(){
        List<WebElement> allcount = webDriver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        for (int i = 0; i < allcount.size(); i++){
            String sortedbysite = allcount.get(i).getText();
            ArrayList<String> list=new ArrayList<>();
            list.add(sortedbysite);
            List<String> sortedByRevers=list.stream().sorted((o1, o2) -> -o1.compareTo(o2)).collect(Collectors.toList());
            String finalsorted=StringUtils.join(sortedByRevers,"");
            boolean b=finalsorted.equals(sortedbysite);
            //System.out.println(b);
        }
        return true;
    }

    public static boolean filterHignToLow(){
        List<WebElement> allcount = webDriver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for (int i =0;i<allcount.size();i++){
            String sortedbysite = allcount.get(i).getText();
            ArrayList<String> list = new ArrayList<>();
            list.add(sortedbysite);
            List<String> sortedByRevers=list.stream().sorted((o1, o2) -> -o1.compareTo(o2)).collect(Collectors.toList());
            String finalsorted=StringUtils.join(sortedByRevers," ");
            boolean b =finalsorted.equals(sortedbysite);
           // System.out.println(b);

        } return true;
    }

    public static boolean filterLowToHigh() {
        List<WebElement> allcount = webDriver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for (int i = 0; i < allcount.size(); i++) {
            String sortedbysite = allcount.get(i).getText();
            ArrayList<String> list =new ArrayList<>();
            list.add(sortedbysite);
            List<String> sortedBymetod = list.stream().sorted().collect(Collectors.toList());
            String finalsorted =StringUtils.join(sortedBymetod," ");
            boolean b=finalsorted.equals(sortedbysite);
            //System.out.println(b);
            //Collection<String> collection = Arrays.asList(sortedbysite);

        } return true;
    }


}
