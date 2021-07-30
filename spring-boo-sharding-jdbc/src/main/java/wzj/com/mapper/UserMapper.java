package wzj.com.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import wzj.com.dto.UserDto;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description
 * @Author wzj
 * @Date 2021/7/3 12:43
 **/
@Mapper
public interface UserMapper {

    int insert(UserDto record);

    int updateById(@Param("id") long id, @Param("name") String name);

    UserDto getById(long id);

    List<UserDto> selectTest();
}
