import java.util.ArrayList;
import java.util.Objects;

public class Course {

    private String name;
    private Professor professor;
    private String code;
    private int group;
    private ArrayList<Student> students;

    public Course(String name, Professor professor, String code, int group) {
        this.name = name;
        this.professor = professor;
        professor.addCourse(this);
        this.code = code;
        this.group = group;
        this.students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents(){
        ArrayList<Student> studentsTemp = new ArrayList<>(students);
        return studentsTemp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return group == course.group && name.equals(course.name) && professor.equals(course.professor) && code.equals(course.code) && getStudents().equals(course.getStudents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, professor, code, group, getStudents());
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public String getName() {
        return name;
    }

    public Professor getProfessor() {
        return professor;
    }

    public String getCode() {
        return code;
    }

    public int getGroup() {
        return group;
    }

    private String studentsList(){
        StringBuilder string = new StringBuilder();
        for (Student student : students){
            string.append(student.getName() + "|" + student.getId() + ", ");
        }
        return string.toString();
    }
    private String professorDetails(){
        return
                professor.getName() + "|" + professor.getId();
    }
    @Override
    public String toString() {
        return
                "name: " + name +
                "\nprofessor: " + professorDetails() +
                "\ncode: " + code +
                "\ngroup: " + group +
                "\nStudents { "+ studentsList()+" }";

    }
}
