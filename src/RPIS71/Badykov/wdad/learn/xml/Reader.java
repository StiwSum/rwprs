package RPIS71.Badykov.wdad.learn.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "reader")
class Reader {

    private int readerId;

    @XmlElement(name = "book")
    private List<Book> books;
    @XmlElement(name = "takedate")

    private TakeDate takeDate = new TakeDate();

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public void generateReaderId() {
        this.readerId = hashCode();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books.add(books);
    }

    public TakeDate getTakeDate() {
        return takeDate;
    }

    public void setTakeDate(TakeDate takeDate) {
        this.takeDate = takeDate;
    }

    @Override
    public String toString() {
        generateReaderId();
        return "READER HAS " + this.books + " AND TAKE IT IN " + this.takeDate + " id: " + this.readerId;
    }

    @Override
    public int hashCode() {
        return Math.abs(this.books.hashCode() + this.takeDate.hashCode());
    }

    public boolean equals(Reader reader) {
        if (reader.hashCode() == this.hashCode()) {
            return true;
        }
        return false;
    }
}