package dao;

import entity.College;
import entity.Teacher;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :younghao
 * @ClassName: CollegeDao
 * @Description: TODO
 * @date : 11/24/19  8:06 PM
 */
public class CollegeDao {
    /**
     * @Author : younghao
     * @Description : // TO DO
     * @Date 8:08 PM 11/24/19
     * @Parm []
     * @return java.util.List<entity.College>
     **/
    private static Connection conn = null;

    // PreparedStatement对象用来执行SQL语句
    private static PreparedStatement pst = null;

    //结果集
    private static ResultSet rs = null;

    public List<College> getCollegeList() {
        List<College> colleges = new ArrayList<College>();
        try {
            conn = DBHelper.getConnection();  //从DBHelper获取连接对象

            // 创建statement 执行数据库语句，第一不预处理，第二步才是正式。执行的语句可以修改.
            // 不过为了防止SQl注入。骗取登录，所以最好创建它的子类PreparedStatement
            pst = conn.prepareStatement("SELECT *  FROM college");// 预处理

            rs = pst.executeQuery();// 这里才是执行，获得数据。

            // 遍历处理结果集，用while 方法next方法,相当于指针依次下移，获得每一行表的数据

            while (rs.next()) {
                College college = new College();
                college.setId(rs.getInt(1));
                college.setName(rs.getString(2));
                college.setPhone(rs.getString(3));
                college.setEmail(rs.getString(4));
                college.setAddress(rs.getString(5));
                college.setIndex(rs.getString(6));
                college.setIntroduction(rs.getString(7));
                college.setWid(rs.getInt(8));
                college.setIntroLink(rs.getString(9));
                college.setImg(rs.getString(10));
                colleges.add(college);
                /**
                 * 两种get,
                 * 一种是根据下标 从1开始每一列，
                 * rs.getInt(1);
                 * rs.getString(2);
                 * rs.getString(3);
                 * 第二个是根据列名查找。根据表的列数据类型使用不同的个体方法
                 */

                //为user属性赋值
//                user.setId(rs.getInt(1));
//                user.setName(rs.getString(2));
            }
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
        return colleges;
    }

}