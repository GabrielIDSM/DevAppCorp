package Service;

import DTO.ServiceHistoryDTO;
import Repository.ServiceHistoryRepository;
import Repository.SystemVariableRepository;
import Util.SystemVariableUtil;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class RemoveServiceHistoryData implements Runnable {
    @Override
    public void run() {
        SystemVariableUtil systemVariableUtil = new SystemVariableUtil();
        SystemVariableRepository systemVariableRepository = new SystemVariableRepository();
        Integer months = (Integer) systemVariableUtil
                .toType(systemVariableRepository.getSystemVariable("STORAGE_LIMIT"));
        Date date = new Date();
        Calendar calendar = Calendar.getInstance(); 
        calendar.setTime(date); 
        calendar.add(Calendar.MONTH, months*(-1));
        ServiceHistoryRepository serviceHistoryRepository = new ServiceHistoryRepository();
        List<ServiceHistoryDTO> serviceHistoryList = serviceHistoryRepository.all();
        if (serviceHistoryList != null) for (ServiceHistoryDTO serviceHistoryDTO : serviceHistoryList) {
            if (calendar.getTime().after(serviceHistoryDTO.getCollectionTimestamp()))
                serviceHistoryRepository.removeServiceHistory(serviceHistoryDTO);
        }
    }
}