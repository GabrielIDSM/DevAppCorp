package Repository;

import DAO.SystemVariableDAO;
import DTO.SystemVariableDTO;

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
}