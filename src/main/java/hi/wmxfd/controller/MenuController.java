package hi.wmxfd.controller;

import hi.wmxfd.pojo.Menu;
import hi.wmxfd.pojo.SysUser;
import hi.wmxfd.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;
 @RequestMapping("loadMenu")
   public String loadMenu(int shopId, HttpServletRequest request){
     List<Menu> menuList = menuService.loadMenu(shopId);
     HttpSession session=request.getSession();
     session.setAttribute("menuList",menuList);
     return "shop";
 }
 @RequestMapping("/cart")
    public String cart(){
     return "cart";
 }
 //详情
 @RequestMapping("/detailsp")
    public String deTailsp(int menuId,HttpServletRequest request){
        Menu menu=menuService.findMenu(menuId);
        HttpSession session=request.getSession();
        session.setAttribute("menu",menu);
        String menuName=menu.getMenuName();
        session.setAttribute("menuName",menuName);
        return "detailsp";
    }

}
