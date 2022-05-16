package Repository;

import DAO.UserLogDAO;
import DTO.UserLogDTO;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class UserLogRepository extends Repository<UserLogDTO> {
    @Override
    protected UserLogDTO get(Integer Id) {
        UserLogDAO objectDAO = new UserLogDAO();
        UserLogDTO objectDTO = objectDAO.read(Id);
        return objectDTO;
    }

    @Override
    protected Boolean add(UserLogDTO object) {
        UserLogDAO objectDAO = new UserLogDAO();
        return objectDAO.create(object);
    }

    @Override
    protected Boolean update(UserLogDTO object) {
        UserLogDAO objectDAO = new UserLogDAO();
        return objectDAO.update(object);
    }

    @Override
    protected Boolean remove(UserLogDTO object) {
        UserLogDAO objectDAO = new UserLogDAO();
        return objectDAO.delete(object.getId());
    }   
}