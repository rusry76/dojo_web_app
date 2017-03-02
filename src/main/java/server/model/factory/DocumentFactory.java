package server.model.factory;

import server.model.document.Generator;
import server.model.document.entity.*;
import server.model.staff.entity.Person;


public class DocumentFactory {

    public AbstractDocument getDocument(Object object) {
        AbstractDocument document = null;
        if (object instanceof Incoming) {
            document = new Incoming();
            document.setName(Generator.generateRandomString());
            document.setText(Generator.generateRandomString());
            document.setRegistrationNumber(Generator.generateRandomInt());
            document.setRegistrationDate(Generator.generateNewDate());
            document.setAuthor(Generator.generateRandomPerson());
            Incoming incomingDoc = ((Incoming) document);
            incomingDoc.setSender(Generator.generateRandomPerson());
            incomingDoc.setRecipient(new Person());
            incomingDoc.setOutgoingNumber(Generator.generateRandomInt());
            incomingDoc.setOutgoingDate(Generator.generateNewDate());

        } else if (object instanceof Outgoing) {
            document = new Outgoing();
            document.setName(Generator.generateRandomString());
            document.setText(Generator.generateRandomString());
            document.setRegistrationNumber(Generator.generateRandomInt());
            document.setRegistrationDate(Generator.generateNewDate());
            document.setAuthor(Generator.generateRandomPerson());
            Outgoing outgoingDoc = ((Outgoing) document);
            outgoingDoc.setRecipient(Generator.generateRandomPerson());
            outgoingDoc.setDeliveryMethod(Generator.generateRandomString());

        } else if (object instanceof Task) {
            document = new Task();
            document.setName(Generator.generateRandomString());
            document.setText(Generator.generateRandomString());
            document.setRegistrationNumber(Generator.generateRandomInt());
            document.setRegistrationDate(Generator.generateNewDate());
            document.setAuthor(Generator.generateRandomPerson());
            Task task = ((Task) document);
            task.setTaskDate(Generator.generateNewDate());
            task.setMaxDatePeriod(Generator.generateRandomInt());
            task.setResponsiblePerson(Generator.generateRandomPerson());
            task.setControlSign(Generator.generateRandomBoolean());
            task.setTaskController(Generator.generateRandomPerson());
        }

        return document;
    }
}
