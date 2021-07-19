package com.example.bookingfilght.Models;

public class SanBayDTO {
	
	private Long id;
	private String code;
	private String tenThanhPho;
	private String tenSanBay;
	private String quocGia;
	private Boolean tinhTrang;

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

	public String getTenThanhPho() {
		return tenThanhPho;
	}

	public void setTenThanhPho(String tenThanhPho) {
		this.tenThanhPho = tenThanhPho;
	}

	public String getTenSanBay() {
		return tenSanBay;
	}

	public void setTenSanBay(String tenSanBay) {
		this.tenSanBay = tenSanBay;
	}

	public String getQuocGia() {
		return quocGia;
	}

	public void setQuocGia(String quocGia) {
		this.quocGia = quocGia;
	}

	public Boolean getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
}
