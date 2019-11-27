package service;

import dao.SubjectDao;
import entity.Subject;
import org.json.JSONArray;
import org.json.JSONObject;

public class SubjectService {
    /**
     * @return boolean
     * @Author : younghao
     * @Description : // add subject to database
     * @Date 4:42 PM 11/24/19
     * @Parm [code]
     **/
    private SubjectDao dao = new SubjectDao();

    public boolean addSubject(String fcode, String path, Integer collegeId, String collegeName) throws Exception {
        JSONArray jsonArray = GetJSONDataService.getJSONArrayService(path);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            if (json.get("fcode").equals(fcode)) {
                Subject subject = new Subject();
                subject.setName(json.get("name").toString());
                subject.setPcode(fcode);
                subject.setCollegeId(collegeId);
                subject.setCollegeName(collegeName);
                subject.setCode(json.get("code").toString());
                dao.addSubject(subject);
            }
        }
        return true;
    }

    public boolean addSubjects(String path) throws Exception {
        JSONArray jsonArray = GetJSONDataService.getJSONArrayService(path);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json = jsonArray.getJSONObject(i);
                Subject subject = new Subject();
                subject.setPcode(json.get("fcode").toString().trim());
                subject.setName(json.get("name").toString().trim());
                subject.setCode(json.get("code").toString().trim());
                dao.addSubject(subject);
            }
        return true;
    }
    public void addSubjectWithCollege( String path, Integer collegeId, String collegeName) throws Exception {
        JSONArray jsonArray = GetJSONDataService.getJSONArrayService(path);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject json = jsonArray.getJSONObject(i);
            Subject subject = new Subject();
            subject.setName(json.get("name").toString());
            subject.setPcode(json.get("fcode").toString());
            subject.setCollegeId(collegeId);
            subject.setCollegeName(collegeName);
            subject.setCode(json.get("code").toString());
            dao.addSubjectWithCollege(subject);
        }
    }
}
