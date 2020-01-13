package RPIS71.Badykov.wdad.learn.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="library")
@XmlAccessorType(XmlAccessType.FIELD)

public class Library {
    @XmlElement(name = "reader")
    private List<Reader> readers = new ArrayList<Reader>();

    public Library() {
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

}