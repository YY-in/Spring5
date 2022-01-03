package collectiontype;

/**
 * @Author: YinZhihao
 * @Description:
 * @Date: Created in 23:21 2022/1/3
 */
public class Course {
    private String cname;//课程名称

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                '}';
    }
}
