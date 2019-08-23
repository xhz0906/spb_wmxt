package hi.wmxfd.service;

import hi.wmxfd.pojo.Shopping;

import java.util.List;

public interface ShopService {
    //分页查询
    public List<Shopping> loadPage(int page,int rows);
    //查询最大页
    public int calcMaxPage(int rows);
}
