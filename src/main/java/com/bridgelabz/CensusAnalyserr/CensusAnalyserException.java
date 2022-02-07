package com.bridgelabz.CensusAnalyserr;

public class CensusAnalyserException extends Exception{

	enum ExceptionType{
		CENSUS_FILE_PROBLEM,
		INCORRECT_FILE_DATA;
	}
	
	ExceptionType type;
	
	public String message;
	
	public CensusAnalyserException(String message,ExceptionType type) {
		this.message = message;
		this.type = type;
	}
	
	public CensusAnalyserException(String message, ExceptionType type, Throwable cause) {
		super(message, cause);
		this.type = type;
	}
}
