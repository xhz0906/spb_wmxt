package hi.wmxfd.mapper;

import hi.wmxfd.pojo.Shop;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopMapper {
    /**分页展示所有
     * @param
     * @return List<Shop></>
     */
    public List<Shop> loadPage();
    /**总行数
     * @param
     * @return
     */
    public int ToTalCount();
    /**增加店铺
     * @param
     * @return
     */
    public int saveShop(Shop shop);

}
