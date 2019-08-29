package hi.wmxfd.service.impl;

import hi.wmxfd.mapper.MenuMapper;
import hi.wmxfd.pojo.Menu;
import hi.wmxfd.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> loadMenu(int shopId) {
        List<Menu> menus = menuMapper.loadMenu(shopId);
        return menus;
    }

    @Override
    public Menu findMenu(int shopId) {
        Menu menu=menuMapper.findMenu(shopId);
        return menu;
    }
}
