package hi.wmxfd.mapper;

import hi.wmxfd.pojo.Shopping;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopMapper {
    /**分页展示所有
     * @param
     * @return List<Shopping></>
     */
    public List<Shopping> loadPage();
    /**总行数
     * @param
     * @return
     */
    public int ToTalCount();
}
