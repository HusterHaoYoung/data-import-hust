package entity;

public class Subject {
    private int id;
    private String name;
    private int collegeId;
    private String collegeName;
    private String pcode;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public Subject(int id, String name, int collegeId, String collegeName, String pcode,String code) {
        this.id = id;
        this.name = name;
        this.collegeId = collegeId;
        this.collegeName = collegeName;
        this.pcode = pcode;
        this.code = code;
    }

    public Subject() {
    }
}
