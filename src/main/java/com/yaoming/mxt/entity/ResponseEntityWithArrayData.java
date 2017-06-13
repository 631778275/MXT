package com.yaoming.mxt.entity;


public class ResponseEntityWithArrayData extends ResponseEntity {
	
	private Iterable<?> data;

	public Iterable<?> getData() {
		return data;
	}
	public void setData(Iterable<?> data) {
		this.data = data;
	}

}
