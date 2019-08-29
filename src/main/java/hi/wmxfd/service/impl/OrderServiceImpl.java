package hi.wmxfd.service.impl;

import com.github.pagehelper.PageHelper;
import hi.wmxfd.mapper.OrderMapper;
import hi.wmxfd.pojo.Menu;
import hi.wmxfd.pojo.Order;
import hi.wmxfd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    //加载订单
    @Override
    public List<Order> findAllOrder(int page,int rows) {
        PageHelper.startPage(page, rows);
        return orderMapper.findAllOrder();
    }

    @Override
    public List<Order> findOrder() {
        return orderMapper.findOrder();
    }

    @Override
    public int calcMaxOrder(int rows) {
        int count=orderMapper.getTotalCount();
        return count%rows==0?count/rows:count/rows+1;
    }
    //审核订单
    @Override
    public boolean updateOrder(int ddId) {
        boolean bool=orderMapper.updateOrder(ddId);
        return bool;
    }

    @Override
    public boolean deleteOrder(int ddId) {
        boolean bool=orderMapper.deleteOrder(ddId);
        return bool;
    }

    @Override
    public List<Integer> findUserOrder(int uid) {
        List<Integer> list=orderMapper.findUserOrder(uid);
        return list;
    }
    @Override
    public List<Menu> loadUserMenu(List<Integer> list) {
        List<Menu> menuList=orderMapper.loadUserMenu(list);
        return menuList;
    }

    @Override
    public int findCount(int uid,int cid) {
        int count=orderMapper.findCount(uid,cid);
        return count;
    }
}
