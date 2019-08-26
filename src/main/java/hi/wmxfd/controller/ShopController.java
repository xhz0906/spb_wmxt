package hi.wmxfd.controller;

import hi.wmxfd.mapper.ShopMapper;
import hi.wmxfd.pojo.Shop;
import hi.wmxfd.pojo.Shopping;
import hi.wmxfd.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ShopController {
    @Autowired
    private ShopService shopService;

    @RequestMapping("loadShops")
    public String loadShops(@RequestParam(required = false,defaultValue = "1")int page,
                            @RequestParam(required = false,defaultValue = "5")int rows,
                            Model model){
        int maxPage=shopService.calcMaxPage(rows);
        if (page<1){
            page=maxPage;
        }
        if (page>maxPage){
            page=1;
        }
        List<Shop> shoppingList= shopService.loadPage(page,rows);
        model.addAttribute("shopList",shoppingList);
        model.addAttribute("maxPage",maxPage);
        model.addAttribute("currentPage",page);
        return "shopmanage";
    }
    @RequestMapping("loadsave")
    public String loadsave(){
        return "add";
    }
    @RequestMapping("saveShop")
    public String saveShop(Shop shop){
        boolean bool=shopService.saveShop(shop);
        return bool?"redirect:loadShops":"error";
    }


}
