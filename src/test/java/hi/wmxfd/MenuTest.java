package hi.wmxfd;

import hi.wmxfd.mapper.MenuMapper;
import hi.wmxfd.pojo.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest



public class MenuTest {
    @Autowired
    private MenuMapper menuMapper;
    @Test
    public void findMenu(){
    Menu menu=menuMapper.findMenu(1);
        System.out.println(menu);
    }

}
