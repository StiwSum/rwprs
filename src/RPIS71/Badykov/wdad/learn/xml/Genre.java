package RPIS71.Badykov.wdad.learn.xml;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author еркыпе
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "genre")
public class Genre {

    @XmlAttribute(name = "value", required = true)
    private String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString(){
        return this.genre;
    }
}
