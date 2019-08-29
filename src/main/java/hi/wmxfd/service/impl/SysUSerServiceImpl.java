package hi.wmxfd.service.impl;
import com.github.pagehelper.PageHelper;
import hi.wmxfd.mapper.SysUserMapper;
import hi.wmxfd.pojo.SysPermission;
import hi.wmxfd.pojo.SysUser;
import hi.wmxfd.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SysUSerServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findUserByLoginName(String loginName) {
        SysUser sysUser=sysUserMapper.findUserInfo(loginName);
        return sysUser;
    }

    @Override
    public List<SysPermission> findPermissionsByLoginName(String loginName) {
        List<SysPermission> sysPermissions =sysUserMapper.findPermissionInfo(loginName);
        return sysPermissions;
    }
    //查找角色id
    @Override
    public int findRoleId(String loginName) {
        int rid=sysUserMapper.findRoleId(loginName);
        return rid;
    }
    //添加用户
    @Override
    public boolean addUser(SysUser sysUser) {
        boolean bool=sysUserMapper.addUser(sysUser);
        return bool;
    }

    @Override
    public boolean addUserRid(int uid) {
        boolean bool=sysUserMapper.addUserRid(uid);
        return bool;
    }
    @Override
    public List<SysUser> loadAll(int page, int rows) {
        PageHelper.startPage(page,rows);
        return sysUserMapper.loadAll();
    }

    @Override
    public int calcMaxPage(int rows) {
        int count=sysUserMapper.getTotalCount();
        return count%rows==0?count/rows:count/rows+1;
    }


    @Override
    public List<SysUser> select(String keyword) {
        List<SysUser> select = sysUserMapper.select(keyword);
        return select;
    }

    @Override
    public boolean delete(int userId) {
        int b = sysUserMapper.delete(userId);
        return b!=0?true:false;
    }

    @Override
    public SysUser getUserById(int userId) {
        SysUser sysUser = sysUserMapper.getUserById(userId);
        return sysUser;
    }

    @Override
    public boolean update(SysUser sysUser) {
        int update = sysUserMapper.update(sysUser);
        return update!=0?true:false;
    }

    @Override
    public boolean delUser(List<Integer> ids) {
        int i = sysUserMapper.delUser(ids);
        return i!=0?true:false;
    }


}
