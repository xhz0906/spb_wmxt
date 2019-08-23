package hi.wmxfd.pojo;

import lombok.Data;

import java.io.Serializable;

public class Shopping implements Serializable {
    private int shopId;//店铺编码
    private String sname;//店铺名
    private String possessor;//所有人
    private String store_addressl;//店铺地址

    public Shopping() {
    }

    public Shopping(int shopId, String sname, String possessor, String store_addressl) {
        this.shopId = shopId;
        this.sname = sname;
        this.possessor = possessor;
        this.store_addressl = store_addressl;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPossessor() {
        return possessor;
    }

    public void setPossessor(String possessor) {
        this.possessor = possessor;
    }

    public String getStore_addressl() {
        return store_addressl;
    }

    public void setStore_addressl(String store_addressl) {
        this.store_addressl = store_addressl;
    }

    @Override
    public String toString() {
        return "Shopping{" +
                "shopId=" + shopId +
                ", sname='" + sname + '\'' +
                ", possessor='" + possessor + '\'' +
                ", store_addressl='" + store_addressl + '\'' +
                '}';
    }
}
