package server.model.staff.xml;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Staff")
@XmlAccessorType(XmlAccessType.FIELD) //Если не указать эту аннотацию, то программа подумает что все поля дублируются из-за гетторов и сетторов
public class XmlAbstractStaff {

    @XmlElement
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
