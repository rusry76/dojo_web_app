package server.model.parser;


import javax.xml.bind.JAXBException;
import java.io.File;

public interface Parser {

    public Object getObject(File file, Class c) throws JAXBException;

    public void saveObject(File file, Object obj) throws JAXBException;
}
