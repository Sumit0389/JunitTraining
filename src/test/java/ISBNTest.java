import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ISBNTest {

   @Test
    public void checkValid10ISBN()
    {
      ISBNClass isbnClass = new ISBNClass();
       boolean result =isbnClass.checkIsbn("9389432014");
       assertTrue(result, "First Value");
       result =isbnClass.checkIsbn("9389432014");
       assertTrue(result, "second Value");
    }

@Test
    public void checkValid13digitISBNNumeber() {
    ISBNClass isbnClass = new ISBNClass();
    boolean result = isbnClass.checkIsbn("9781853250087");
    assertTrue(result, "First Line");


    result = isbnClass.checkIsbn("9781853267338");
    assertTrue(result, "Second Line Line");
}

@Test
        public void checkinvalid13DigitISBNNumber()
        {
            ISBNClass isbnClass = new ISBNClass();
            boolean result =isbnClass.checkIsbn("9781853250089");
            assertFalse(result);
        }


    @Test
    public void checkInvalid10ISBN()
    {
        ISBNClass isbnClass = new ISBNClass();
        boolean result =isbnClass.checkIsbn("9389432017");
        assertFalse(result);
    }
    @Test
    public  void niniDigitISBNarenotAllowed()
    {
        ISBNClass isbnClass= new ISBNClass();
        assertThrows(NumberFormatException.class, ()->
        {
            isbnClass.checkIsbn("938943201");
        });

    }
   @Test
    public void ISBN10NumbersEndingInAnXAreValid()
    {
        ISBNClass isbnClass = new ISBNClass();
        boolean result =isbnClass.checkIsbn("012000030X");
        assertTrue(result, "First Value");
    }
    @Test
    public void onlyvalidDigitAllowed()
    {
        ISBNClass isbnClass= new ISBNClass();
        assertThrows(NumberFormatException.class, ()->
        {
           isbnClass.checkIsbn("abcdefghij") ;
        });

    }





}
