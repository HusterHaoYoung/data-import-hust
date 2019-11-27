package controller;

import entity.College;
import service.CollegeService;
import service.SubjectService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author :younghao
 * @ClassName: ImportSubject
 * @Description: import the data of subject
 * @date : 11/24/19  5:40 PM
 */
public class ImportSubject {
    /**
     * @Author : younghao
     * @Description : // 导入同一fcode的学科数据
     * @Date 5:41 PM 11/24/19
     * @Parm [fcode]
     * @return void
     **/
    SubjectService subjectService = new SubjectService();

    public void importSubjectFromFcode(String fcode, String path, int collegeId, String collegeName) throws Exception {
        subjectService.addSubject(fcode, path, collegeId, collegeName);
    }
    public void importSubjectWithCollege(String path, int collegeId, String collegeName) throws Exception {
        subjectService.addSubjectWithCollege(path,collegeId,collegeName);
    }
    public static void main(String[] args) throws Exception {
        ImportSubject importSubject = new ImportSubject();
        CollegeService collegeService = new CollegeService();
        Integer collegeId = null;
        String collegeName = "";
        String path1 = "http://122.205.6.10:8080/system/service/tsitesquery/disciplines/research/zh_CN/ROOT";
        String path2 = "http://122.205.6.10:8080/system/service/tsitesquery/disciplines/research/zh_CN/";
        String fcode = "01";
        String[] fcodes = {"02","03","04","05","07","08","10","12","13"};
        importSubject.subjectService.addSubjects(path1);
//        List<College> colleges = collegeService.getColleges();

//        for (String str:fcodes){
//            importSubject.importSubjectFromFcode(str, path1, 1, collegeName);
//        }
//        for (College college:colleges){
//            String newPath = path2 + college.getWid();
//            System.out.println(college.getName());
//            importSubject.importSubjectWithCollege(newPath,college.getId(),college.getName());
//        }
    }
}
