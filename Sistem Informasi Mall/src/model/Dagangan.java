package model;

import java.sql.Date;

public class Dagangan {

    private int idDagangan;
    public Karyawan karyawan;
    public Barang barang;
    private Date tanggalDagangan;
    private int jumlahSeluruh;
    private int totalSeluruh;

    public int getIdDagangan() {
        return idDagangan;
    }

    public void setIdDagangan(int idDagangan) {
        this.idDagangan = idDagangan;
    }

    public Karyawan getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public Date getTanggalDagangan() {
        return tanggalDagangan;
    }

    public void setTanggalDagangan(Date tanggalDagangan) {
        this.tanggalDagangan = tanggalDagangan;
    }

    public int getJumlahSeluruh() {
        return jumlahSeluruh;
    }

    public void setJumlahSeluruh(int jumlahSeluruh) {
        this.jumlahSeluruh = jumlahSeluruh;
    }

    public int getTotalSeluruh() {
        return totalSeluruh;
    }

    public void setTotalSeluruh(int totalSeluruh) {
        this.totalSeluruh = totalSeluruh;
    }

}
