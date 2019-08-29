package hi.wmxfd.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class Order implements Serializable {
    private int ddId;//订单号
    private int usid;//用户id;
    private int cid;//菜id
    private int state;//状态
}
