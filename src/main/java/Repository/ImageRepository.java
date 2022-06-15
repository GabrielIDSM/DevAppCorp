package Repository;

import DAO.ImageDAO;
import DTO.ImageDTO;
import java.util.List;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class ImageRepository extends Repository<ImageDTO> {
    @Override
    protected ImageDTO get(Integer Id) {
        ImageDAO objectDAO = new ImageDAO();
        ImageDTO objectDTO = objectDAO.read(Id);
        return objectDTO;
    }

    @Override
    protected Boolean add(ImageDTO object) {
        ImageDAO objectDAO = new ImageDAO();
        return objectDAO.create(object);
    }

    @Override
    protected Boolean update(ImageDTO object) {
        ImageDAO objectDAO = new ImageDAO();
        return objectDAO.update(object);
    }

    @Override
    protected Boolean remove(ImageDTO object) {
        ImageDAO objectDAO = new ImageDAO();
        return objectDAO.delete(object.getId());
    }
    
    public List<ImageDTO> all() {
        ImageDAO objectDAO = new ImageDAO();
        List<ImageDTO> list = objectDAO.all();
        return list;
    }
    
    protected Boolean removeImageById(Integer id) {
        ImageDAO objectDAO = new ImageDAO();
        return objectDAO.delete(id);
    }
    
    public Boolean addImage(ImageDTO object) {
        return add(object);
    }
    
    public Boolean updateImage(ImageDTO object) {
        ImageDAO objectDAO = new ImageDAO();
        return objectDAO.update(object);
    }
    
    public Boolean removeImage(ImageDTO object) {
        return removeImageById(object.getId());
    }
    
    public Boolean removeImage(Integer id) {
        return removeImageById(id);
    }
    
    public ImageDTO getImage(Integer id) {
        return get(id);
    }
}