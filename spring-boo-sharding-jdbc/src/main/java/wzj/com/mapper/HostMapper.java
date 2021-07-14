package wzj.com.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import wzj.com.dto.HostDto;
import wzj.com.dto.UserDto;

/**
 * @ClassName UserMapper
 * @Description
 * @Author wzj
 * @Date 2021/7/3 12:43
 **/
@Mapper
public interface HostMapper {


    HostDto select();
}
