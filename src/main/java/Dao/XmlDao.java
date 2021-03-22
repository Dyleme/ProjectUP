package Dao;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class XmlDao<T> extends AbstractDao<T> {




    @Override
    public void write(List<T> list) throws IOException {
        Wrapper<T> wrapper = new Wrapper<>(list);
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(wrapper, new File(fileName));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> read() throws IOException {
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            return ((Wrapper<T>) context.createUnmarshaller()
                    .unmarshal(new FileReader(fileName))).getItems();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public XmlDao(String fileName){
        super(fileName);
    }
}
