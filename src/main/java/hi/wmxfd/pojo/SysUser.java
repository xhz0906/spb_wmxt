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

    public SysUser() {
    }

    public SysUser(long userId, String loginName, String password, String userEmali) {
        this.userId = userId;
        this.loginName = loginName;
        this.password = password;
        this.userEmali = userEmali;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmali() {
        return userEmali;
    }

    public void setUserEmali(String userEmali) {
        this.userEmali = userEmali;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userId=" + userId +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", userEmali='" + userEmali + '\'' +
                '}';
    }
}
