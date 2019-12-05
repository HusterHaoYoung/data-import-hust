package entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author :younghao
 * @ClassName: WebNews
 * @Description: TODO
 * @date : 12/5/19  8:29 PM
 */
public class WebNews {
    private int id;
    private String title;
    private String link;
    private int wbid;
    private String ownerName;
    private String editor;
    private int showtimes;
    private String summary;
    private String content;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWbid() {
        return wbid;
    }

    public void setWbid(int wbid) {
        this.wbid = wbid;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public int getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(int showtimes) {
        this.showtimes = showtimes;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public WebNews() {
    }
}
