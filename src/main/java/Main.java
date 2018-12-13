import com.fasterxml.jackson.databind.ObjectMapper;
import impl.StorageImpl;
import interfaces.Storage;
import model.StorNode;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

public class Main {
    private static ObjectMapper mapper = new ObjectMapper();


     public static void main(String[] args) throws Exception{
        Storage storage = new StorageImpl();

        StorNode node1 = new StorNode("content1");

        storage.add(node1);

        String testName = node1.getName();

        StorNode content2 = new StorNode("content2");

        String testName2 = content2.getName();

        storage.add(content2);

        StorNode byName = (StorNode) storage.getByName(testName2);

        String jsonPath = byName.getJsonPath();

        System.out.println(jsonPath);

        StorNode content3 = new StorNode("content3");



        storage.addByPath(content3,jsonPath);

        String testName3 = content3.getName();


        StorNode content4 = new StorNode("content4");

        storage.add(content4);

        StorNode byName1 = (StorNode)storage.getByName(content4.getName());

        StorNode content5 = new StorNode("content5");

        storage.addByPath(content5,byName1.getJsonPath());

        System.out.println(storage.getByName(testName).toString());

        System.out.println(storage.getByName(testName3).toString());

        String name = content5.getName();

        System.out.println(storage.getByName(name));

         Object parent = storage.getParent();

         System.out.println(mapper.writeValueAsString(parent));

         String xmlString = "";
        JAXBContext context = JAXBContext.newInstance(StorNode.class);
        Marshaller m = context.createMarshaller();
         m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML
          StringWriter sw = new StringWriter();
          m.marshal(parent, sw);
          xmlString = sw.toString();
          StringWriter writer = new StringWriter();
          writer.close();
          String xmlText = writer.toString();
          System.out.println(xmlText);


         System.out.println(xmlString);

    }

}



