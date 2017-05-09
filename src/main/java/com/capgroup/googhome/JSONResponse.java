package com.capgroup.googhome;

public class JSONResponse {
	  private String status = "";
	  private String errorMessage = "";
	 
    public JSONResponse(String status, String errorMessage) {
	    this.status = status;
	    this.errorMessage = errorMessage;
	  }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	  
	  
}
