package RPIS71.Badykov.wdad.learn.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author еркыпе
 */
@XmlRootElement(name = "author")
public class Author {

    private String firstName;

    private String secondName;

    public String getFirstName() {
        return firstName;
    }

    @XmlElement(name = "firstname")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    @XmlElement(name = "secondname")
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.secondName;
    }

}