package gt.com.tigo.accruedautomation.job;

import gt.com.tigo.accruedautomation.service.accrued.ConfirmacionesService;
import gt.com.tigo.accruedautomation.util.exception.ResourceCreateException;
import gt.com.tigo.accruedautomation.util.exception.ResourceNotFoundException;
import gt.com.tigo.accruedautomation.util.exception.ResourcesNotFoundException;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
public class ConfirmacionesJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConfirmacionesJob.class);

    @Autowired
    private ConfirmacionesService confirmacionesService;



    @Scheduled(cron = "0 */10 * * * *")
    @SchedulerLock(name = "scheduleConfirmations")
    public void scheduleConfirmations() throws ResourceNotFoundException, ResourcesNotFoundException, ResourceCreateException {
        LOGGER.debug(String.format("@%s::scheduleConfirmations()", this.getClass().getName()));
        this.confirmacionesService.enviaConfirmaciones();
    }
}
