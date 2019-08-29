package hi.wmxfd.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class Menu implements Serializable {
    private int menuId;
    private String menuName;
    private String menuPrice;
    private String menuUrl;
    private String menuTotal;
}
