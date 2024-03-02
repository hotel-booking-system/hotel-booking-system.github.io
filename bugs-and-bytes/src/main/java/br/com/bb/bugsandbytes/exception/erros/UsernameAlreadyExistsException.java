package br.com.bb.bugsandbytes.exception.erros;

public class UsernameAlreadyExistsException extends RuntimeException {

	public UsernameAlreadyExistsException() {
	}

	public UsernameAlreadyExistsException(String message) {
		super(message);
	}

	public UsernameAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsernameAlreadyExistsException(Throwable cause) {
		super(cause);
	}
}
