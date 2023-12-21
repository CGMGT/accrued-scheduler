package gt.com.tigo.accruedautomation.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@EnableScheduling
public class SampleJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(SampleJob.class);

    public void scheduleFixedDelayTask() {
        LOGGER.debug(String.format("@%s::scheduleFixedDelayTask()", this.getClass().getName()));
    }

}
