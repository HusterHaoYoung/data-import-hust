package dao;

import entity.WebNews;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author :younghao
 * @ClassName: WebNewsDao
 * @Description: TODO
 * @date : 12/5/19  8:29 PM
 */
public class WebNewsDao {
    // 数据库连接对象，注意：是导入“java.sql.Connection”此包下的连接对象。
    private static Connection conn = null;

    // PreparedStatement对象用来执行SQL语句
    private static PreparedStatement pst = null;

    //结果集
    private static ResultSet rs = null;

    //保存查询到的实体集合
    List list = null;

    /**
     * 查询数据库，获取一个User类型的list集合
     */
    public void addWebNews(WebNews webNews) {
        try {
            conn = DBHelper.getConnection();  //从DBHelper获取连接对象

            // 创建statement 执行数据库语句，第一不预处理，第二步才是正式。执行的语句可以修改.
            // 不过为了防止SQl注入。骗取登录，所以最好创建它的子类PreparedStatement
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO webnews(title,link,wbid,owner_name,editor,showtimes,summary,content) VALUES (?,?,?,?,?,?,?,?) ");
            pst = conn.prepareStatement(sql.toString());// 预处理
            pst.setString(1, webNews.getTitle());
            pst.setString(2,webNews.getLink());
            pst.setInt(3,webNews.getWbid());
            pst.setString(4,webNews.getOwnerName());
            pst.setString(5,webNews.getEditor());
            pst.setInt(6,webNews.getShowtimes());
            pst.setString(7,webNews.getSummary());
            pst.setString(8,webNews.getContent());
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
}
