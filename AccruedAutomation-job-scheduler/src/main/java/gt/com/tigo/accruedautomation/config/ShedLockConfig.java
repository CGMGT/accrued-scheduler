package gt.com.tigo.accruedautomation.config;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

import javax.sql.DataSource;

@Configuration
public class ShedLockConfig {
    @Value("${spring.datasource.application.jndi-name}")
    private String applicationJndi;

    @Bean(destroyMethod = "")
    public LockProvider lockProvider(DataSource dataSource) {
        JndiDataSourceLookup lookup = new JndiDataSourceLookup();
        return new JdbcTemplateLockProvider(lookup.getDataSource(this.applicationJndi));
    }
}
