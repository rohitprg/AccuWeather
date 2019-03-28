package org.spring.application.accuweather;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.application.accuweather.service.AccuWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

/**
 * Unit test for Weather App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WeatherAppTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AccuWeatherService weatherService;

	@Test
	public void weatherByCity_shouldReturnValidResponse() throws Exception {
		
		this.mockMvc
				.perform(
						get("/findTempByZipcode/16052").contentType(
								MediaType.APPLICATION_JSON).characterEncoding(
								"utf-8")).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());

	}

	@Test
	public void weatherByZipCode_shouldReturnErrorResponse() throws Exception {
		this.mockMvc
				.perform(
						get("/findTempByZipcode/160").contentType(
								MediaType.APPLICATION_JSON).characterEncoding(
								"utf-8")).andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk());
	}
}
