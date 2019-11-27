package service;

import dao.TeacherDao;
import entity.Lab;
import entity.Teacher;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author :younghao
 * @ClassName: TeacherService
 * @Description: TODO
 * @date : 11/25/19  4:14 PM
 */
public class TeacherService {

    private TeacherDao dao = new TeacherDao();

    public void addTeacher(String path, String teacherName, Lab lab) {
        JSONObject j = GetJSONDataService.getJSONService(path);
        JSONArray jsonArray = new JSONArray(j.get("results").toString());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            if (json.get("name").equals(teacherName)) {
                Teacher teacher = new Teacher();
                teacher.setName(teacherName.trim());
                teacher.setEmail(json.get("email").toString().trim());
                teacher.setProrank(json.get("prorank").toString().trim());
                teacher.setHonor(json.get("honor").toString());
                if("".equals(json.get("officeLocation"))){
                    teacher.setAddress(lab.getAddress());
                }else {
                    teacher.setAddress(json.get("officeLocation").toString());
                }
                teacher.setIntroduction(json.get("profile").toString());
                teacher.setSubjectName(json.get("discipline").toString().trim());
                teacher.setCollegeName(json.get("unit").toString().trim());
                teacher.setLabName(lab.getName());
                teacher.setLabId(lab.getId());
                teacher.setTid(Integer.parseInt(json.get("teacherId").toString()));
                teacher.setLabIntroduction(lab.getIntroduction());
                teacher.setImg(json.get("picurl").toString());
                teacher.setHomepage(json.get("url").toString());
                teacher.setLabWebsite(lab.getWebsite());
                dao.addTeacher(teacher);
            }
        }
    }
}