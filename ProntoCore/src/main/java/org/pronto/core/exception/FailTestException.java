/**
 * 
 */
package org.pronto.core.exception;

/**
 * @author abukhvostov
 * 
 */
public class FailTestException extends Exception {
	private static final long serialVersionUID = 1L;

	private String sMessageText;

	public FailTestException(String sMessage) {
		this.sMessageText = sMessage;
	}

	public String toString() {
		System.out.println(sMessageText);
		return "Test produce: " + sMessageText;
	}
}
