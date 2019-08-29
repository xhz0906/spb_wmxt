package hi.wmxfd.mapper;

import hi.wmxfd.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface MenuMapper {
    public List<Menu> loadMenu(int shopId);
    public Menu findMenu(int shopId);

}
