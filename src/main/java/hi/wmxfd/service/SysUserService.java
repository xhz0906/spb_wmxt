package hi.wmxfd.service;
import hi.wmxfd.pojo.SysPermission;
import hi.wmxfd.pojo.SysUser;
import java.util.List;

public interface SysUserService {
    public SysUser findUserByLoginName(String loginName);
    public List<SysPermission> findPermissionsByLoginName(String loginName);
    public int findRoleId(String loginName);
    //注册添加
    public boolean addUser(SysUser sysUser);
    public  boolean addUserRid(int uid);
    public List<SysUser> loadAll(int page,int rows);
    public int calcMaxPage(int rows);
    public List<SysUser> select(String keyword);
    public boolean delete(int userId);
    public SysUser getUserById(int userId);
    public boolean update(SysUser sysUser);
    public boolean delUser(List<Integer> ids);

}
