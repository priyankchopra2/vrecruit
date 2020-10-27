package com.exception;

public class UserLoginException extends Exception{
	String errormsg;
	
	public UserLoginException(String exceptionMsg) {
	      this.errormsg = exceptionMsg;
	   }
	   public String getUserException(){
	      return this.errormsg+" is invalid user or password mismatched!!";
	   }
	 
}
