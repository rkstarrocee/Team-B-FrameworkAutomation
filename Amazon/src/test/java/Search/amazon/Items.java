package Search.amazon;

import Common.Base;
import dataToSearch.ItemsToBeSearched;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_factory.SearchItems;
import utility.ConnectDB;

import java.io.IOException;
import java.util.List;

/**
 * Created by AFMErshadul on 8/30/2016.
 */
public class Items extends Base {

    //Test-4: using data from excel file
     @Test
    public void searchUsingExcelFile()throws IOException,InterruptedException{
         //initialize Search page factory
        SearchItems search = PageFactory.initElements(driver, SearchItems.class);
         //Read search.data from excel file
        ItemsToBeSearched itemsToBeSearched = new ItemsToBeSearched();
        String [] value = itemsToBeSearched.getData();
        // String [] category =
         for(String read:value) {
             search.searchFor(read);
             sleepFor(2);

             search.clearSearchInput();
         }
    }

//    @Test
//    public void searchUsingDB()throws Exception,InterruptedException{
//        //initialize Search page factory
//        SearchItems search = PageFactory.initElements(driver, SearchItems.class);
//        //Read Data From Database
//        ConnectDB db = new ConnectDB();
//        List<String> st = db.readDataBase();
//        for(String data:st) {
//            search.searchFor(data);
//            sleepFor(2);
//            search.clearSearchInput();
//        }
//    }
    @Test
     //One Data Driven Option to supply search.data from Data Provider
    @DataProvider(name = "items")
    public Object[][] createData(){
        return new Object[][]{
                {"Books"} ,
                {"Baby"} ,
                {"Computer"},
        };
    }

    //@Test(dataProvider = "items")
    public void searchUsingDataProvider(String data)throws InterruptedException{
        //initialize Search page factory
        SearchItems search = PageFactory.initElements(driver, SearchItems.class);
            search.searchFor(data);
            sleepFor(2);
            search.clearSearchInput();
    }
}
