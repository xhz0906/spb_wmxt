package hi.wmxfd.controller;
import hi.wmxfd.pojo.SysUser;
import hi.wmxfd.service.SysUserService;
import hi.wmxfd.service.UserRoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private UserRoleService userRoleService;
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
    public String regView(SysUser sysUser){
        System.out.println(sysUser);
        boolean bool=sysUserService.addUser(sysUser);
        if (bool){
           int uid=sysUserService.findUserByLoginName(sysUser.getLoginName()).getUserId();
           boolean bool1=sysUserService.addUserRid(uid);
           if (bool1){
               return "list";
           }else{
               return "error";
           }
        }
       return "login";
    }
    //登录
    @RequestMapping(value = "/login")
    public String showLogin(){
        return "login";
    }
    @RequestMapping(value ="/dealLogin",method = RequestMethod.POST)
    public String login(@RequestParam("loginName")String loginName
            , @RequestParam("password")String password
            , HttpServletRequest request){
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
            HttpSession session=request.getSession();
            SysUser user=sysUserService.findUserByLoginName(loginName);
            session.setAttribute("user",user);
            subject.login(token);
            if (subject.isAuthenticated()) {
                int rid=sysUserService.findRoleId(loginName);
                if (rid==1){
                    return "redirect:loginGuanli";
                }else if (rid==2){
                    return "redirect:loginShangjia";
                } else{
                    return "redirect:loadShops";
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

    @RequestMapping("/list")
    public String listView(HttpServletRequest request){
        SysUser user=(SysUser)request.getSession().getAttribute("user");
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
    @RequestMapping("/loadAll")
    public String loadAll(@RequestParam(required = false,defaultValue = "1") int page,
                          @RequestParam(required = false,defaultValue = "5") int rows,
                          Model model){
        int maxPage=sysUserService.calcMaxPage(rows);
        if(page<1){
            page=maxPage;
        }
        if(page>maxPage){
            page=1;
        }
        List<SysUser> userList = sysUserService.loadAll(page, rows);
        model.addAttribute("userList",userList);
        model.addAttribute("currentPage",page);
        model.addAttribute("maxPage",maxPage);

        return "user";
    }
    @RequestMapping("loadFind")
    public String loadFind(String keyword,Model model){
        List<SysUser> userList = sysUserService.select(keyword);
        model.addAttribute("userList",userList);
        return "user";
    }
    @RequestMapping("delete")
    public String delete(int userId){
        boolean b1 = userRoleService.delUserRole(userId);
        boolean b = sysUserService.delete(userId);
        return b1&&b?"redirect:loadAll":"error";
    }
    @RequestMapping("getUserById")
    public String getUserById(int userId,Model model){
        SysUser u = sysUserService.getUserById(userId);
        model.addAttribute("u",u);
        System.out.println(u);
        return "edit";
    }
    @RequestMapping("update")
    public String update(SysUser sysUser){
        boolean b = sysUserService.update(sysUser);
        return b?"redirect:loadAll":"error";
    }
    @RequestMapping("delUser")
    public String delUser(@RequestParam(value ="ids") List<Integer> ids){
        boolean b1 = userRoleService.delMoreUserRole(ids);
        boolean b = sysUserService.delUser(ids);
        return b1&&b?"redirect:loadAll":"error";
    }
    @RequestMapping("upuser")
    public String upuser(SysUser sysUser){
        boolean b = sysUserService.update(sysUser);
        return b?"redirect:mindex":"error";
    }
}
