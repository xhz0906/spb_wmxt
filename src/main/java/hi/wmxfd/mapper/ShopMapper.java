package hi.wmxfd.mapper;

import hi.wmxfd.pojo.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
     * @return int
     */
    public int ToTalCount();
    /**增加店铺
     * @param shop 对象
     * @return int
     */
    public int saveShop(Shop shop);
    /**删除一个店铺
     * @param shopId 店铺编号
     * @return int
     */
    public int deleteShop(int shopId);
    /**批量删除
     * @param ids 若干个
     * @return int
     */
    public int pldel(List<Integer> ids);
    /**根据shopId获取对象
     * @param shopId 店铺编号
     * @return shop 对象
     */
    public Shop loadByShopId(int shopId);
    /**修改
     * @param shop 对象
     * @return int
     */
    public int updateShop(Shop shop);
    /**模糊查询
     * @param shopName 店名
     * @return List<Shop> 店铺集合
     */
    public List<Shop> mohuShop(@Param("shopName")String shopName);

}
