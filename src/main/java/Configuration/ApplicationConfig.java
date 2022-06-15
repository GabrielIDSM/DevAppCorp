package Configuration;

import API.ImageAPI;
import API.RoleAPI;
import API.ServiceAPI;
import API.ServiceHistoryAPI;
import API.SystemVariableAPI;
import API.SystemVariableTypeAPI;
import API.UserAPI;
import API.UserLogAPI;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
@ApplicationPath("/api")
public class ApplicationConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> sets = new HashSet<>();
        sets.add(ImageAPI.class);
        sets.add(RoleAPI.class);
        sets.add(ServiceAPI.class);
        sets.add(ServiceHistoryAPI.class);
        sets.add(SystemVariableAPI.class);
        sets.add(SystemVariableTypeAPI.class);
        sets.add(UserAPI.class);
        sets.add(UserLogAPI.class);
        return sets;
    }
}