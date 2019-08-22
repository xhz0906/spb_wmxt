package hi.wmxfd.service;
import hi.wmxfd.pojo.SysPermission;
import hi.wmxfd.pojo.SysUser;
import java.util.List;

public interface SysUserService {
    public SysUser findUserByLoginName(String loginName);
    public List<SysPermission> findPermissionsByLoginName(String loginName);
    public int findRoleId(String loginName);

}
