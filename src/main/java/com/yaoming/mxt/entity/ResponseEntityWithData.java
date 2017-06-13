package com.yaoming.mxt.entity;

import com.yaoming.mxt.entity.U2OEntity;

public class ResponseEntityWithData extends ResponseEntity {
	
	private U2OEntity data;

	public U2OEntity getData() {
		return data;
	}
	public void setData(U2OEntity data) {
		this.data = data;
	}


}
