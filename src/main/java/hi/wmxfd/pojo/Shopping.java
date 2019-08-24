package hi.wmxfd.pojo;

import lombok.Data;

import java.io.Serializable;

public class Shopping implements Serializable {
    private int sId;//店铺编码
    private String sName;//店铺名
    private String sphone;//电话
    private String sadress;//店铺地址

    public Shopping() {
    }

    public Shopping(int sId, String sName, String sphone, String sadress) {
        this.sId = sId;
        this.sName = sName;
        this.sphone = sphone;
        this.sadress = sadress;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getSadress() {
        return sadress;
    }

    public void setSadress(String sadress) {
        this.sadress = sadress;
    }

    @Override
    public String toString() {
        return "Shopping{" +
                "sId=" + sId +
                ", sName='" + sName + '\'' +
                ", sphone='" + sphone + '\'' +
                ", sadress='" + sadress + '\'' +
                '}';
    }
}
