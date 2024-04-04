package bg.fmi.web.lab.raceeventmanagement;

import bg.fmi.web.lab.raceeventmanagement.config.logger.Logger;
import bg.fmi.web.lab.raceeventmanagement.service.EventService;
import bg.fmi.web.lab.raceeventmanagement.service.RacerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class RaceEventManagementApplication /*implements CommandLineRunner */{

    public static void main(String[] args) {
        SpringApplication.run(RaceEventManagementApplication.class, args);
    }

//    @Autowired
//    private RacerService racerService;

//    @Autowired
//    private EventService eventService;

    @Autowired
    private Logger logger;

    @Autowired
    private ApplicationContext context;



//    @Override
//    public void run(String... args) throws Exception {
//        logger.info(">>>>>>>>>>>");
//        System.out.println("List of Beans provided by Spring Boot:");
//
//        String[] beanNames = context.getBeanDefinitionNames();
//        List<String> beanClasses = Stream.of(beanNames)
//                .map(el -> context.getBean(el).getClass().toString())
//                .filter(el -> el.contains("bg.fmi"))
//                .toList();
//        beanClasses.forEach(System.out::println);
//    }
}
