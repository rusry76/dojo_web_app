package server.model.document.entity.Folder;

import javax.persistence.*;

@Entity
@Table(name = "folder")
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "parentId")
    private long parentId;

    @Column(name = "folder_name")
    private String name;

    @Column(name = "description")
    private String description;

    // TODO: 01.03.2017
    //private Collection<DOCUMENT> documents


    public Folder() {
    }

    public Folder(long parentId, String name, String description) {
        this.parentId = parentId;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
