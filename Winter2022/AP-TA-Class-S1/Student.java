import java.util.ArrayList;
import java.util.Objects;

public class Student {

    private String name;
    private String id;
    private ArrayList<Course> courses;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.courses = new ArrayList<>();
    }

    public ArrayList<Course> getCourses(){
        ArrayList<Course> coursesTemp = new ArrayList<>(courses);
        return coursesTemp;

//        ArrayList<String> coursesTemp = new ArrayList<>();
//        coursesTemp.addAll(courses);
//        return coursesTemp;
// --------------------------------------------------------------
//        ArrayList<String> coursesTemp = new ArrayList<>();
//        for (String course : courses) coursesTemp.add(course);
//        return coursesTemp;

    }

    public void addCourse(Course course){
        courses.add(course);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return name.equals(student.name) && id.equals(student.id) && getCourses().equals(student.getCourses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, getCourses());
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    private String coursesList(){
        StringBuilder string = new StringBuilder();
        for (Course course : courses){
            string.append(course.getName() + "|code: " + course.getCode() + "|group: " + course.getGroup());
        }
        return string.toString();
    }
    @Override
    public String toString() {
        return
                "name: " + name +
                "\nid=" + id +
                "\nCourses: " + coursesList();
    }
}
