package com.example.bookingfilght.Models;

import java.io.Serializable;
import java.util.Date;

public class ChuyenBayDTO implements Serializable {


	private Long id;
	private Long tuyenBayId;
	private Long mayBayId;
	private Integer ghePhoThong;

	private Integer gheThuongGia;

	private String ngay;
	private String gio;

	private Float thoiGianBay;


	private Long sanBayDiID;
	private Long sanBayDenID;
	private String ngayDi;
	private String ngayVe;
	private String hangVe;
	private String loaiVe;
	private String codeSanDi;
	private String codeSanDen;



	private Double thanhTien;
	private String donGia;
	private Long idVe;
	private String tenSanBayDi;
	private String tenSanBayDen;

	public Double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(Double thanhTien) {
		this.thanhTien = thanhTien;
	}

	public ChuyenBayDTO() {
	}

	public Long getId() {
		return id;
	}

	public Long getTuyenBayId() {
		return tuyenBayId;
	}

	public void setTuyenBayId(Long tuyenBayId) {
		this.tuyenBayId = tuyenBayId;
	}

	public Long getMayBayId() {
		return mayBayId;
	}

	public void setMayBayId(Long mayBayId) {
		this.mayBayId = mayBayId;
	}

	public Integer getGhePhoThong() {
		return ghePhoThong;
	}

	public void setGhePhoThong(Integer ghePhoThong) {
		this.ghePhoThong = ghePhoThong;
	}

	public Integer getGheThuongGia() {
		return gheThuongGia;
	}

	public void setGheThuongGia(Integer gheThuongGia) {
		this.gheThuongGia = gheThuongGia;
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

	public String getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(String ngayDi) {
		this.ngayDi = ngayDi;
	}

	public String getNgayVe() {
		return ngayVe;
	}

	public void setNgayVe(String ngayVe) {
		this.ngayVe = ngayVe;
	}

	public String getLoaiVe() {
		return loaiVe;
	}

	public void setLoaiVe(String loaiVe) {
		this.loaiVe = loaiVe;
	}

	public Long getIdVe() {
		return idVe;
	}

	public void setIdVe(Long idVe) {
		this.idVe = idVe;
	}

	public String getTenSanBayDi() {
		return tenSanBayDi;
	}

	public void setTenSanBayDi(String tenSanBayDi) {
		this.tenSanBayDi = tenSanBayDi;
	}

	public String getTenSanBayDen() {
		return tenSanBayDen;
	}

	public void setTenSanBayDen(String tenSanBayDen) {
		this.tenSanBayDen = tenSanBayDen;
	}


	public ChuyenBayDTO(String ngay, String gio, Float thoiGianBay, String hangVe, String codeSanDi, String codeSanDen, String donGia, Integer image) {

		this.ngay = ngay;
		this.gio = gio;
		this.thoiGianBay = thoiGianBay;
		this.hangVe = hangVe;
		this.codeSanDi = codeSanDi;
		this.codeSanDen = codeSanDen;
		this.donGia = donGia;
		this.image = image;
	}

	public Integer getImage() {
		return image;
	}

	public void setImage(Integer image) {
		this.image = image;
	}

	private Integer image;

	public Float getThoiGianBay() {
		return thoiGianBay;
	}

	public void setThoiGianBay(Float thoiGianBay) {
		this.thoiGianBay = thoiGianBay;
	}


	public String getCodeSanDi() {
		return codeSanDi;
	}

	public void setCodeSanDi(String codeSanDi) {
		this.codeSanDi = codeSanDi;
	}

	public String getCodeSanDen() {
		return codeSanDen;
	}

	public void setCodeSanDen(String codeSanDen) {
		this.codeSanDen = codeSanDen;
	}

	public String getHangVe() {
		return hangVe;
	}

	public void setHangVe(String hangVe) {
		hangVe = hangVe;
	}

	

	public String getNgay() {
		return ngay;
	}

	public void setNgay(String ngay) {
		this.ngay = ngay;
	}

	public String getGio() {
		return gio;
	}

	public void setGio(String gio) {
		this.gio = gio;
	}

	public String getDonGia() {
		return donGia;
	}

	public void setDonGia(String donGia) {
		this.donGia = donGia;
	}

}
