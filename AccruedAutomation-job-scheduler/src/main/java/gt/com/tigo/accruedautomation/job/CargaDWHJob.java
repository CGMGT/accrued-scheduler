package gt.com.tigo.accruedautomation.job;

import gt.com.tigo.accruedautomation.service.accrued.XxTiposCambioService;
import net.javacrumbs.shedlock.core.LockAssert;
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
public class CargaDWHJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(TipoCambioJob.class);

    @Autowired
    private XxTiposCambioService xxTiposCambioService;

    private ResponseEntity loadDWHData() {
        LOGGER.debug(String.format("@%s::loadDWHData()", this.getClass().getName()));

        try {
            return ResponseEntity.ok(this.xxTiposCambioService.cargaDatosDWH());
        } catch (Exception ex) {
            LOGGER.error(String.format("@%s::loadDWHData() %s", this.getClass().getName(), ex.getMessage()));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }



    @Scheduled(cron = "0 */60 * * * *")
    @SchedulerLock(name = "scheduleLoadDWHData",
            lockAtLeastFor = "PT5M", lockAtMostFor = "PT14M")
    public void scheduleLoadDWHData() {
        LOGGER.debug(String.format("@%s::scheduleLoadDWHData()", this.getClass().getName()));
        try{
            LockAssert.assertLocked();
            this.loadDWHData();
        } catch (Exception ex) {
            LOGGER.error(String.format("@%s::scheduleLoadDWHData() %s", this.getClass().getName(), ex.getMessage()));
        }

    }
}
