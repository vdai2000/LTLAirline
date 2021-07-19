package com.example.bookingfilght.Models;

public class HangVeDTO {
	
	private Long id;  
	private String code;
	private String tenHangVe;
	private Boolean tinhTrang;
	
	
	public String getTenHangVe() {
		return tenHangVe;
	}

	public void setTenHangVe(String tenHangVe) {
		this.tenHangVe = tenHangVe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}


	public Boolean getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	
	
	
}
