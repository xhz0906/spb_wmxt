package hi.wmxfd.controller;

import hi.wmxfd.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    //登录
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String showLogin(){
        return "login";
    }
    @RequestMapping(value ="/dealLogin",method = RequestMethod.POST)
    public String login(@RequestParam("loginName")String loginName
            , @RequestParam("password")String password){
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
            subject.login(token);
            if (subject.isAuthenticated()) {
                int rid=sysUserService.findRoleId(loginName);
                if (rid==1||rid==2){
                    return "main";
                }else{
                    return "member";
                }
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return "login";
    }
    //选择登陆
    @RequestMapping("/loginHandler")
    public String loginHandler(){
        return "main";
    }

    //权限不足
    @RequestMapping("/unAuth")
    public String showUnOauth(){
        return "unAuth";
    }

    @RequestMapping("/main")
    public String showMain(){
        return "main";
    }

    @RequestMapping("/gologin")
    public String logout(){
        try {
            Subject subject=SecurityUtils.getSubject();
            subject.logout();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:login";
    }

    @RequiresPermissions(value = ("user_edit"))
    @RequestMapping("one")
    public String one() {
        return "one";
    }

    @RequiresPermissions(value = {"user_forbiidden"})
    @RequestMapping("/two")
    public String two(){
        return "two";
    }
}
