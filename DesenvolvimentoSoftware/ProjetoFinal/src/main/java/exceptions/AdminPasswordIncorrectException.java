package exceptions;

public class AdminPasswordIncorrectException extends RuntimeException {
  public AdminPasswordIncorrectException(String message) {
    super(message);
  }
}
