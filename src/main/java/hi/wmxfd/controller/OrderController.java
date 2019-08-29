package hi.wmxfd.controller;

import hi.wmxfd.pojo.Menu;
import hi.wmxfd.pojo.Order;
import hi.wmxfd.pojo.SysUser;
import hi.wmxfd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class OrderController {
    @Autowired OrderService orderService;
    //待审核订单
    @RequestMapping("/orders")
    public String orders(@RequestParam(required = false,defaultValue = "1")int page,
                         @RequestParam(required = false,defaultValue = "5")int rows,
                         Model model){
        int maxPage=orderService.calcMaxOrder(rows);
        if (page<1){
            page=maxPage;
        }
        if (page>maxPage){
            page=1;
        }
        List<Order> orders=orderService.findAllOrder(page,rows);
        model.addAttribute("orders",orders);
        model.addAttribute("currentPage",page);
        model.addAttribute("maxPage",maxPage);
        return "orders";

    }
    //已审核订单
    @RequestMapping("/yiOrders")
    public String yiOrders(Model model){
        List<Order> orders=orderService.findOrder();
        model.addAttribute("yorders",orders);
        return "yiorders";

    }
    //修改状态
    @RequestMapping("/loadById")
    public String loadById(int ddId){
        boolean bool=orderService.updateOrder(ddId);
        return  bool?"redirect:orders":"hi";
    }
    //删除订单
    @RequestMapping("/deleteById")
    public String deleteById(int ddId){
        boolean bool=orderService.deleteOrder(ddId);
        return bool?"redirect:orders":"hi";
    }
    @RequestMapping("/addCart")
    public String addCart(HttpServletRequest request,Model model,int cId){
        SysUser user=(SysUser)request.getSession().getAttribute("user");
        if(user!=null && !user.equals("")){
            int uid=user.getUserId();
            int count=orderService.findCount(uid,cId);
            List<Integer> list=orderService.findUserOrder(uid);
            List<Menu> mlist=orderService.loadUserMenu(list);
            model.addAttribute("count",count);
            model.addAttribute("mlist",mlist);
        }
        return "cart";
    }

}
