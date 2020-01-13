package RPIS71.Badykov.wdad.learn.xml;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

public class TestXmlTask {
    public static void main(String[] args) throws JAXBException, FileNotFoundException, XMLStreamException {
        XmlTask task = new XmlTask("D:\\rwprs\\src\\RPIS71\\Badykov\\wdad\\learn\\xml\\library.xml");
        /* task.print();*/
        /* Reader readers = task.getLibrary().getReader().get(0);
        System.out.println(readers);*/
        /*System.out.println(task.negligentReaders());*/
       /* Book book = task.getLibrary().getReaders().get(0).getBooks().get(0);
        task.removeBook(task.getLibrary().getReaders().get(0), task.getLibrary().getReaders().get(0).getBooks().get(0));*/
        task.print();
       task.addBook(task.getLibrary().getReaders().get(0), task.getLibrary().getReaders().get(1).getBooks().get(0));
        task.print();
    }
}
