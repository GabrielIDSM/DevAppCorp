package Service;

import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Gabriel Inácio <gabrielinacio@id.uff.br>
 */
@WebListener
public class Startup implements ServletContextListener {
    private ScheduledExecutorService executorAddServiceData;
    private ScheduledExecutorService executorRemoveServiceData;
    private AddServiceHistoryData addServiceHistoryData;
    private RemoveServiceHistoryData removeServiceHistoryData;
    private Calendar calendar;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("The application started");
        addServiceHistoryData = new AddServiceHistoryData();
        removeServiceHistoryData = new RemoveServiceHistoryData();
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
        executorAddServiceData.scheduleAtFixedRate(addServiceHistoryData, startTime, 60*60*1000, TimeUnit.MILLISECONDS);
        sce.getServletContext().setAttribute("addServiceHistoryData", addServiceHistoryData);
        
        executorRemoveServiceData = Executors.newSingleThreadScheduledExecutor();
        executorRemoveServiceData.scheduleAtFixedRate(removeServiceHistoryData, startTime, 24, TimeUnit.HOURS);
        sce.getServletContext().setAttribute("removeServiceHistoryData", removeServiceHistoryData);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("The application stopped");
        executorAddServiceData.shutdown();
        executorRemoveServiceData.shutdown();
    }
}