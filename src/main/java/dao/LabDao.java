package dao;

import entity.College;
import entity.Lab;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :younghao
 * @ClassName: LabDao
 * @Description: TODO
 * @date : 11/25/19  3:16 PM
 */
public class LabDao {
    private static Connection conn = null;

    // PreparedStatement对象用来执行SQL语句
    private static PreparedStatement pst = null;

    //结果集
    private static ResultSet rs = null;
    /**
     * @Author : younghao
     * @Description : // addLab
     * @Date 3:18 PM 11/25/19
     * @Parm [lab]
     * @return void
     **/
    public void addLab(Lab lab) {
        try {
            conn = DBHelper.getConnection();  //从DBHelper获取连接对象

            // 创建statement 执行数据库语句，第一不预处理，第二步才是正式。执行的语句可以修改.
            // 不过为了防止SQl注入。骗取登录，所以最好创建它的子类PreparedStatement
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO lab(name,college_id,college_name,phone,email,address,img,website) VALUES (?,?,?,?,?,?,?,?) ");
            pst = conn.prepareStatement(sql.toString());// 预处理
            pst.setString(1, lab.getName());
            pst.setInt(2, lab.getCollegeId());
            pst.setString(3, lab.getCollegeName());
            pst.setString(4,lab.getPhone());
            pst.setString(5,lab.getEmail());
            pst.setString(6,lab.getAddress());
            pst.setString(7,lab.getImg());
            pst.setString(8,lab.getWebsite());
            System.out.println(sql);
            pst.executeUpdate();// 这里才是执行，获得数据。

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源.一定要关闭资源。数据库的每一个连接都占据服务器资源。
            // 我们写代码的时候感觉不到，
            // 但是一旦服务器运行个三五天，连接就会不断地增加，最终导致资源不足，
            // 服务器将自动关机来强行关闭连接。
            // 而且这里面，不仅这里，全部过程都不要抛出异常，而是要捕捉处理异常，不然也会导致资源浪费。
            //即使前面抛出异常，程序中断，也会执行关闭资源，而不影响浪费。

            try {
                // 这里最好要先判断是否为空，不为空了，才去关闭。
                // 而且要从小到大的关闭，顺序不能乱
                if (rs != null)
                    rs.close();
                if (pst != null)
                    pst.close();
				/*if (conn != null)
					conn.close(); */    //注意：如果后续还要使用connection，则不用关闭
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * @Author : younghao
     * @Description : // TO DO
     * @Date 3:25 PM 11/25/19
     * @Parm [lab]
     * @return void
     **/
    public void updateLabCollegeId(int collegeId,String collegeName) {
        try {
            conn = DBHelper.getConnection();  //从DBHelper获取连接对象

            // 创建statement 执行数据库语句，第一不预处理，第二步才是正式。执行的语句可以修改.
            // 不过为了防止SQl注入。骗取登录，所以最好创建它的子类PreparedStatement
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE lab SET college_id = ? where college_name = ?");
            pst = conn.prepareStatement(sql.toString());// 预处理
            pst.setInt(1, collegeId);
            pst.setString(2,collegeName);
            System.out.println(sql);
            pst.executeUpdate();// 这里才是执行，获得数据。

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 这里最好要先判断是否为空，不为空了，才去关闭。
                // 而且要从小到大的关闭，顺序不能乱
                if (rs != null)
                    rs.close();
                if (pst != null)
                    pst.close();
				/*if (conn != null)
					conn.close(); */    //注意：如果后续还要使用connection，则不用关闭
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
