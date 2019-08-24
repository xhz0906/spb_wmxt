package hi.wmxfd.pojo;

import lombok.Data;

import java.io.Serializable;

public class Shop implements Serializable {
    private int shopId;//店铺编码
    private String shopName;//店铺名
    private String shopAdress;//店铺地址
    private String shopTel;//店铺电话
    private String shopUrl;//图片地址
    public Shop() {
    }

    public Shop(int shopId, String shopName, String shopAdress, String shopTel, String shopUrl) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopAdress = shopAdress;
        this.shopTel = shopTel;
        this.shopUrl = shopUrl;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAdress() {
        return shopAdress;
    }

    public void setShopAdress(String shopAdress) {
        this.shopAdress = shopAdress;
    }

    public String getShopTel() {
        return shopTel;
    }

    public void setShopTel(String shopTel) {
        this.shopTel = shopTel;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopId=" + shopId +
                ", shopName='" + shopName + '\'' +
                ", shopAdress='" + shopAdress + '\'' +
                ", shopTel='" + shopTel + '\'' +
                ", shopUrl='" + shopUrl + '\'' +
                '}';
    }
}
