package hi.wmxfd.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class Shop implements Serializable {
    private int shopId;//店铺编码
    private String shopName;//店铺名
    private String shopAdress;//店铺地址
    private String shopTel;//店铺电话
    private String shopUrl;//图片地址
    private String shopScore;

}
