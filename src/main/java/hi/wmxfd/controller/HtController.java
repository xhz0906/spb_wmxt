package hi.wmxfd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HtController {
    @RequestMapping("/userview")
    public String userView(){
        return "users";
    }
}
