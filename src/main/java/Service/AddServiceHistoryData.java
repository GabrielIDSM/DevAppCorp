package Service;

import DTO.ServiceDTO;
import DTO.ServiceHistoryDTO;
import Repository.ServiceHistoryRepository;
import Repository.ServiceRepository;
import Repository.SystemVariableRepository;
import Util.SystemVariableUtil;
import Util.TwitterUtil;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class AddServiceHistoryData implements Runnable {
    @Override
    public void run() {
        SystemVariableUtil systemVariableUtil = new SystemVariableUtil();
        TwitterUtil twitterUtil = new TwitterUtil();
        ServiceRepository serviceRepository = new ServiceRepository();
        ServiceHistoryRepository serviceHistoryRepository = new ServiceHistoryRepository();
        SystemVariableRepository systemVariableRepository = new SystemVariableRepository();
        String url = (String) systemVariableUtil
                .toType(systemVariableRepository.getSystemVariable("URL"));
        String maxResult = (String) systemVariableUtil
                .toType(systemVariableRepository.getSystemVariable("MAX_RESULT"));
        String token = (String) systemVariableUtil
                .toType(systemVariableRepository.getSystemVariable("TOKEN"));
        List<ServiceDTO> serviceList = serviceRepository.all();
        if (serviceList != null) for (ServiceDTO serviceDTO : serviceList) {
            ServiceHistoryDTO serviceHistoryDTO = new ServiceHistoryDTO();
            serviceHistoryDTO.setService(serviceDTO);
            serviceHistoryDTO.setCollectionTimestamp(new Date());
            try {
                serviceHistoryDTO.setComplaints(twitterUtil
                        .getComplaintCount(serviceDTO.getQuery(), url, maxResult, token));
                System.out.printf("%d complaints for %s.\n", serviceHistoryDTO.getComplaints(), serviceDTO.getName());
                serviceHistoryRepository.addServiceHistory(serviceHistoryDTO);
            } catch (URISyntaxException | IOException | ParseException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}