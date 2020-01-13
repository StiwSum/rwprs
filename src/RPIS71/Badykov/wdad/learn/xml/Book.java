package RPIS71.Badykov.wdad.learn.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "book")
class Book {

    @XmlElement(name = "author")
    private Author author;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "printyear")
    private String printyear;
    @XmlElement(name = "genre")
    private Genre genre;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrintYear() {
        return printyear;
    }

    public void setPrintYear(String printyear) {
        this.printyear = printyear;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "BOOK IS " + this.name + " BY " + this.author + " PRINT IN " + this.printyear + " GENRE " + getGenre();
    }
}
