public class Book {
    private String isbn;
    private String title;
    private String auther;


// This is modified

    public Book(String isbn, String title, String auther) {
        this.isbn = isbn;
        this.title=title;
        this.auther=auther;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
