package hi.wmxfd.mapper;


import hi.wmxfd.pojo.Role;
import hi.wmxfd.pojo.SysPermission;
import hi.wmxfd.pojo.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SysUserMapper {
    /**根据登录名查询用户信息
     * @Parm loginName 登陆名
     * @return  SysUser 用户对象信息
     */

  public SysUser findUserInfo(@Param("loginName") String loginName);
   /*根据用户信息查询该用户已分配的权限集合
    @Param() loginName 登陆名（用户名）
    @return SysPErmissiom对象的集合*/

  public List<SysPermission> findPermissionInfo(String loginname);

  public int findRoleId(String loginName);



}
