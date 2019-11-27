package controller;

import entity.Lab;
import service.TeacherService;

public class importTeacher {
    private static TeacherService teacherService = new TeacherService();

    public static void main(String[] args) {
        String path = "http://122.205.6.10:8080/system/service/tsitesquery/teachers/research/zh_CN?cid=2281";
        Lab lab = new Lab();
        lab.setId(90);
        lab.setName("John Hopcroft工作室");
        lab.setIntroduction("华中科技大学John Hopcroft工作室依托于华中科技大学计算机科学与技术学院和华中科技大学创新研究院，成立于2014年9月，位于华中科技大学创新研究院。主要研究领域包括经典理论计算机科学的基础理论与算法研究以及大数据背景下的现代数据挖掘、机器学习、深度学习的基础理论与算法研究。");
        String[] teachers = {"金燕"};
        for (String techer : teachers) {
            teacherService.addTeacher(path, techer, lab);
        }
    }
}
// 115.156.150.175:80/system/service/tsitesquery/languages
