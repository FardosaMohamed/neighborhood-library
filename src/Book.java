public class Book {
    // Properties
    int id;
    String isbn;
    String title;
    boolean isCheckedOut;
    String checkedOutTo;

    // Constructor
    Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = null;
    }

    // Getters
    public int getId() {  return this.id; }
    public String getIsbn() { return this.isbn; }
    public String getTitle() {  return this.title; }
    public boolean isCheckedOut() { return this.isCheckedOut; }

    public String getCheckedOutBy() {
        return checkedOutTo;
    }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setTitle(String title) { this.title = title;}
    public void setCheckedOut(boolean isCheckedOut) { this.isCheckedOut = isCheckedOut; }
    public void setCheckedOutTo(String checkedOutTo) { this.checkedOutTo = checkedOutTo; }


    public void checkOut(String name){
         this.checkedOutTo = name;
         this.isCheckedOut = true;

    }

    public void checkIn(){
        this.checkedOutTo = null;
        this.isCheckedOut = false;
    }



}
