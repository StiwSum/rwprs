package RPIS71.Badykov.wdad.learn.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;

public class XmlTask {
  /*  Интерфейс класса (публичные методы):
    public List<Reader> negligentReaders() –
    возвращающий список читателей – должников (у которых книга на руках уже более 2-х недель).

    public void removeBook (Reader reader, Book book) –
    удаляющий запись о книге у заданного читателя.
    Записывает результат в этот же xml-документ.

    public void addBook (Reader reader, Book book) –
    добавляющий запись о книге заданному читателю.
    Записывает результат в этот же xml-документ.

    public List<Book> debtBooks (Reader reader) –
    возвращает список книг заданного читателя, которые
    он должен был вернуть*/

    private Library library;
    private String path;

    public XmlTask(String path) throws JAXBException {
        this.path = path;
        readAsObjects(this.path);
    }

    public XmlTask() {
    }

    public Library getLibrary() {
        return library;
    }

    public List<Reader> negligentReaders() throws FileNotFoundException, XMLStreamException {
        List<Reader> negligentReaders = new ArrayList<Reader>();
        List<Reader> readers = this.library.getReaders();
        System.out.println(readers);
        for (Reader reader : readers) {
            System.out.println(LocalDate.now().getDayOfMonth() - reader.getTakeDate().getDd());
            if (LocalDate.now().getDayOfYear() - (LocalDate.of(reader.getTakeDate().getYyyy(),
                    reader.getTakeDate().getMm(),
                    reader.getTakeDate().getDd())).getDayOfYear() > 14) {
                negligentReaders.add(reader);
            }
        }
        return negligentReaders;
    }

    public void removeBook(Reader searchingReader, Book book) throws JAXBException, FileNotFoundException {
        List<Reader> readers = this.library.getReaders();
        for (Reader reader : readers) {
            if (reader.equals(searchingReader)) {
                if (reader.getBooks().isEmpty()) {
                    readers.remove(reader);
                    writeAsXmlObjects(reader);
                } else {
                    reader.getBooks().remove(book);
                    writeAsXmlObjects(reader);
                }
            }
        }

    }

    public void addBook(Reader searchingReader, Book book) throws JAXBException, FileNotFoundException {
//        reader.setBooks(reader.getBooks().add(book));
//        writeAsXmlObjects(reader);
        List<Reader> readers = this.library.getReaders();
        for (Reader reader : readers) {
            if (reader.equals(searchingReader)) {
                reader.setBooks(book);
                writeAsXmlObjects(reader);
            }
        }
    }

    public List<Book> debtBooks(Reader serchingReader) throws FileNotFoundException, XMLStreamException {
        List<Reader> negligentReaders = negligentReaders();
        for (Reader reader : negligentReaders) {
            if (reader.equals(serchingReader)) {
                return reader.getBooks();
            }
        }
        return null;
    }

    private void readAsObjects(String path) throws JAXBException {
        File file = new File(this.path);
        JAXBContext context = JAXBContext.newInstance(Library.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        this.library = (Library) unmarshaller.unmarshal(file);
    }

    public void writeAsXmlObjects(Reader reader) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Library.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(this.library, new FileOutputStream(this.path));
    }

    public void print() {
        for (Reader reader : this.library.getReaders()) {
            System.out.println(reader.toString());
        }
    }

}
