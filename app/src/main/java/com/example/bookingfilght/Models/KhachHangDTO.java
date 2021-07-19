package com.example.bookingfilght.Models;

public class KhachHangDTO {

	private Long id;
	
	private String hoTen;
	
	private String cmnd;
	
	private String email;
	
	private String soDienThoai;
	
	private String taiKhoan;
	
	private String matKhau;
	
	private Boolean tinhTrang;

    public KhachHangDTO(String hoTen, String cmnd, String email, String phoneNumber, String pwd) {
    	this.hoTen = hoTen;
    	this.cmnd = cmnd;
    	this.email = email;
    	this.soDienThoai = phoneNumber;
    	this.matKhau = pwd;
    }




    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getCMND() {
		return cmnd;
	}

	public void setCMND(String cMND) {
		cmnd = cMND;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public Boolean getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(Boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
