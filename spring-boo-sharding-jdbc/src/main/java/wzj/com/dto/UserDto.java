package wzj.com.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName UserDto
 * @Description
 * @Author wzj
 * @Date 2021/7/3 12:30
 **/
@Data
public class UserDto {

    public long id;
    public String name;

    public UserDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserDto(BigDecimal id, String name) {
        this.id = id.longValue();
        this.name = name;
    }
}
