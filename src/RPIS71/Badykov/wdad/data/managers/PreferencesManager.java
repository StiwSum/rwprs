package RPIS71.Badykov.wdad.data.managers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.util.Objects;

public class PreferencesManager {
    public static final PreferencesManager INSTANCE = new PreferencesManager();
    private static final String FILE_PATH = "src/RPIS71/Badykov/wdad/resources/configuration/appconfig.xml";
    private static Document document;

    private PreferencesManager() {
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(FILE_PATH));
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public String getCreateRegistry() {
        return Objects.requireNonNull(getTag("createregistry")).getTextContent();
    }

    public void setCreateRegistry(String newValue) {
        Objects.requireNonNull(getTag("createregistry")).setTextContent(newValue);
        changeDocument(document);
    }

    public String getRegistryAddress() {
        return Objects.requireNonNull(getTag("registryaddress")).getTextContent();
    }

    public void setRegistryAddress(String newValue) {
        Objects.requireNonNull(getTag("registryaddress")).setTextContent(newValue);
        changeDocument(document);
    }

    public String getRegistryPort() {
        return Objects.requireNonNull(getTag("registryport")).getTextContent();
    }

    public void setRegistryPort(String newValue) {
        Objects.requireNonNull(getTag("registryport")).setTextContent(newValue);
        changeDocument(document);
    }

    public String getPolicyPath() {
        return Objects.requireNonNull(getTag("policypath")).getTextContent();
    }

    public void setPolicyPath(String newValue) {
        Objects.requireNonNull(getTag("policypath")).setTextContent(newValue);
        changeDocument(document);
    }

    public String getUseCodeBaseOnly() {
        return Objects.requireNonNull(getTag("usecodebaseonly")).getTextContent();
    }

    public void setUseCodeBaseOnly(String newValue) {
        Objects.requireNonNull(getTag("usecodebaseonly")).setTextContent(newValue);
        changeDocument(document);
    }

    public String getClassProvider() {
        return Objects.requireNonNull(getTag("classprovider")).getTextContent();
    }

    public void setClassProvider(String newValue) {
        Objects.requireNonNull(getTag("classprovider")).setTextContent(newValue);
        changeDocument(document);
    }

    private Element getTag(String tagName) {
        return (Element) document.getElementsByTagName(tagName).item(0);
    }

    private void changeDocument(Document doc) {
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(new DOMSource(doc), new StreamResult(FILE_PATH));
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}
