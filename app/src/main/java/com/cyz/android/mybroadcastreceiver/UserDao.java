package com.cyz.android.mybroadcastreceiver;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 陈志 on 2018/11/27.
 */

public class UserDao extends BaseDao{
    public User selectByName(String u_loginName,String u_passWord){
        User user = new User();
        String sql = "select * from user where u_loginName=?";
        Object[] objects = {u_loginName};
        ResultSet rs = super.getResultSet(sql,objects);
        try {
            if(rs.next()){
                user.setR_id(rs.getInt("r_id"));
                user.setU_email(rs.getString("u_email"));
                user.setU_loginName(rs.getString("u_loginName"));
                user.setU_passWord(rs.getString("u_passWord"));
                user.setU_state(rs.getInt("u_state"));
                user.setU_trueName(rs.getString("u_trueName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(user.getU_passWord().equals(u_passWord)) {
            return user;
        }
        return null;
    }

}
