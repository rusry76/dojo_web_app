package server.model.document.entity;

import server.model.staff.entity.Person;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class AbstractDocument implements Comparable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name") //название документа
    private String name;

    @Column(name = "text") //текст документа
    private String text;

    @Column(name = "registration_number", unique = true) //регистрационный номер
    private long registrationNumber;

    @Column(name = "registration_date") //дата регистрации документа
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

    @ManyToOne
    //@Column(name = "author") // Не ставится, так как колонка с таким наименование не будет создана в БД
    private Person author; //автор документа

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    @Override
    public int compareTo(Object o) {
        int n = 0;
        if (o instanceof Date) {
            n = compareToDate((Date) o);
        }

        if (o instanceof Long) {
            n = compareToLong((Long) o);
        }

        return n;
    }

    public int compareToLong(long regNumber) {
        return registrationNumber < regNumber ? -1 : (registrationNumber == regNumber ? 0 : 1);
    }

    public int compareToDate(Date regDate) {
        return registrationDate.compareTo(regDate);
    }

    @Override
    public String toString() {
        return "AbstractDocument{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", text='" + text + '\'' +
                ", registrationNumber=" + registrationNumber +
                ", registrationDate=" + registrationDate +
                ", author='" + author + '\'' +
                '}';
    }
}
