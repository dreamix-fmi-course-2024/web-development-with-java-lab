# Tasks

Before continuing, ensure that you have at least one full domain thread (model -> service -> repository) from the last week tasks


## Task 0
Implement two [logging](https://www.graylog.org/post/server-log-files-in-a-nutshell#:~:text=A%20server%20log%20file%20is,or%20the%20application%20was%20accessed.) mechanism to show data from your application - to a console and to a file

Your custom loggers must implement the following interface:
```
public interface Logger {

    void info(Object toLog);

    void debug(Object toLog);

    void trace(Object toLog);

    void error(Object toLog);
}
```

The first implementation should use the STDOUT (standard output -> System.out.println)

The second one should store information inside file (use the code snippet bellow)
```
private void logInformation(Object toLog, LoggerLevel currentLoggerLevel) {
    File log = new File("log.txt");
    try (PrintWriter out = new PrintWriter(new FileWriter(log, true))) {
        out.println(new Date() + " [" + currentLoggerLevel.getLabel() + "] - " + toLog);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

```

Information for the logger level can be store inside enum like:
```
public enum LoggerLevel {

     INFO(1, "INFO"),
     DEBUG(2, "DEBUG"),
     TRACE(3, "TRACE"),
     ERROR(0, "ERROR");

     private final Integer code;
     public final String label;

     LoggerLevel(Integer code, String label) {
         this.code = code;
         this.label = label;
     }

     public Integer getCode() {
         return code;
     }

     public final String getLabel() {
         return label;
     }

 }
```

Based on the logging level defined inside the application.propeties limit the information that you log inside your application.

Logging parameters: INFO, DEBUG, TRACE
```
INFO level log only INFO
DEBUG level log INFO & DEBUG
TRACE level log INFO & DEBUG & TRACE
```
error log is always shown.


Based on your active spring profile you must use the appropriate implementation
For example 
```
local profile to use the STDOUT implementation
dev profile to use the FILE implementation
```

## Task 1
Use your custom logger inside RaceEventManagement.

*Example*: log data when you enter creation method -> logger.info("createEvent triggered");


## Task 2
*Note:* to finish this task you need EventService implementation.

Implement data reading from the application.properties file.

In our RaceEventManagement system we want to redefine what incoming events means. An incoming event will be such whichc is within 7 days

Property example:

```
config.event.upcoming-threshold-days=7
```

Tips: you can use @Value or AppConfig class from lecture example. 
[similar class implementation](https://github.com/GeorgiMinkov/smart-garden/blob/master/ms-smart-garden/src/main/java/bg/unisofia/fmi/robotcourse/config/AppConfig.java) and
[property file](https://github.com/GeorgiMinkov/smart-garden/blob/master/ms-smart-garden/src/main/resources/application.properties)

## Task 3 - User story for deletion information

<blockquote class="trello-card"><a href="https:&#x2F;&#x2F;trello.com&#x2F;c&#x2F;8h9ogkId">Implement a Safety Check for Event Deletion Based on Configurable Time Window</a></blockquote>

<details>
<summary>If Trello is not loading open here</summary>

**User Story**: Event Deletion Safety Check
Title: Implement a Safety Check for Event Deletion Based on Configurable Time Window

**As** a system administrator,

**I want** to have a configurable safety window that prevents the deletion of events happening within a certain number of days from the current date,

**So that** I can ensure there is adequate notice for participants and stakeholders before any event is canceled or removed from the system.

*Acceptance Criteria*:

**Configurable Safety Window**: The number of days constituting the safety window should be configurable via an application property named events.deletion-safety-window-days. This property should default to 30 days but can be adjusted as needed for different environments or operational policies.

**Deletion Check**: When an attempt is made to delete an event, the system must first check if the event's scheduled date is outside the configured safety window (i.e., the event date is further in the future than the safety window allows).

**Prevention of Deletion**: If the event is within the safety window (e.g., scheduled to occur within the next 30 days by default), the system must prevent the deletion and return a meaningful error message indicating that the event cannot be deleted due to its proximity to the current date.

**Logging**: Every attempt to delete an event, whether successful or blocked by the safety check, should be logged with appropriate details (e.g., event ID, scheduled date, deletion attempt timestamp, and the outcome of the attempt).
</details>

## Bonus Task (REST API {lec06})
For your management platform create a simple get all racers REST endpoint

Steps:

- add web starter dependency (Additional info: Starter of Spring web uses Spring MVC, REST and Tomcat as a default embedded server. The single spring-boot-starter-web dependency transitively pulls in all dependencies related to web development. It also reduces the build dependency count.)
```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
```

- create a controller package
- use @RestController (Additional info: you can use @Controller but, @RestController annotation in order to simplify the creation of RESTful web services. It's a convenient annotation that combines @Controller and @ResponseBody, which eliminates the need to annotate every request handling method of the controller class with the @ResponseBody annotation.)
- use @GetMapping (Additional info: Annotation for mapping HTTP GET requests onto specific handler methods. Specifically, @GetMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod. GET) .)

Example:
```
@RestController
@RequestMapping("example")
public class SimpleBookRestController {
    
    @GetMapping("/books")
    public Book getBook() {
        return service.getBooks();
    }
}
```