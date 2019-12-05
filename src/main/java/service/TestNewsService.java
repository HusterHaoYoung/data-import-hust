package service;

import dao.WebNewsDao;
import entity.WebNews;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Timestamp;
import java.util.HashMap;

/**
 * @author :younghao
 * @ClassName: TestNewsService
 * @Description: TODO
 * @date : 12/5/19  4:53 PM
 */
public class TestNewsService {
    public static void main(String[] args) {
        WebNewsDao webNewsDao = new WebNewsDao();
        String serverpath = "https://122.205.6.11:9999/system/services/NewsService?wsdl";
//创建 Service实例
        Service service = new Service();
        Call call;
        try {
//通过Service实例创建Call的实例
            call = (Call) service.createCall();
//将Web Service的服务路径加入到call实例之中,设置服务的位置
            call.setTargetEndpointAddress(serverpath);
            //调用服务中的getOwners()方法,
//注意,此方法invoke有两个参数:
//参数getOwners:文章webservice接口中的getOwners()接口
//参数null:getOwners()接口用的参数,因为此接口无参数,所以这里使用了null
//返回值a为String[] ,不同的接口返回值不同,您需要在这里做转换
            String[] ownerList = (String[])call.invoke("getOwners",null);
            String a = (String) call.invoke("getlistByOwner",new Object[]{"1276650557",0,2});
            HashMap<String,String> hashMap = new HashMap<>();
            for (int i = 0; i < ownerList.length; i++) {
                String []kv = ownerList[i].split("#");
                hashMap.put(kv[0],kv[1]);
                String ownerNews = (String) call.invoke("getlistByOwner",new Object[]{kv[0],0,-1});
                if (ownerNews == null) {
                    System.out.println("callOwners no data!");
                }
                JSONArray jsonArray = new JSONArray(ownerNews);
                System.out.println(jsonArray);
                for (int j = 0; j < jsonArray.length(); j++) {
                    System.out.println("j= "+j+"    newsid="+Integer.parseInt(jsonArray.getJSONObject(j).getString("id"))+"   ownerid = "+kv[0]);
                    String news = (String) call.invoke("getWbnewsById",new Object[]{Integer.parseInt(jsonArray.getJSONObject(j).getString("id")),kv[0]});
                    JSONObject jsonObject = new JSONObject(news);
                    WebNews webNews = new WebNews();
                    webNews.setTitle(jsonArray.getJSONObject(j).getString("title"));
                    webNews.setLink(jsonObject.getString("newurl"));
                    webNews.setWbid(Integer.parseInt(jsonArray.getJSONObject(j).getString("id")));
                    webNews.setOwnerName(kv[1]);
                    webNews.setEditor(jsonObject.getString("wbeditor"));
                    webNews.setShowtimes(jsonObject.getInt("wbshowtimes"));
                    webNews.setContent(jsonObject.getString("wbcontent"));
                    webNews.setDate( jsonArray.getJSONObject(j).getString("date"));
                    webNews.setSummary(jsonObject.getString("wbsummary"));
                    webNewsDao.addWebNews(webNews);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
