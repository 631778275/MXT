package com.yaoming.mxt.entity;

import com.yaoming.mxt.entity.U2OEntity;

public class ResponseEntity extends U2OEntity{
	
	private Integer code;
	private String msg;
	
	public ResponseEntity() {
		super();
	}

	public ResponseEntity(String msg) {
		super();
		this.msg = msg;
	}

	public ResponseEntity(Integer code) {
		super();
		this.code = code;
	}
	
	public ResponseEntity(Integer code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	} 
}
