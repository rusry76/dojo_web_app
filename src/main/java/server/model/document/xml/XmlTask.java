package server.model.document.xml;

import server.model.staff.entity.Person;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "Task")
public class XmlTask extends XmlAbstractDocument {

    private Date taskDate; //дата задания

    private int maxDatePeriod; //срок исполнения задания

    private Person responsiblePerson; //ответственное лицо

    private boolean controlSign; //признак контрольности

    private Person taskController; //контролер получения

    public Date getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }

    public int getMaxDatePeriod() {
        return maxDatePeriod;
    }

    public void setMaxDatePeriod(int maxDatePeriod) {
        this.maxDatePeriod = maxDatePeriod;
    }

    public Person getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(Person responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public boolean isControlSign() {
        return controlSign;
    }

    public void setControlSign(boolean controlSign) {
        this.controlSign = controlSign;
    }

    public Person getTaskController() {
        return taskController;
    }

    public void setTaskController(Person taskController) {
        this.taskController = taskController;
    }
}
