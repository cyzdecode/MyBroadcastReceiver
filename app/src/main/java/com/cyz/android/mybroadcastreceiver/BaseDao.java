package com.cyz.android.mybroadcastreceiver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 陈志 on 2018/11/27.
 */

public class BaseDao{
    private Connection conn=null;

    //获取连接
    public Connection getConnection(){
        try {
            //通过反射来加载驱动  参数传递的是你的驱动的包名
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接对象//第一个参数是url地址，第二个参数是你数据库的用户名，第三个参数是密码
            conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hostpital?useUnicode=true&characterEncoding=utf-8", "root", "root");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conn;
    }

    //增删改的方法
    //第一个参数传递的是sql语句  ,第二个参数传一个数组，用于替换占位符
    //delete from user where id=?;
    public int update(String sql,Object[] objects){
        int num=-1;
        try {
            //获取连接对象
            conn=getConnection();
            //设置事务不能自动提交
            conn.setAutoCommit(false);
            //得到执行sql语句的对象
            PreparedStatement ps=conn.prepareStatement(sql);
            //判断数值是否为空
            if(objects != null && objects.length>0){
                //开始遍历数组，给占位符赋值
                for (int i = 0; i < objects.length; i++) {
                    //给占位符赋值
                    ps.setObject(i+1,objects[i]);
                }
            }
            num = ps.executeUpdate();
            //提交事务
            conn.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return num;
    }

    //查询的方法
    public ResultSet getResultSet(String sql,Object[] objects){
        ResultSet rs = null;
        try {
            //获取连接对象
            conn=getConnection();
            //得到执行sql语句的对象
            PreparedStatement ps=conn.prepareStatement(sql);
            //判断数值是否为空
            if(objects != null && objects.length>0){
                //开始遍历数组，给占位符赋值
                for (int i = 0; i < objects.length; i++) {
                    //给占位符赋值
                    ps.setObject(i+1,objects[i]);
                }
            }
            //执行查询的方法
            rs = ps.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return rs;
    }

    //关闭资源的方法  从下往上关闭资源
    public void close(Connection conn, PreparedStatement ps, ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(conn != null){
                conn.close();
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
