package hi.wmxfd.mapper;

import hi.wmxfd.pojo.Shopping;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopMapper {
    /**查询所有店铺信息
     * @param
     * @return List<Shopping></>
     */
    public List<Shopping> findAllShopInfo();
}
