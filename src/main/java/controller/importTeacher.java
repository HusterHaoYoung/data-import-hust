package controller;

import entity.Lab;
import entity.Teacher;
import service.TeacherService;

import java.util.List;

public class importTeacher {
    private static TeacherService teacherService = new TeacherService();

    public static void main(String[] args) {
        String path = "http://122.205.6.10:8080/system/service/tsitesquery/teachers/research/zh_CN?cid=2373";
        List<Teacher> teachers = teacherService.getTeacherList();
        for (Teacher teacher:teachers){
            System.out.println(teacher.getName());
            teacherService.updateTeacherIsDTorT(path,teacher.getTid());
        }

    }
}
// 115.156.150.175:80/system/service/tsitesquery/languages
