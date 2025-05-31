package exceptions;

public class JobAssignmentException extends Exception {

    public JobAssignmentException(String message) {
        super("Job Assignment Error: " + message);
    }
}
