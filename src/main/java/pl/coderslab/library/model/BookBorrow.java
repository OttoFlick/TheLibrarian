package pl.coderslab.library.model;

public class BookBorrow {
    private String searchString;

    public BookBorrow() {
        super();
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    @Override
    public String toString() {
        return "BookSearch{" +
                "searchString='" + searchString + '\'' +
                '}';
    }
}
