package hi.wmxfd.service;

import hi.wmxfd.pojo.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopService {
    //分页查询
    public List<Shop> loadPage(int page, int rows);
    //查询最大页
    public int calcMaxPage(int rows);
    //增加店铺
    public boolean saveShop(Shop shop);
    //删除一个店铺
    public boolean deleteShop(int shopId);
    //批量删除
    public int pldel(List<Integer> ids);
    //根据shopId获取shop对象
    public Shop loadByShopId(int shopId);
    //修改
    public boolean updateShop(Shop shop);
    //模糊查询
    public  List<Shop> mohuShop(@Param("shopName")String shopName);

}
