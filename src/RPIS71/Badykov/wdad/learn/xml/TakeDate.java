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
@XmlRootElement(name = "takedate")
public class TakeDate {

    @XmlAttribute(name = "day", required = true)
    private int dd;
    @XmlAttribute(name = "month", required = true)
    private int mm;
    @XmlAttribute(name = "year", required = true)
    private int yyyy;

    public int getDd() {
        return dd;
    }

    public void setDd(int dd) {
        this.dd = dd;
    }

    public int getMm() {
        return mm;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public int getYyyy() {
        return yyyy;
    }

    public void setYyyy(int yyyy) {
        this.yyyy = yyyy;
    }

    @Override
    public String toString() {
        return this.dd + "/" + this.mm + "/" + this.yyyy;
    }
}

