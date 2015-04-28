package test;

/*
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
*/