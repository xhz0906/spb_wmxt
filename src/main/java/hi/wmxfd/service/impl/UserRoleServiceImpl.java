package hi.wmxfd.service.impl;

import hi.wmxfd.mapper.UserRoleMapper;
import hi.wmxfd.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
   private UserRoleMapper userRoleMapper;
    @Override
    public boolean delUserRole(int userId) {
        boolean b = userRoleMapper.delUserRole(userId);
        return b;
    }

    @Override
    public boolean delMoreUserRole(List<Integer> ids) {
        int i = userRoleMapper.delMoreUserRole(ids);
        return i!=0?true:false;
    }

}
