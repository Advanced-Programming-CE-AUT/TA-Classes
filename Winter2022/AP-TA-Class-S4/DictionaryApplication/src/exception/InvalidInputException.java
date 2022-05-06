package exception;

public class InvalidInputException extends Exception {
    @Override
    public String getMessage() {
        return "Invalid Input!";
    }
}
