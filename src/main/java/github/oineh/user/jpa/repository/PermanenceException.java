package github.oineh.user.jpa.repository;

public class PermanenceException extends RuntimeException {
    public PermanenceException(String message) {
        super(message);
    }

    public PermanenceException() {
    }
}
