package com.jrbrayjr.spring.cloud.streams.streamfunction;

import com.jrbrayjr.spring.cloud.streams.streamfunction.events.ClinicEventEmitter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
@Import(ClinicEventEmitter.class)
class StreamFunctionApplicationTests {

	@Test
	void contextLoads() {
	}

}
