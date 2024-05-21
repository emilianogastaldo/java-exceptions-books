package books;

public class Book {
    private String title;
    private int pageNumber;
    private String author;
    private String editor;

    Book(String title, int pageNumber, String author, String editor){
        this.title = isValid(title);
        this.pageNumber = isValid(pageNumber);
        this.author = isValid(author);
        this.editor = isValid(editor);
    }

    private String isValid(String value) throws SecurityException{
        if (value == null || value.isEmpty()){
            throw new SecurityException("Non puoi mettere una stringa vuota");
        }
        return value;
    }

    private int isValid(int value) throws SecurityException{
        if(value <=0 ){
            throw new SecurityException("Il numero di pagine non può essere negativo");
        }
        return value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = isValid(title);
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = isValid(pageNumber);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = isValid(author);
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = isValid(editor);
    }

    @Override
    public String toString(){
        return "{Titolo libro: " + title + " Numero di pagine: " + pageNumber + " Autore: "+author+" Editore: "+editor+ "}";
    }

}
