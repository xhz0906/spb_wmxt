package hi.wmxfd.controller;

import hi.wmxfd.pojo.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HtController {
    @RequestMapping("/userview")
    public String userView(){
        return "orders";
    }

}
