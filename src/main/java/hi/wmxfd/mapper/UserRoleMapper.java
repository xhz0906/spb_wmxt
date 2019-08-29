package hi.wmxfd.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleMapper {
    public boolean delUserRole(int userId);
    public int delMoreUserRole(List<Integer> ids);
}
