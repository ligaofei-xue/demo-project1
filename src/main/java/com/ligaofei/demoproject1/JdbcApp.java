package com.ligaofei.demoproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 通过原生jdbc访问数据库
 */
public class JdbcApp {

    public static void main(String [] args) throws Exception {

        /**
         * 加载JDBC驱动程序
         * 创建数据库的连接
         * 创建preparedStatement
         * 执行SQL语句
         * 处理结果集
         * 关闭JDBC对象资源
         */
        Class.forName("com.mysql.cj.jdbc.Driver");
        //连接--不加serverTimezone=UTC会报The server time zone value '�й���׼ʱ��' is unrecognized or represents
        String url = "jdbc:mysql://127.0.0.1:3306/xdtest?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC";

        String username = "root";
        String password = "11001100";

        //获取连接对象，并连接数据库
       Connection connection = DriverManager.getConnection(url,username,password);

       //获取语句对象
       Statement statement = connection.createStatement();

       ResultSet resultSet =  statement.executeQuery("select * from video");

       while (resultSet.next()){
           System.out.println("视频标题:"+resultSet.getString("title"));
       }
       statement.close();
    }
}
