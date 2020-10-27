package com.exception;

public class UserExistsException extends Exception{
	String errormsg;
	
	public UserExistsException(String exceptionMsg) {
	      this.errormsg = exceptionMsg;
	   }
	   public String getUserException(){
	      return this.errormsg;
	   }
}
