package server.dao.folder;

import server.model.document.entity.Folder.Folder;

import javax.ejb.Local;
import java.util.Collection;

@Local
public interface FolderDAOLocal {

    public void add(Folder folder);

    public void edit(Folder folder);

    public void remove(long id);

    public Folder findById(long id);

    public Collection<Folder> getAll();
}
