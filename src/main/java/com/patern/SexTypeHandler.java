package com.patern;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.patern.enums.UserSexEnum;

public class SexTypeHandler extends BaseTypeHandler<UserSexEnum>{  
  
    @Override  
    public UserSexEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {  
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放String类型  
        String i = rs.getString(columnName);  
        if (rs.wasNull()) {  
            return null;  
        } else {  
            // 根据数据库中的value值，定位PersonType子类  
            return UserSexEnum.getEnum(i);  
        }  
    }  
  
    @Override  
    public UserSexEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {  
        // 根据数据库存储类型决定获取类型，本例子中数据库中存放String类型  
         String i = rs.getString(columnIndex);  
        if (rs.wasNull()) {  
            return null;  
        } else {  
             // 根据数据库中的value值，定位PersonType子类  
            return UserSexEnum.getEnum(i);  
        }  
    }  
  
    @Override  
    public UserSexEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {  
         // 根据数据库存储类型决定获取类型，本例子中数据库中存放String类型  
     String i = cs.getString(columnIndex);  
       if (cs.wasNull()) {  
           return null;  
       } else {  
         // 根据数据库中的value值，定位PersonType子类  
           return UserSexEnum.getEnum(i);  
       }  
    }  
  
    @Override  
    public void setNonNullParameter(PreparedStatement ps, int i, UserSexEnum parameter, JdbcType jdbcType)  
            throws SQLException {  
        // baseTypeHandler已经帮我们做了parameter的null判断  
        ps.setString(i, parameter.getValue());  
  
    }  
      
}  