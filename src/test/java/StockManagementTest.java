import net.bytebuddy.implementation.Implementation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class StockManagementTest {
    ExternalISBNDataService testwebService;
    ExternalISBNDataService testdatabaseService;

    @BeforeEach
    public void setup()
    {  // Changes done in feature branch -mainBranch sumit Done


        testwebService = mock(ExternalISBNDataService.class);
        testdatabaseService=mock(ExternalISBNDataService.class);
        System.out.println("Setup running");
    }

    @Test
    public void testCanGetACorrectLocatorCode()
    {

/*
        ExternalISBNDataService testWeService= new ExternalISBNDataService() {
            @Override
            public Book lookup(String isbn) {
                return new Book(isbn,"Of Mice And men", "J. Steinbeck");
            }
        };
*/

      /*  ExternalISBNDataService testdatabaseService = new ExternalISBNDataService() {
            @Override
            public Book lookup(String isbn) {
                return null;
            }
        };*/

       // ExternalISBNDataService testwebService = mock(ExternalISBNDataService.class);
        when(testwebService.lookup(anyString())).thenReturn(new Book("0140177396", "off mice and me","SUmit Shrivastsva" ));

       // ExternalISBNDataService testdatabaseService = mock(ExternalISBNDataService.class);
        when(testdatabaseService.lookup(anyString())).thenReturn(null);

        StockManager stockManager = new StockManager();
        stockManager.setService(testwebService);
        stockManager.setDataBaseService(testdatabaseService);

    String isbn="0140177396";
    String locatorCode =stockManager.getLocatorCode(isbn);
 //   assertEquals("7396J4",locatorCode);

    }
    @Test
    public void databaseIsUsedIfDataIspresentinDatabase()
    {
  //   ExternalISBNDataService databaseService =mock(ExternalISBNDataService.class);
    // ExternalISBNDataService webService =mock(ExternalISBNDataService.class);
  when(testdatabaseService.lookup("0140177396")).thenReturn(new Book("0140177396","abc","abc"));
        StockManager stockManager = new StockManager();
        stockManager.setService(testwebService);
        stockManager.setDataBaseService(testdatabaseService);

        String isbn="0140177396";
        String locatorCode =stockManager.getLocatorCode(isbn);
        verify(testdatabaseService,times(1)).lookup("0140177396");
        verify(testwebService,times(0)).lookup("0140177396");
      //  assertEquals("7396J4",locatorCode);
    }
    @Test
    public void webserviceIsUsedIfdataIsNotPresentinDatabase()
    {


       // ExternalISBNDataService databaseService =mock(ExternalISBNDataService.class);
      //  ExternalISBNDataService webService =mock(ExternalISBNDataService.class);
        when(testdatabaseService.lookup("0140177396")).thenReturn(null);
        when(testwebService.lookup("0140177396")).thenReturn(new Book("0140177396","abc","abc"));
        StockManager stockManager = new StockManager();
        stockManager.setService(testwebService);
        stockManager.setDataBaseService(testdatabaseService);

        String isbn="0140177396";
        String locatorCode =stockManager.getLocatorCode(isbn);
        verify(testdatabaseService,times(1)).lookup("0140177396");
        verify(testwebService,times(1)).lookup("0140177396");
    }
}

