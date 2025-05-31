package exceptions;

public class InvalidInputException extends Exception {

    public InvalidInputException(String inputField) {
        super("Invalid input provided for: " + inputField);
    }
}
