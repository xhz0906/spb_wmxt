package hi.wmxfd.service.impl;
import hi.wmxfd.mapper.SysUserMapper;
import hi.wmxfd.pojo.Role;
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

    @Override
    public int findRoleId(String loginName) {
        int rid=sysUserMapper.findRoleId(loginName);
        return rid;
    }


}
