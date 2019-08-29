package hi.wmxfd.service;

import hi.wmxfd.pojo.Menu;

import java.util.List;

public interface MenuService {
    public List<Menu> loadMenu(int shopId);
    public Menu findMenu(int shopId);

}
