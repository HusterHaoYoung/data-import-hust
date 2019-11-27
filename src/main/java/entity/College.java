package entity;

import org.json.JSONObject;

public class College {
    private int id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String index;
    private String introduction;
    private String img;
    private String introLink;
    private int wid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getIntroLink() {
        return introLink;
    }

    public void setIntroLink(String introLink) {
        this.introLink = introLink;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public College(String name, String phone, String email, String address, String index, String introduction, String img, String introLink, int wid) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.index = index;
        this.introduction = introduction;
        this.img = img;
        this.introLink = introLink;
        this.wid = wid;
    }

    public College() {
    }

    @Override
    public String toString() {
        return (new JSONObject(this)).toString();
    }
}
