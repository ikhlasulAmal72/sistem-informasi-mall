/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ikhla
 */
public class DetailDagangan {

    private Dagangan dagangan;
    private Barang barang;
    private int totalPerBarang;
    private int jumlahPerBarang;

    public Dagangan getDagangan() {
        return dagangan;
    }

    public void setDagangan(Dagangan dagangan) {
        this.dagangan = dagangan;
    }

    public Barang getBarang() {
        return barang;
    }

    public void setBarang(Barang barang) {
        this.barang = barang;
    }

    public int getTotalPerBarang() {
        return totalPerBarang;
    }

    public void setTotalPerBarang(int totalPerBarang) {
        this.totalPerBarang = totalPerBarang;
    }

    public int getJumlahPerBarang() {
        return jumlahPerBarang;
    }

    public void setJumlahPerBarang(int jumlahPerBarang) {
        this.jumlahPerBarang = jumlahPerBarang;
    }

}
