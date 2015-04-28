package hello;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String test() {
        return "Hello Seatmap";
    }

}


