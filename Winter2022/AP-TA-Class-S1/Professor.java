import java.util.ArrayList;

public class Professor {

    private String name;
    private String id;
    private ArrayList<Course> courses;

    public Professor(String name, String id) {
        this.name = name;
        this.id = id;
        this.courses = new ArrayList<>();
    }

    public ArrayList<Course> getCourses() {
        ArrayList<Course> coursesTemp = new ArrayList<>(courses);
        return coursesTemp;
    }


    public void addCourse(Course course){
        courses.add(course);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    private String studentsInCourseList(Course course){
        StringBuilder string = new StringBuilder();
        string.append("[");
        for (Student student : course.getStudents()){
            string.append(student.getName() + "|" + student.getId() + ", ");
        }
        string.append("]");
        return string.toString();
    }
    private String coursesList(){
        StringBuilder string = new StringBuilder();
        for (Course course : courses){
            string.append(
                              course.getName() +
                            " |code: " + course.getCode() +
                            " |group: " + course.getGroup() +
                            " Students : " + studentsInCourseList(course)
            );
        }
        return string.toString();
    }
    @Override
    public String toString() {
        return
                "name: " + name +
                "\nid: " + id +
                "\nCourses: " + coursesList();
    }
}
