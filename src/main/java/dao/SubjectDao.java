package dao;

import entity.Subject;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author :younghao
 * @ClassName: SubjectDao
 * @Description: data access Object for Subject
 * @date : 11/24/19  5:10 PM
 */
public class SubjectDao {
    /**
     * @Author : younghao
     * @Description : // add subject
     * @Date 5:11 PM 11/24/19
     * @Parm [subject]
     * @return boolean
     **/
    private static Connection conn = null;

    // PreparedStatement对象用来执行SQL语句
    private static PreparedStatement pst = null;

    //结果集
    private static ResultSet rs = null;

    public boolean addSubject(Subject subject) throws Exception {
        try {
            conn = DBHelper.getConnection();  //从DBHelper获取连接对象

            // 创建statement 执行数据库语句，第一不预处理，第二步才是正式。执行的语句可以修改.
            // 不过为了防止SQl注入。骗取登录，所以最好创建它的子类PreparedStatement
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO subject(name,pcode,code) VALUES (?,?,?) ");
            pst = conn.prepareStatement(sql.toString());// 预处理
            pst.setString(1, subject.getName());
            pst.setString(2, subject.getPcode());
            pst.setString(3, subject.getCode());
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
        return true;
    }
    public boolean addSubjectWithCollege(Subject subject) throws Exception {
        try {
            conn = DBHelper.getConnection();  //从DBHelper获取连接对象

            // 创建statement 执行数据库语句，第一不预处理，第二步才是正式。执行的语句可以修改.
            // 不过为了防止SQl注入。骗取登录，所以最好创建它的子类PreparedStatement
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO subject(name,college_id,college_name,pcode,code) VALUES (?,?,?,?,?) ");
            pst = conn.prepareStatement(sql.toString());// 预处理
            pst.setString(1, subject.getName());
            pst.setInt(2, subject.getCollegeId());
            pst.setString(3, subject.getCollegeName());
            pst.setString(4, subject.getPcode());
            pst.setString(5, subject.getCode());
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
        return true;
    }
}
