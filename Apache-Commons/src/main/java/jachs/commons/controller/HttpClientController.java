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
    public String postT1 (String pam1,String pam2) {
        return "postT1"+pam1+":"+pam2;
    }
    @GetMapping( "/getT1" )
    public String getT1 (String pam1,String pam2) {
        return "postT1"+pam1+":"+pam2;
    }
    @RequestMapping("/rm1")
    public String rm1() {
        return "rm1";
    }
}
