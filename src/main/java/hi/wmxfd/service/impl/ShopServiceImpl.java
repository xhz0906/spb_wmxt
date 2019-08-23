package hi.wmxfd.service.impl;

import hi.wmxfd.mapper.ShopMapper;
import hi.wmxfd.pojo.Shopping;
import hi.wmxfd.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopMapper shopMapper;
    @Override
    public List<Shopping> findAllShopInfo() {
        List<Shopping> shops=shopMapper.findAllShopInfo();
        return shops;
    }
}
