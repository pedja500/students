package rs.ac.ni.pmf.web.students.exceptions;

public class NoStudentWithSuchId extends RuntimeException {
    public NoStudentWithSuchId(int id) {
        super("No student with index " + id + " found");
    }
}
