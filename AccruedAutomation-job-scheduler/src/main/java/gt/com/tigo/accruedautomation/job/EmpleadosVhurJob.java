package gt.com.tigo.accruedautomation.job;

import gt.com.tigo.accruedautomation.service.vhur.EmpleadosVhurService;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
public class EmpleadosVhurJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmpleadosVhurJob.class);

    @Autowired
    private EmpleadosVhurService employeesService;

    private ResponseEntity populate() {
        LOGGER.debug(String.format("@%s::populate()", this.getClass().getName()));

        try {
            return ResponseEntity.ok(this.employeesService.sync());
        } catch (Exception ex) {
            LOGGER.error(String.format("@%s::populate() %s", this.getClass().getName(), ex.getMessage()));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }



    @Scheduled(cron = "0 0 22-23 * * *")
    @SchedulerLock(name = "scheduleEmpleadosTask")
    public void scheduleEmpleadosTask() {
        LOGGER.debug(String.format("@%s::scheduleEmpleadosTask()", this.getClass().getName()));
        try{
            this.populate();
        } catch (Exception ex) {
            LOGGER.error(String.format("@%s::scheduleEmpleadosTask() %s", this.getClass().getName(), ex.getMessage()));
        }

    }
}
