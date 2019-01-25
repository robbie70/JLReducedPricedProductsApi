package com.zensar.tech.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

	private Application undertest = new Application();

	@Test
	public void contextLoads() {
	}

	@Test
	public void shouldReturnRestTemplate(){
		assertThat(undertest.getRestTemplateBean()).isNotNull();
	}

}

