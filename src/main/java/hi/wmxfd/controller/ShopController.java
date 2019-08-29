package hi.wmxfd.controller;

import hi.wmxfd.pojo.Shop;
import hi.wmxfd.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShopController {
    @Autowired
    private ShopService shopService;

    @RequestMapping("/loadShops")
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
        List<Shop> shopList= shopService.loadPage(page,rows);
        model.addAttribute("shopList",shopList);
        model.addAttribute("maxPage",maxPage);
        model.addAttribute("currentPage",page);
        return "list";
    }
    @RequestMapping("/menu")
    public String menu(){
        return "menu";
    }

    @RequestMapping("/loadShop")
    public String loadShop(@RequestParam(required = false,defaultValue = "1")int page,
                            @RequestParam(required = false,defaultValue = "5")int rows,
                            Model model){
        int maxPage=shopService.calcMaxPage(rows);
        if (page<1){
            page=maxPage;
        }
        if (page>maxPage){
            page=1;
        }
        List<Shop> shops= shopService.loadPage(page,rows);
        model.addAttribute("shops",shops);
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
    @RequestMapping("deleteShop")
    public String deleteShop(int shopId){
        boolean bool=shopService.deleteShop(shopId);
        return  bool?"redirect:loadShops":"error";
    }
    @RequestMapping("pldel")
    public String pldel(String[] ids){
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<ids.length;i++){
            list.add(Integer.parseInt(ids[i]));
        }
        int count=shopService.pldel(list);
        return count>0?"redirect:loadShops":"error";
    }
    @RequestMapping("loadByShopId")
    public String loadByShopId(int shopId,Model model){
        Shop shop=shopService.loadByShopId(shopId);
        model.addAttribute("updateShop",shop);
        return "update";
    }
    @RequestMapping("updateShop")
    public String updateShop(Shop shop){
        boolean bool=shopService.updateShop(shop);
        return bool?"redirect:loadShops":"error";
    }
    @RequestMapping("muhuShop")
    public String mohuShop(@RequestParam(required = false,defaultValue = "1")int page,
                           @RequestParam(required = false,defaultValue = "5")int rows,
                           Model model,String shopName){
        int maxPage=shopService.calcMaxPage(rows);
        if (page<1){
            page=maxPage;
        }
        if (page>maxPage){
            page=1;
        }
        List<Shop> shopList=shopService.mohuShop(shopName);
        model.addAttribute("maxPage",maxPage);
        model.addAttribute("currentPage",page);
        model.addAttribute("shopList",shopList);
        return "shopmanage";
    }



}
