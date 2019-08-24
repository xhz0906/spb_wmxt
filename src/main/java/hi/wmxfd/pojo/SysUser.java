package hi.wmxfd.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class SysUser implements Serializable {
    private long userId;//用户id
    private String loginName;//登陆名
    private String password;//密码
    private String userEmali;//邮箱地址

}
