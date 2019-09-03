package com.ilonw.api.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLIntegrityConstraintViolationException;


public class JdbcUtil {
	private static final Logger logger = LoggerFactory.getLogger(JdbcUtil.class);
	private static final int MYSQL_DUPLICATE = 1062;

	public static void handleJdbcException(Exception e) {
		if (e.getCause() == null) {
			throw new RuntimeException("transaction error");
		}
		Throwable nested = e.getCause();
		if (nested instanceof SQLIntegrityConstraintViolationException) {
			SQLIntegrityConstraintViolationException constraintViolation = (SQLIntegrityConstraintViolationException) nested;
			String message = constraintViolation.getMessage();
			//String sqlState = constraintViolation.getSQLState();
			int errorCode = constraintViolation.getErrorCode();
			if (errorCode == MYSQL_DUPLICATE) {
				logger.info(" MYSQL_DUPLICATE catch message=" + message + ", catch errorcode=" + errorCode);
			} else  {
				throw new RuntimeException("transaction error");
			}
			// create validation message or whatever
		} else {
			throw new RuntimeException("transaction error");
		}
	}
}

