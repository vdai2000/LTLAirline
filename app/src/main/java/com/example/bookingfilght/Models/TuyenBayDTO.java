package com.example.bookingfilght.Models;

public class TuyenBayDTO {

	private Long id;
	private Long sanBayDiID;
	private Long sanBayDenID;
	private Boolean tinhTrang;
	
	private String tenSanBayDi;
	private String thanhPhoDi;
	
	private String thanhPhoDen;
	private String tenSanBayDen;
	
	
	public Long getId() {
		return id;
	}

	public Boolean getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public Long getSanBayDiID() {
		return sanBayDiID;
	}

	public void setSanBayDiID(Long sanBayDiID) {
		this.sanBayDiID = sanBayDiID;
	}

	public Long getSanBayDenID() {
		return sanBayDenID;
	}

	public void setSanBayDenID(Long sanBayDenID) {
		this.sanBayDenID = sanBayDenID;
	}

	public String getTenSanBayDen() {
		return tenSanBayDen;
	}

	public void setTenSanBayDen(String tenSanBayDen) {
		this.tenSanBayDen = tenSanBayDen;
	}

	public String getTenSanBayDi() {
		return tenSanBayDi;
	}

	public void setTenSanBayDi(String tenSanBayDi) {
		this.tenSanBayDi = tenSanBayDi;
	}

	public String getThanhPhoDi() {
		return thanhPhoDi;
	}

	public void setThanhPhoDi(String thanhPhoDi) {
		this.thanhPhoDi = thanhPhoDi;
	}

	public String getThanhPhoDen() {
		return thanhPhoDen;
	}

	public void setThanhPhoDen(String thanhPhoDen) {
		this.thanhPhoDen = thanhPhoDen;
	}	
}
