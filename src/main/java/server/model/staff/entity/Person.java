package server.model.staff.entity;


import javax.persistence.*;

@Entity
@Table(name = "Person")
public class Person extends AbstractStaff {

    @Column(name = "last_name")
    private String lastName; //Фамилия

    @Column(name = "first_name")
    private String firstName; //Имя

    @Column(name = "patronymic_name")
    private String patronymicName; //Отчество

    @Column(name = "work_position")
    private String workPosition; //Должность


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + patronymicName + ", " + workPosition;
    }
}
