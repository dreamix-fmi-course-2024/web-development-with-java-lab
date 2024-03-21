# Race Event Management - Spring Boot Integration

## Task 1 - migrate your Race Event Management tool to a Spring Boot application
1. To achieve this task you will need to create a Spring Boot application with IntelliJ Ultimate or [spring-initializr](https://start.spring.io/) to create a Spring Boot application.

<big><pre>
If you are having trouble with the starter you can check the following [documentation](https://github.com/dreamix-fmi-course-2024/web-development-with-java-lab/tree/main/lab04/spring-initializr-tutorial.md)
</pre></big>


2. Create the proper Bean definition and connect all project dependencies
<details>
<summary>Hints</summary>

```md
- make use of @Autowired and @Component annotation
- Connect the respectful classes (e.g Service is containing Repository, Service can contain one or more Services)
```

</details>

If you don't have the code for the RaceEventManagement project you can use the code from [lab03](https://github.com/dreamix-fmi-course-2024/web-development-with-java-lab/tree/main/lab03/Race%20Event%20Management/src/bg/fmi/javacourse2024).
For the purpose of this lab you can start only with the Racer domain logic (model, repository and service)

## Task 2 - Run a simple data check
For this test we will use the RacerService (as it's funtionalities are simple to manipulate).

In your main class implement the `CommandLineRunner` interface. This will give you the abbility to play with your Spring Boot application

Create new Racers and then print them out.

```java
@SpringBootApplication
public class RaceEventManagementApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RaceEventManagementApplication.class, args);
    }

    @Autowired
    private RacerService racerService;

    @Autowired
    private ApplicationContext context;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("List of Beans provided by Spring Boot:");

        String[] beanNames = context.getBeanDefinitionNames();
        List<String> beanClasses = Stream.of(beanNames)
                .map(el -> context.getBean(el).getClass().toString())
                .filter(el -> el.contains("bg.fmi"))
                .toList();
        beanClasses.forEach(System.out::println);

        // uncomment to see all loaded beans
//        Arrays.sort(beanNames);
//        for (String beanName : beanNames) {
//            System.out.println(beanName + " - " + context.getBean(beanName).getClass());
//        }

        System.out.println(">>>>>>>>>>>> add custom logic here");

        racerService.createRacer("Test", "Test", 18);
        racerService.createRacer("Test1", "Test1", 18);
        racerService.createRacer("Test2", "Test2", 18);

        racerService.getAllRacers().stream().forEach(el -> System.out.println(el));
    }
}
```

## Task 3 - finish all 
Implement all Services connecting them to Repositories using the Spring approach