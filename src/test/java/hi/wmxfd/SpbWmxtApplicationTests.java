package hi.wmxfd;

import hi.wmxfd.mapper.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpbWmxtApplicationTests {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Test
    public void contextLoads() {
        int rid=sysUserMapper.findRoleId("admin");
        System.out.println(rid);
    }

}
