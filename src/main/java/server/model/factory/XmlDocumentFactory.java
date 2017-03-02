package server.model.factory;


import server.model.document.Generator;
import server.model.document.xml.XmlAbstractDocument;
import server.model.document.xml.XmlIncoming;
import server.model.document.xml.XmlOutgoing;
import server.model.document.xml.XmlTask;
import server.model.staff.entity.Person;

public class XmlDocumentFactory {
    public XmlAbstractDocument getDocument(Object object) {
        XmlAbstractDocument xmlDocument = null;
        if (object instanceof XmlIncoming) {
            xmlDocument = new XmlIncoming();
            xmlDocument.setName(Generator.generateRandomString());
            xmlDocument.setText(Generator.generateRandomString());
            xmlDocument.setRegistrationNumber(Generator.generateRandomInt());
            xmlDocument.setRegistrationDate(Generator.generateNewDate());
            xmlDocument.setAuthor(new Person());
            XmlIncoming xmlIncomingDoc = ((XmlIncoming) xmlDocument);
            xmlIncomingDoc.setSender(new Person());
            xmlIncomingDoc.setRecipient(new Person());
            xmlIncomingDoc.setOutgoingNumber(Generator.generateRandomInt());
            xmlIncomingDoc.setOutgoingDate(Generator.generateNewDate());

        } else if (object instanceof XmlOutgoing) {
            xmlDocument = new XmlTask();
            xmlDocument.setName(Generator.generateRandomString());
            xmlDocument.setText(Generator.generateRandomString());
            xmlDocument.setRegistrationNumber(Generator.generateRandomInt());
            xmlDocument.setRegistrationDate(Generator.generateNewDate());
            xmlDocument.setAuthor(new Person());
            XmlOutgoing xmlOutgoingDoc = ((XmlOutgoing) xmlDocument);
            xmlOutgoingDoc.setRecipient(new Person());
            xmlOutgoingDoc.setDeliveryMethod(Generator.generateRandomString());

        } else if (object instanceof XmlTask) {
            xmlDocument = new XmlTask();
            xmlDocument.setName(Generator.generateRandomString());
            xmlDocument.setText(Generator.generateRandomString());
            xmlDocument.setRegistrationNumber(Generator.generateRandomInt());
            xmlDocument.setRegistrationDate(Generator.generateNewDate());
            xmlDocument.setAuthor(new Person());
            XmlTask xmlTask = ((XmlTask) xmlDocument);
            xmlTask.setTaskDate(Generator.generateNewDate());
            xmlTask.setMaxDatePeriod(Generator.generateRandomInt());
            xmlTask.setResponsiblePerson(new Person());
            xmlTask.setControlSign(Generator.generateRandomBoolean());
            xmlTask.setTaskController(new Person());
        }

        return xmlDocument;
    }
}
