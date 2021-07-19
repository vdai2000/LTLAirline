package com.example.bookingfilght.Models;

public class VeChuyenBayDTO {

	private Long id;
	private Long hangVeID;
	private Long chuyenBayID;
	private Double donGia;
	private Boolean tinhTrang;
	
	private String codeHangVe;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getDonGia() {
		return donGia;
	}

	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}

	public Boolean getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public Long getHangVeID() {
		return hangVeID;
	}

	public void setHangVeID(Long hangVeID) {
		this.hangVeID = hangVeID;
	}

	public Long getChuyenBayID() {
		return chuyenBayID;
	}

	public void setChuyenBayID(Long chuyenBayID) {
		this.chuyenBayID = chuyenBayID;
	}

	public String getCodeHangVe() {
		return codeHangVe;
	}

	public void setCodeHangVe(String codeHangVe) {
		this.codeHangVe = codeHangVe;
	}
}
