package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        return "Hii World!";
    }
    
    @RequestMapping("/am")
    public String morning() {
    	return "Good Morning";
    }
    
}
