# stream-function

## Overview
This project uses the Reactive Spring to implement Spring Cloud Streams.  Events are emitted/published to a channel where one or more subscriber(s) can retrieve/subscribe to them.

## Setup and Configuration
This application assumes the presence of RabbitMQ in the environment.  

### Local Setup

#### MacOS and Linux Setup

If you will develop and do local testing on a Macintosh or Linux machine, a RabbitMQ Docker image may be installed to meet the environment requirements for running the application locally.  Refer to the [docker hub rabbitmq site](https://hub.docker.com/_/rabbitmq) for detailed information.

```cmd
docker pull rabbitmq
```

#### Windows Setup
If you can run docker on Windows, then follow the directions above for MacOS and Linux.  It is common to encounter cases where Docker cannot be run on Windows.  In these cases, RabbitMQ must be installed directly.  This can be done via an application management tool for Windows such a Chocolatey, or by manualling installing RabbitMQ.  If you do a manual install, you will need to install a compatible version of Erlang before installing RabbitMQ.

## Testing

### Using the WebTestClient

The `WebTestClient` can be instantiated in the test by either using the `@Autowired` annotation as shown below:

```java
@ExtendWith(SpringExtension.class)
@WebFluxTest( controllers = {ClinicController.class})
class ClinicControllerTest {
    @MockBean
    SomeService mockSomeService;

    @Autowired
    SomeController controller;

    @Autowired
    WebTestClient webClient;

    @BeforeEach
    void setUp() {
        controller = new SomeController(mockSomeService);
        webClient = WebTestClient.bindToController(controller).build();
    }
    ...
```


## References

- [Spring – @WebFluxTest with WebTestClient](https://howtodoinjava.com/spring-webflux/webfluxtest-with-webtestclient/)