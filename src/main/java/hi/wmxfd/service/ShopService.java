package hi.wmxfd.service;

import hi.wmxfd.pojo.Shop;

import java.util.List;

public interface ShopService {
    //分页查询
    public List<Shop> loadPage(int page, int rows);
    //查询最大页
    public int calcMaxPage(int rows);
}
