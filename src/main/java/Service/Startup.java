package Service;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
public class Startup implements ServletContextListener {
    private ScheduledExecutorService executorAddServiceData;
    private ScheduledExecutorService executorRemoveServiceData;
    private AddServiceData addServiceData;
    private RemoveServiceData removeServiceData;
    private Calendar calendar;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        addServiceData = new AddServiceData();
        removeServiceData = new RemoveServiceData();
        calendar = Calendar.getInstance();
        
        long startTime;
        int minutes = calendar.get(Calendar.MINUTE);
        int seconds = calendar.get(Calendar.SECOND);
        int millis = calendar.get(Calendar.MILLISECOND);
        int minutesToNextHour = 60 - minutes;
        int secondsToNextHour = 60 - seconds;
        int millisToNextHour = 1000 - millis;
        startTime = minutesToNextHour * 60 * 1000 + secondsToNextHour * 1000 + millisToNextHour;

        executorAddServiceData = Executors.newSingleThreadScheduledExecutor();
        executorAddServiceData.scheduleAtFixedRate(addServiceData, startTime, 60*60*1000, TimeUnit.MILLISECONDS);
        sce.getServletContext().setAttribute("addServiceData", addServiceData);
        
        executorRemoveServiceData = Executors.newSingleThreadScheduledExecutor();
        executorRemoveServiceData.scheduleAtFixedRate(removeServiceData, startTime, 24, TimeUnit.HOURS);
        sce.getServletContext().setAttribute("removeServiceData", removeServiceData);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        executorAddServiceData.shutdown();
        executorRemoveServiceData.shutdown();
    }
}