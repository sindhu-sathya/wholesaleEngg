/**
 * @author Sindhu
 * Date: 9-June-2019
 */
package com.igreen.ex.exception;
/**
 * 
 * Custom Exception file.
 *
 */
public class IgreenServiceException extends RuntimeException {

	public enum Level {
		INFO, WARN, ERROR
	}

	private static final long serialVersionUID = 1L;

	private ResponseCode code;

	private String errorMessage;

	private Level level;

	public IgreenServiceException() {
		super();
	}

	public IgreenServiceException(ResponseCode code) {
		super();
		this.code = code;
	}

	public IgreenServiceException(ResponseCode code, String errorMessage) {
		super(errorMessage);
		this.code = code;
		this.errorMessage = errorMessage;
	}

	public IgreenServiceException(Level level, ResponseCode code, String errorMessage) {
		super(errorMessage);
		this.level = level;
		this.code = code;
		this.errorMessage = errorMessage;
	}

	public IgreenServiceException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public ResponseCode getCode() {
		return code;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setCode(ResponseCode code) {
		this.code = code;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
}
