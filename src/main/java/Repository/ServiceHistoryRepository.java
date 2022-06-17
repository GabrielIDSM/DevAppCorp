package Repository;

import DAO.ServiceHistoryDAO;
import DTO.ServiceDTO;
import DTO.ServiceHistoryDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class ServiceHistoryRepository extends Repository<ServiceHistoryDTO> {
    @Override
    protected ServiceHistoryDTO get(Integer Id) {
        ServiceHistoryDAO objectDAO = new ServiceHistoryDAO();
        ServiceHistoryDTO objectDTO = objectDAO.read(Id);
        return objectDTO;
    }

    @Override
    protected Boolean add(ServiceHistoryDTO object) {
        ServiceHistoryDAO objectDAO = new ServiceHistoryDAO();
        return objectDAO.create(object);
    }

    @Override
    protected Boolean update(ServiceHistoryDTO object) {
        ServiceHistoryDAO objectDAO = new ServiceHistoryDAO();
        return objectDAO.update(object);
    }

    @Override
    protected Boolean remove(ServiceHistoryDTO object) {
        ServiceHistoryDAO objectDAO = new ServiceHistoryDAO();
        return objectDAO.delete(object.getId());
    }
    
    public List<ServiceHistoryDTO> all() {
        ServiceHistoryDAO objectDAO = new ServiceHistoryDAO();
        List<ServiceHistoryDTO> list = objectDAO.all();
        return list;
    }
    
    public List<ServiceHistoryDTO> last() {
        ServiceHistoryDAO objectDAO = new ServiceHistoryDAO();
        ServiceRepository serviceRepository = new ServiceRepository();
        List<ServiceDTO> services = serviceRepository.all();
        List<ServiceHistoryDTO> list = objectDAO.all();
        List<ServiceHistoryDTO> last = new ArrayList<>();
        for (ServiceDTO service : services) {
            ServiceHistoryDTO lastHistory = null;
            for (ServiceHistoryDTO history : list) {
                if (history.getService().getName().equals(service.getName()))
                    if (lastHistory == null)
                        lastHistory = history;
                    else
                        if (history.getCollectionTimestamp()
                                .after(lastHistory.getCollectionTimestamp()))
                            lastHistory = history;
            }
            last.add(lastHistory);
        }
        return last;
    }
    
    public ServiceHistoryDTO getServiceHistory(Integer id) {
        return get(id);
    }
    
    public Boolean removeAllServiceHistoryByService(ServiceDTO object) {
        Boolean opStatus = true; 
        ServiceHistoryDAO objectDAO = new ServiceHistoryDAO();
        List<ServiceHistoryDTO> list = objectDAO.all();
        for (ServiceHistoryDTO serviceHistoryDTO: list) {
            if (Objects.equals(object.getId(), serviceHistoryDTO.getService().getId()))
                opStatus = opStatus && remove(serviceHistoryDTO);
        }
        return opStatus;
    }
    
    public Boolean addServiceHistory(ServiceHistoryDTO object) {
        return add(object);
    }

    public Boolean updateServiceHistory(ServiceHistoryDTO object) {
        return update(object);
    }

    public Boolean removeServiceHistory(ServiceHistoryDTO object) {
        return remove(object);
    }

    public Boolean removeServiceHistory(Integer id) {
        return remove(get(id));
    }
}