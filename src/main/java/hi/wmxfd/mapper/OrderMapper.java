package hi.wmxfd.mapper;

import hi.wmxfd.pojo.Menu;
import hi.wmxfd.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.hibernate.validator.constraints.URL;

import java.util.List;
@Mapper
public interface OrderMapper {
    //加载全部未处理订单
    public List<Order> findAllOrder();

    //加载已处理订单
    public List<Order> findOrder();

    //总行数
    public int getTotalCount();

    //审核订单
    public boolean updateOrder(int ddId);
    //删除订单
    public boolean deleteOrder(int ddId);
    //查询购物车
    public List<Integer> findUserOrder(int uid);
    //查询用户购物车
    public List<Menu> loadUserMenu(List<Integer> list);
    public int findCount(int uid,int cid);

}