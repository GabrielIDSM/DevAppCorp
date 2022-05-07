package Repository;

import DAO.SystemVariableTypeDAO;
import DTO.SystemVariableTypeDTO;

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
}