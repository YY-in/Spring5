package collectiontype;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: YinZhihao
 * @Description:
 * @Date: Created in 22:33 2022/1/3
 */
public class Stu {
    //1.数组类型属性
    private String[] courses;
    //2.list集合类型属性
    private List<String> list;
    //3.Map集合类型属性
    private Map<String,String> maps;
    //4.set集合类型属性
    private Set<String> sets;

    //学生所学的多门课程
    private List<Course> courseList;

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void test(){
        System.out.println(Arrays.toString(courses));
        System.out.println(list);
        System.out.println(maps);
        System.out.println(sets);
        System.out.println(courseList);
    }
}
