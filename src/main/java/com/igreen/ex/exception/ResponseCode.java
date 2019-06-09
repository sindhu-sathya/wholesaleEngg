/**
 * @author Sindhu
 * Date: 9-June-2019
 */
package com.igreen.ex.exception;

/**
 * The ResponseCode for all request and responses
 */
public enum ResponseCode {

	SUCCESS(200,"Success"),
	GENERIC(1000, "Service Unavailable. Please try after sometime."),
	ACCESS_DENIED(1001, "Access Denied"),
	BAD_REQUEST(400,"Bad Request");

	/** The code. */
	private final int code;

	/** The message. */
	private final String message;

	/**
	 * Instantiates a new response code.
	 *
	 * @param code the code
	 * @param message the message
	 */
	private ResponseCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

}
