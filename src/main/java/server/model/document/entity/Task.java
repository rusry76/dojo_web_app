package server.model.document.entity;

import server.model.staff.entity.Person;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Task")
public class Task extends AbstractDocument {

    @Column(name = "task_date") //дата задания
    private Date taskDate;

    @Column(name = "max_date_period") //срок исполнения задания
    private int maxDatePeriod;

    @ManyToOne
    private Person responsiblePerson; //ответственное лицо

    @Column(name = "control_sign") //признак контрольности
    private boolean controlSign;

    @OneToOne
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

    @Override
    public String toString() {
        return "Task{" +
                "taskDate=" + taskDate +
                ", maxDatePeriod=" + maxDatePeriod +
                ", responsiblePerson='" + responsiblePerson + '\'' +
                ", controlSign=" + controlSign +
                ", taskController='" + taskController + '\'' +
                '}';
    }
}
