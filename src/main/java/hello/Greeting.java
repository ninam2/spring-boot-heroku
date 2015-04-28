package hello;

import org.springframework.stereotype.Service;

/**
 * Created by tbautz on 13.04.15.
 */

@Service
public class Greeting {
    private String greeting;
    private int a;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
