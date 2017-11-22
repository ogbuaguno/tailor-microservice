package ng.com.soh.tailor.ms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Blurryface on 9/26/17.
 */

@Controller
public class Home {

    @RequestMapping("/")
    public String home(){
        return "index";
    }
}
