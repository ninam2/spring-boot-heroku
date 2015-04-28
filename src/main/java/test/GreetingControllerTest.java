package test;

import hello.GreetingController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by tbautz on 15.04.15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class GreetingControllerTest {

    private MockMvc mvc;
    private String greetingString = "Hallo Welt!!!";

    @Before
    public void setUp() throws Exception{
        mvc = MockMvcBuilders.standaloneSetup(new GreetingController()).build();
    }

    @Test
    public void greetingTest() throws Exception {
        mvc.perform(put("http://localhost:8080/hello-seatmap/greeting")
            .content(greetingAsJSON(greetingString))
            .contentType("application/json;charset=UTF-8"))
            .andExpect(status().isOk());

        mvc.perform(get("http://localhost:8080/hello-seatmap/greeting"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json;charset=UTF-8"))
            .andExpect(content().string(equalTo(greetingAsJSON(greetingString))));
    }

    @Test
    public void get404() throws Exception {
        mvc.perform(get("http://localhost:8080/hello-seatmap/greeting"))
            .andExpect(status().isNotFound());
    }

    private String greetingAsJSON(String greeting){
        return "{\"greeting\":\""+greeting+"\"}";
    }
}
