package Repository;

import DAO.SystemVariableDAO;
import DTO.SystemVariableDTO;
import java.util.List;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class SystemVariableRepository extends Repository<SystemVariableDTO> {
    @Override
    protected SystemVariableDTO get(Integer Id) {
        SystemVariableDAO objectDAO = new SystemVariableDAO();
        SystemVariableDTO objectDTO = objectDAO.read(Id);
        return objectDTO;
    }

    @Override
    protected Boolean add(SystemVariableDTO object) {
        SystemVariableDAO objectDAO = new SystemVariableDAO();
        return objectDAO.create(object);
    }

    @Override
    protected Boolean update(SystemVariableDTO object) {
        SystemVariableDAO objectDAO = new SystemVariableDAO();
        return objectDAO.update(object);
    }

    @Override
    protected Boolean remove(SystemVariableDTO object) {
        SystemVariableDAO objectDAO = new SystemVariableDAO();
        return objectDAO.delete(object.getId());
    }
    
    public List<SystemVariableDTO> all() {
        SystemVariableDAO objectDAO = new SystemVariableDAO();
        List<SystemVariableDTO> list = objectDAO.all();
        return list;
    }
    
    public SystemVariableDTO getSystemVariable(Integer Id) {
        return get(Id);
    }
    
    public SystemVariableDTO getSystemVariable(String Name) {
        List<SystemVariableDTO> list = all();
        if (list != null) for (SystemVariableDTO sv : list) {
            if (sv.getName().contentEquals(Name))
                return sv;
        }
        return null;
    }
    
    public Boolean addSystemVariable(SystemVariableDTO object) {
        return add(object);
    }
    
    public Boolean updateSystemVariable(SystemVariableDTO object){
        return update(object);
    }
    
    public Boolean removeSystemVariable(SystemVariableDTO object) {
        return remove(object);
    }
    
    public Boolean removeSystemVariable(Integer id) {
        SystemVariableDAO objectDAO = new SystemVariableDAO();
        return objectDAO.delete(id);
    }
}