# stream-function

## Overview
This project uses the Reactive Spring to implement Spring Cloud Streams.  Events are emitted/published to a channel where one or more subscriber(s) can retrieve/subscribe to them.

## Testing

### Using the WebTestClient

The `WebTestClient` can be instantiated in the test by either using the `@Autowired` annotation as shown below:

```java
import org.springframework.beans.factory.annotation.Autowired;
public class SomeControllerTest {
    ...
    ...
    @Autowired
    WebTestClient webTestClient;
```

or, the `WebTestClient` can be instantiated directly in the `setUp()` method:

```java
@ExtendWith(SpringExtension.class)
@WebFluxTest( controllers = {ClinicController.class})
class ClinicControllerTest {
    ...
    SomeController controller;
    WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        controller = new ClinicController();
        webClient = WebTestClient.bindToController(webClient).build();
    }
}
```

## References

- [Spring – @WebFluxTest with WebTestClient](https://howtodoinjava.com/spring-webflux/webfluxtest-with-webtestclient/)