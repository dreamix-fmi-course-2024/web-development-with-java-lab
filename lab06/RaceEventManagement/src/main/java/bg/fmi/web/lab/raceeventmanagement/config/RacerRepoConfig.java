package bg.fmi.web.lab.raceeventmanagement.config;

import bg.fmi.web.lab.raceeventmanagement.model.Racer;
import bg.fmi.web.lab.raceeventmanagement.repository.RacerRepository;
import bg.fmi.web.lab.raceeventmanagement.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// show bean name definition
//@Configuration
public class RacerRepoConfig {

//    @Bean
//    public RacerRepository racerRepository() { // this will be overridden by the RacerRepository
//        return new RacerRepository();
//    }

    /**
     *     uncomment and start the project to simulate the issue:
     *     Parameter 0 of constructor in bg.fmi.web.lab.raceeventmanagement.service.RacerService required a single bean, but 3 were found
     *
     */
//    @Bean("conflictBeanWithBeanName")
//    public RacerRepository getRacerRepository() {
//        return new RacerRepository();
//    }
//
//    @Bean
//    @Qualifier("conflictBeanWithQualifierName")
//    public RacerRepository racerRepositoryConflictExample() {
//        return new RacerRepository();
//    }

//    @Bean
//    public TeamRepository teamRepository() {
//        return new TeamRepository();
//    }
}
