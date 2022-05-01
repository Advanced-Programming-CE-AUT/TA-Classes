
public class Main {

    public static void main(String[] args) {
        Portal portal = new Portal();

        portal.registerStudent(new Student("Alireza Zare","9931022"));
        portal.registerStudent(new Student("Ashkan Shakiba","9931030"));
        portal.registerProfessor(new Professor("Dr. Zeynali","1"));
        portal.createCourse(new Course("AP",portal.getProfessorByID("1"),"3101043",1));
        portal.addStudentToCourse(portal.getStudentByID("9931022"), portal.getCourseByCodeAndGroup("3101043",1));
        portal.addStudentToCourse(portal.getStudentByID("9931030"), portal.getCourseByCodeAndGroup("3101043",1));
        portal.printCoursesDetails();
        portal.printStudentsDetails();
        portal.printProfessorsDetail();

    }
}
