package hi.wmxfd.service;

import java.util.List;

public interface UserRoleService {
    public boolean delUserRole(int userId);
    public boolean delMoreUserRole(List<Integer> ids);
}
