package com.example.bookingfilght.Models;

public class DataOuputHistory {
    String ngayBay;
    String giaVe;
    String loTrinh;
    String hangHangKhong;
    Integer imageHangVe;
    Long idPhieuDatVe;

    public DataOuputHistory(String ngayBay, String giaVe, String loTrinh, String hangHangKhong, Integer imageHangVe, Long idPhieuDatVe) {
        this.ngayBay = ngayBay;
        this.giaVe = giaVe;
        this.loTrinh = loTrinh;
        this.hangHangKhong = hangHangKhong;
        this.imageHangVe = imageHangVe;
        this.idPhieuDatVe = idPhieuDatVe;
    }

    public Integer getImageHangVe() {
        return imageHangVe;
    }

    public void setImageHangVe(Integer imageHangVe) {
        this.imageHangVe = imageHangVe;
    }

    public String getNgayBay() {
        return ngayBay;
    }

    public void setNgayBay(String ngayBay) {
        this.ngayBay = ngayBay;
    }

    public String getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(String giaVe) {
        this.giaVe = giaVe;
    }

    public String getLoTrinh() {
        return loTrinh;
    }

    public void setLoTrinh(String loTrinh) {
        this.loTrinh = loTrinh;
    }

    public String getHangHangKhong() {
        return hangHangKhong;
    }

    public void setHangHangKhong(String hangHangKhong) {
        this.hangHangKhong = hangHangKhong;
    }

    public Long getIdPhieuDatVe() {
        return idPhieuDatVe;
    }

    public void setIdPhieuDatVe(Long idPhieuDatVe) {
        this.idPhieuDatVe = idPhieuDatVe;
    }
}
