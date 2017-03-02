package server.rest.service.folder;

import server.dao.folder.FolderDAOLocal;
import server.model.document.entity.Folder.Folder;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.Collection;

@Stateless
public class FolderService implements IFolderService {

    @EJB
    private FolderDAOLocal folderDAOLocal;

    @Override
    public void add(Folder folder) {
        folderDAOLocal.add(folder);
    }

    @Override
    public void edit(Folder folder) {
        folderDAOLocal.add(folder);
    }

    @Override
    public void remove(long id) {
        folderDAOLocal.remove(id);
    }

    @Override
    public Folder findById(long id) {
        return folderDAOLocal.findById(id);
    }

    @Override
    public Collection<Folder> getAll() {
        return folderDAOLocal.getAll();
    }
}
