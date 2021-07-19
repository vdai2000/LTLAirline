package com.example.bookingfilght.Models;

public class MayBayDTO {
	
	private Long id;
	private String tenMayBay;
	private String hangMayBay;
	private Integer soGheHang1;
	private Integer soGheHang2;
	private Boolean tinhTrang;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTenMayBay() {
		return tenMayBay;
	}

	public void setTenMayBay(String tenMayBay) {
		this.tenMayBay = tenMayBay;
	}

	public Integer getSoGheHang1() {
		return soGheHang1;
	}

	public void setSoGheHang1(Integer soGheHang1) {
		this.soGheHang1 = soGheHang1;
	}

	public Integer getSoGheHang2() {
		return soGheHang2;
	}

	public void setSoGheHang2(Integer soGheHang2) {
		this.soGheHang2 = soGheHang2;
	}

	public Boolean getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getHangMayBay() {
		return hangMayBay;
	}

	public void setHangMayBay(String hangMayBay) {
		this.hangMayBay = hangMayBay;
	}
}
