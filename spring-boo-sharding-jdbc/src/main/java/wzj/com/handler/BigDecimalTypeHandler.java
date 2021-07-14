package wzj.com.handler;

import org.apache.ibatis.type.*;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName BigDecimalTypeHandler
 * @Description
 * @Author wzj
 * @Date 2021/7/12 16:31
 **/
/* 数据库中的数据类型 */
@MappedJdbcTypes(JdbcType.NUMERIC)

/* 转化后的数据类型 */
@MappedTypes(value = java.lang.Long.class)
public class BigDecimalTypeHandler implements TypeHandler<Long> {


    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Long aLong, JdbcType jdbcType) throws SQLException {
        preparedStatement.setLong(i,aLong);
    }

    @Override
    public Long getResult(ResultSet resultSet, String s) throws SQLException {
        return Long.valueOf(resultSet.getString(s));
    }

    @Override
    public Long getResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getLong(i);
    }

    @Override
    public Long getResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getLong(i);
    }
}
