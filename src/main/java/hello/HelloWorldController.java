package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloWorldController {
    
    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    }
    
    @RequestMapping("/am")
    public String morning() {
    	return "Good Morning";
    }
    
}
