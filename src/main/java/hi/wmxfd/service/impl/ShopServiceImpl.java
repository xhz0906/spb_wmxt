package hi.wmxfd.service.impl;

import com.github.pagehelper.PageHelper;
import hi.wmxfd.mapper.ShopMapper;
import hi.wmxfd.pojo.Shop;
import hi.wmxfd.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Resource
    private ShopMapper shopMapper;

    @Override
    public List<Shop> loadPage(int page, int rows) {
        PageHelper.startPage(page,rows);
        return shopMapper.loadPage();
    }

    @Override
    public int calcMaxPage(int rows) {
        int count=shopMapper.ToTalCount();
        int maxPage=count%rows==0?count/rows:count/rows+1;
        return maxPage;
    }

    @Override
    public boolean saveShop(Shop shop) {
        int count=shopMapper.saveShop(shop);
        boolean bool=count>0?true:false;
        return bool;
    }

    @Override
    public boolean deleteShop(int shopId) {
        int count= shopMapper.deleteShop(shopId);
        boolean bool=count>0?true:false;
        return bool;
    }

    @Override
    public int pldel(List<Integer> ids) {
        int count=shopMapper.pldel(ids);
        return count;
    }

    @Override
    public Shop loadByShopId(int shopId) {
        Shop s=shopMapper.loadByShopId(shopId);
        return s;
    }

    @Override
    public boolean updateShop(Shop shop) {
        int count=shopMapper.updateShop(shop);
        boolean bool=count>0?true:false;
        return bool;
    }

    @Override
    public List<Shop> mohuShop(String shopName) {

        return shopMapper.mohuShop(shopName);
    }
}
