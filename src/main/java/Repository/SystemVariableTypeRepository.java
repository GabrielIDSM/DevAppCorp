package Repository;

import DAO.SystemVariableTypeDAO;
import DTO.SystemVariableTypeDTO;
import java.util.List;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class SystemVariableTypeRepository extends Repository<SystemVariableTypeDTO> {
    @Override
    protected SystemVariableTypeDTO get(Integer Id) {
        SystemVariableTypeDAO objectDAO = new SystemVariableTypeDAO();
        SystemVariableTypeDTO objectDTO = objectDAO.read(Id);
        return objectDTO;
    }

    @Override
    protected Boolean add(SystemVariableTypeDTO object) {
        SystemVariableTypeDAO objectDAO = new SystemVariableTypeDAO();
        return objectDAO.create(object);
    }

    @Override
    protected Boolean update(SystemVariableTypeDTO object) {
        SystemVariableTypeDAO objectDAO = new SystemVariableTypeDAO();
        return objectDAO.update(object);
    }

    @Override
    protected Boolean remove(SystemVariableTypeDTO object) {
        SystemVariableTypeDAO objectDAO = new SystemVariableTypeDAO();
        return objectDAO.delete(object.getId());
    }
    
    public List<SystemVariableTypeDTO> all() {
        SystemVariableTypeDAO objectDAO = new SystemVariableTypeDAO();
        List<SystemVariableTypeDTO> list = objectDAO.all();
        return list;
    }
    
    public SystemVariableTypeDTO getSystemVariableType(Integer Id) {
        return get(Id);
    }
    
    public Boolean addSystemVariableType(SystemVariableTypeDTO object) {
        return add(object);
    }
    
    public Boolean updateSystemVariableType(SystemVariableTypeDTO object){
        return update(object);
    }
    
    public Boolean removeSystemVariableType(SystemVariableTypeDTO object) {
        return remove(object);
    }
    
    public Boolean removeSystemVariableType(Integer id) {
        SystemVariableTypeDAO objectDAO = new SystemVariableTypeDAO();
        return objectDAO.delete(id);
    }
}