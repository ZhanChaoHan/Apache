package jachs.commons.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanchaohan
 * 
 */
@RestController
public class HttpClientController {
    
    @PostMapping( "/postT1" )
    public String postT1 () {
        return "postT1";
    }
    @GetMapping( "/getT1" )
    public String getT1 () {
        return "postT1";
    }
    @RequestMapping("/rm1")
    public String rm1() {
        return "rm1";
    }
}
