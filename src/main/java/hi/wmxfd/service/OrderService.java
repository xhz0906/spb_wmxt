package hi.wmxfd.service;

import hi.wmxfd.pojo.Menu;
import hi.wmxfd.pojo.Order;

import java.util.List;

public interface OrderService {
    //加载所有
    public List<Order> findAllOrder(int page,int pages);
    //加载已处理订单
    public List<Order> findOrder();
    //查询最大
    public int calcMaxOrder(int rows);
    //审核订单
    public boolean updateOrder(int ddId);
    //删除订单
    public boolean deleteOrder(int ddId);
    //查找购物车
    public List<Integer> findUserOrder(int uid);
    public List<Menu> loadUserMenu(List<Integer> list);
    public int findCount(int uid,int cid);
}
