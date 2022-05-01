import java.util.ArrayList;
import java.util.Iterator;

public class Portal {

    private ArrayList<Student> students;
    private ArrayList<Course> courses;
    private ArrayList<Professor> professors;

    public Portal(){
        students = new ArrayList<>();
        courses = new ArrayList<>();
        professors = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> studentsTemp = new ArrayList<>(students);
        return studentsTemp;
    }

    public ArrayList<Course> getCourses() {
        ArrayList<Course> coursesTemp = new ArrayList<>(courses);
        return coursesTemp;
    }

    public ArrayList<Professor> getProfessors() {
        ArrayList<Professor> professorsTemp = new ArrayList<>(professors);
        return professorsTemp;
    }


    public void registerStudent(Student student){
        students.add(student);
    }
    public void createCourse(Course course){
        courses.add(course);

    }
    public void registerProfessor(Professor professor){
        professors.add(professor);
    }

    public void addStudentToCourse(Student student , Course course){
        if (course != null && student != null) {
            course.addStudent(student);
            student.addCourse(course);
        }
    }

    public Professor getProfessorByID(String id){
        Iterator<Professor> professorsIterator = professors.iterator();
        while (professorsIterator.hasNext()){
            Professor current = professorsIterator.next();
            if (current.getId().equals(id)) {
                return current;
            }
        }
        return null;
    }
    public Student getStudentByID(String id){
        Iterator<Student> studentsIterator = students.iterator();
        while (studentsIterator.hasNext()){
            Student current = studentsIterator.next();
            if (current.getId().equals(id)) {
                return current;
            }
        }
        return null;
    }
    public Course getCourseByCodeAndGroup(String code,int group){
        Iterator<Course> coursesIterator = courses.iterator();
        while (coursesIterator.hasNext()){
            Course current = coursesIterator.next();
            if (current.getCode().equals(code) && group == current.getGroup()){
                return current;
            }
        }
        return null;
    }

    public void printCoursesDetails(){
        System.out.println("*\nCourses : ");
        for (Course course : courses) {
            System.out.println(course);
        }
        System.out.println("*");
    }
    public void printStudentsDetails(){
        System.out.println("*\nStudents : ");
        for (Student student : students){
            System.out.println(student);
        }
        System.out.println("*");
    }
    public void printProfessorsDetail(){
        System.out.println("*\nProfessors : ");
        for (Professor professor : professors){
            System.out.println(professor);
        }
        System.out.println("*");
    }
}
