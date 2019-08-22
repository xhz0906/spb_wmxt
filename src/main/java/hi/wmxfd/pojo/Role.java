package hi.wmxfd.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class Role implements Serializable {
    private int role_id;
    private String role_name;
    private String role_desc;
}
