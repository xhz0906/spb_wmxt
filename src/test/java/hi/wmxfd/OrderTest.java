package hi.wmxfd;

import hi.wmxfd.mapper.OrderMapper;
import hi.wmxfd.mapper.SysUserMapper;
import hi.wmxfd.pojo.Menu;
import hi.wmxfd.pojo.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {

    @Autowired
    private OrderMapper orderMapper;
    @Test
    public void contextLoads() {
        List<Order> orders=orderMapper.findOrder();
        System.out.println(orders);
    }
    @Test
    public void updateOrder(){
        boolean bool=orderMapper.updateOrder(1);
        System.out.println(bool);
    }
    @Test
    public void findOrder(){
        List<Integer> list=orderMapper.findUserOrder(3);
        for (int cid:list) {
            System.out.println(cid);
        }
    }
    @Test
    public void findUserMenu(){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Menu> menuList=orderMapper.loadUserMenu(list);
        for (Menu menu:menuList
        ) {
            System.out.println(menu);
        }
    }
    @Test
    public void findCount(){
        /*int*/
    }


}
