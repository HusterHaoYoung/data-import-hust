package entity;

public class Dynamic {
    private int id;
    private String title;
    private String link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Dynamic(String title, String link) {
        this.title = title;
        this.link = link;
    }
}
