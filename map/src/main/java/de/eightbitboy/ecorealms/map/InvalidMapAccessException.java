package de.eightbitboy.ecorealms.map;

/**
 * RuntimeException class which is used for managing map logic mistakes.
 */
class InvalidMapAccessException extends RuntimeException {
	InvalidMapAccessException(String message) {
		super(message);
	}
}
