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
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    //注册
    @RequestMapping("/reg")
    public String reg(){
        return "reg";
    }
    @ResponseBody
    @RequestMapping("/pduname")
    public Map pduname(@RequestParam("uname")String uname){
        System.out.println(uname);
        Map map=new HashMap();
        if (sysUserService.findUserByLoginName(uname)!=null){
            map.put("msg","该用户名已被使用");
        }
        return map;
    }
    @RequestMapping(value = "/register" )
    public String regView( ){
       return "login";
    }
    //登录
    @RequestMapping(value = "/login")
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
                /*if (rid==1||rid==2){
                    return "main";
                }*/
                if (rid==1){
                    return "redirect:loginGuanli";
                }else if (rid==2){
                    return "redirect:loginShangjia";
                } else{
                    return "list";
                }
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return "login";
    }
    //登录管理员界面
    @RequestMapping("/loginGuanli")
    public String loginGuanli(){
        return "main";
    }
    //登录商家界面
    @RequestMapping("/loginShangjia")
    public String loginShangjia(){
        return "main";
    }
    @RequiresPermissions(value = ("yhgl"))
    @RequestMapping("/hi")
    public String hi(){
        return "hi";
    }
    /*@RequestMapping("/loginHandler")
    public String loginHandler(){
        return "main";
    }*/
    //登录前台
    @RequestMapping("/list")
    public String listView(){
        return "list";
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
