public class ISBNClass {

    private static final int SHORT_ISBN_LENGTH=10;
    private static final int Long_ISBN_LENGTH=13;
    public static final int LONG_ISBN_MULTIPLIER = 10;
    public static final int SHORT_ISBN_MULTIPLIER = 11;

    public boolean checkIsbn(String  isbn) {
        
        //9389432014
        if(isbn.length()== Long_ISBN_LENGTH)
        {
            return IsTHisValidLongISBN(isbn);
        }
        else  if(isbn.length()==SHORT_ISBN_LENGTH)
        {
            return isThisValidShortISBN(isbn);
        }
        else {
            throw new NumberFormatException("ISBN numbers must be 10 digits");
        }
    }

    private static boolean isThisValidShortISBN(String isbn) {
        int total=0;
        for (int i = 0; i < SHORT_ISBN_LENGTH; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                if (i == SHORT_ISBN_LENGTH-1&& isbn.charAt(i) == 'X') {
                    total = total + SHORT_ISBN_LENGTH;
                } else
                    throw new NumberFormatException("Character are not Valid");
            } else {
                total = total + (isbn.charAt(i) - '0') * (SHORT_ISBN_LENGTH - i);
            }
        }
        return (total % SHORT_ISBN_MULTIPLIER == 0);
    }

    private static boolean IsTHisValidLongISBN(String isbn) {
        int total=0;
        for(int i=0;i<Long_ISBN_LENGTH;i++)
        {
           if(i%2==0)
           {
               total+=(isbn.charAt(i)-'0');
           }
           else
           {
               total+=(isbn.charAt(i)-'0')*3;
           }
        }
        return (total% LONG_ISBN_MULTIPLIER ==0);

    }
}
