package exceptions;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(String userId) {
        super("User with ID '" + userId + "' not found.");
    }
}
