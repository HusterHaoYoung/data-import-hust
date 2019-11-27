package entity;

public class Lab {
    private int id;
    private String name;
    private int collegeId;
    private String collegeName;
    private String phone;
    private String email;
    private String address;
    private String introduction;
    private String introLink;
    private String img;
    private String website;

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

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

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
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

    public Lab(String name, int collegeId, String collegeName, String phone, String email, String address, String introduction, String img, String introLink, String website) {
        this.name = name;
        this.collegeId = collegeId;
        this.collegeName = collegeName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.introduction = introduction;
        this.img = img;
        this.introLink = introLink;
        this.website = website;
    }
    public Lab(){

    }
}
