package entity;

public class Major {
    private int id;
    private String name;
    private String branch;
    private String province;
    private String year;
    private String text;
    private String type;
    private String introduction;
    private int collegeId;

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

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public Major(String name, String branch, String province, String year, String text, String type, String introduction, int collegeId) {
        this.name = name;
        this.branch = branch;
        this.province = province;
        this.year = year;
        this.text = text;
        this.type = type;
        this.introduction = introduction;
        this.collegeId = collegeId;
    }
}
