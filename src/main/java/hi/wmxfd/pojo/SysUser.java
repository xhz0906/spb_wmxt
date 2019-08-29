package hi.wmxfd.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class SysUser implements Serializable {
    private int userId;//用户id
    private String loginName;//登陆名
    private String password;//密码
    private String userEmail;//邮箱地址
    private String userTel;
    private String userAdress;
}
