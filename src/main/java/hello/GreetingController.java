package hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Created by tbautz on 15.04.15.
 */

@RestController
public class GreetingController {


    private ArrayList<Greeting> greetList = new ArrayList<>();
    private int i = 0;

    @RequestMapping(method = RequestMethod.GET, value = "/hello-seatmap/greeting", produces = "application/json;charset=UTF-8")
    public Greeting getGreeting( @RequestParam(value = "position", defaultValue = "0") int position){
        return greetList.get(position);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/hello-seatmap/greeting", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    private String putGreeting(@RequestBody Greeting greeting) {
        System.out.println("greeting" + greeting.getA());
        greetList.add(i, greeting);
        i++;

        return "Added Greeting \"" + greeting.getGreeting() + "\" on position " + (i - 1);
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus( HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleIOException(Throwable ex) {
        return "No greeting available";
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus( HttpStatus.CONFLICT)
    @ResponseBody
    public String handleMessageNotFoundException(Throwable ex) {
        return "Dummkopf du musst einen Integer eingeben";
    }


}
