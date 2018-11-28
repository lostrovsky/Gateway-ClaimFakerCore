package com.ust.claimfaker.core.util;

public class fakes {

	public String fieldName = null;
	public String fieldType = null;
	public String fieldOrig = null;
	public String fieldFake = null;
	
	public fakes(String fieldName, String fieldType, String fieldOrig, String fieldFake)
	{
		
		this.fieldName = fieldName;
		this.fieldType = fieldType;
		this.fieldOrig = fieldOrig;
		this.fieldFake = fieldFake;
			
	   
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getFieldOrig() {
		return fieldOrig;
	}

	public void setFieldOrig(String fieldOrig) {
		this.fieldOrig = fieldOrig;
	}

	public String getFieldFake() {
		return fieldFake;
	}

	public void setFieldFake(String fieldFake) {
		this.fieldFake = fieldFake;
	}
}



    
    