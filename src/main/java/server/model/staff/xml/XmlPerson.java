package server.model.staff.xml;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Person")
@XmlAccessorType(XmlAccessType.FIELD) //Если не указать эту аннотацию, то программа подумает что все поля дублируются из-за гетторов и сетторов
public class XmlPerson extends XmlAbstractStaff {

    @XmlElement(name = "lastName")
    private String lastName; //Фамилия

    @XmlElement(name = "firstName")
    private String firstName; //Имя

    @XmlElement(name = "patronymicName")
    private String patronymicName; //Отчество

    @XmlElement(name = "workPosition")
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
}
