package hi.wmxfd.controller;

import hi.wmxfd.pojo.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class QtController {
    @RequestMapping("/user_center")
    public String user_center(){
        return "user_center";
    }
    @RequestMapping("/shop")
    public String showView(){
        return "shop";
    }
    //详情

    //收货地址
    @RequestMapping("/user_address")
    public String user_address(){
        return "user_address";
    }
    //我的订单
    @RequestMapping("/user_orderlist")
    public String user_orderlist(){
        return "user_orderlist";
    }
    //订单交易
    @RequestMapping("/user_transaction")
    public String user_transaction(){
        return "user_transaction";
    }
    //我的留言
    @RequestMapping("/user_message")
    public String user_message(){
        return "user_message";
    }
    //我的优惠劵
    @RequestMapping("/user_coupon")
    public String user_coupon(){
        return "user_coupon";
    }
    //我的收藏
    @RequestMapping("/user_favorites")
    public String user_favorites(){
        return "user_favorites";
    }
    //账户管理
    @RequestMapping("user_account")
    public String user_account(){
        return "user_account";
    }
    //结算
    @RequestMapping("/confirm_order")
    public String confirm_order(){
        return "confirm_order";
    }
    //关于我们
    @RequestMapping("/article_read")
    public String article_read(){
        return "article_read";
    }
    //积分商城
    @RequestMapping("/category")
    public String category(){
        return "category";
    }


}
