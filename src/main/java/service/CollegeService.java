package service;

import dao.CollegeDao;
import entity.College;

import java.util.List;

/**
 * @author :younghao
 * @ClassName: CollegeService
 * @Description: TODO
 * @date : 11/24/19  7:53 PM
 */
public class CollegeService {
    CollegeDao dao = new CollegeDao();

    public List<College> getColleges() {
        return dao.getCollegeList();
    }
}
