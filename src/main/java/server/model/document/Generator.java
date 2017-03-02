package server.model.document;

import server.model.staff.entity.Person;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Generator {
    private static List<Person> persons;

    static {
        createList();
    }

    public static String generateRandomString() {
        String symbols = "абвгдежздийклмнопрстуфхцчшщьыъэюя";
        StringBuilder randomString = new StringBuilder();

        int count = (int)(Math.random() * 20);
        for (int i = 0; i < count; i++) {
            randomString.append(symbols.charAt((int) (Math.random() * symbols.length())));
        }

        return randomString.toString();
    }

    public static int generateRandomInt() {
        return (int) (Math.random() * Integer.MAX_VALUE);
    }

    public static Date generateNewDate() {
        return new Date();
    }

    public static boolean generateRandomBoolean() {
        boolean response = false;

        int randInt = (int) (Math.random() * 2);

        if (randInt == 0) {
            response = false;
        }

        if (randInt == 1) {
            response = true;
        }

        return response;
    }

    public static Person generateRandomPerson() {
        int randInd = (int) (Math.random() * persons.size());

        return persons.get(randInd);
    }

    private static void createList() {
        persons = new LinkedList<>();
        Person daniil = new Person();
        daniil.setLastName("Yushenkov");
        daniil.setFirstName("Daniil");
        daniil.setPatronymicName("Vsevolodovich");
        daniil.setWorkPosition("Developer");

        Person maksim = new Person();
        maksim.setLastName("Maksimov");
        maksim.setFirstName("Maksim");
        maksim.setPatronymicName("Ivanovich");
        maksim.setWorkPosition("Analitic");

        Person olesya = new Person();
        olesya.setLastName("Konuhova");
        olesya.setFirstName("Olesya");
        olesya.setPatronymicName("Victorovna");
        olesya.setWorkPosition("Support");

        Person timur = new Person();
        timur.setLastName("Hairulin");
        timur.setFirstName("Timur");
        timur.setPatronymicName("Radikovich");
        timur.setWorkPosition("Support");

        persons.add(daniil);
        persons.add(maksim);
        persons.add(olesya);
        persons.add(timur);
    }
}
