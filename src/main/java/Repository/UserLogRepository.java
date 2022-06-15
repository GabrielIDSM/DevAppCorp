package Repository;

import DAO.UserLogDAO;
import DTO.UserLogDTO;
import java.util.List;

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
    
    public List<UserLogDTO> all() {
        UserLogDAO objectDAO = new UserLogDAO();
        List<UserLogDTO> list = objectDAO.all();
        return list;
    }
    
    public UserLogDTO getUserLog(Integer id) {
        return get(id);
    }
    
    public Boolean addUserLog(UserLogDTO object) {
        return add(object);
    }

    public Boolean updateUserLog(UserLogDTO object) {
        return update(object);
    }

    public Boolean removeUserLog(UserLogDTO object) {
        return remove(object);
    }

    public Boolean removeUserLog(Integer id) {
        return remove(get(id));
    }
}