/*******************************************************************************
 * Copyright (c) 2016 Kronos, Inc. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Kronos, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Kronos.
 *
 * KRONOS MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE SUITABILITY OF THE
 * SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. KRONOS SHALL NOT BE LIABLE FOR ANY DAMAGES
 * SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING OR DISTRIBUTING
 * THIS SOFTWARE OR ITS DERIVATIVES.
 *******************************************************************************/
package com.example.springboot.exception;

import org.springframework.http.HttpStatus;

/**
 * TMSException is the wrapper for TMSExceptionMapper. TMSExceptionMapper sends
 * the error response to consumer
 *
 * @author Mukesh Rustagi
 */
public class APIException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String errorCode;
	private HttpStatus httpStatusCode;
	private String status;

	public APIException() {
		super();
	}

	public APIException(String message, Throwable ex) {
		super(message, ex);
	}

	public APIException(String errorCode) {
		super();
		setErrorCode(errorCode);
	}

	/**
	 * @return Returns the errorCode.
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 *            The errorCode to set.
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public HttpStatus getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(HttpStatus httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}