
package model;

import oracle.Koneksi;


public class DataPerhitunganSementara {
    private Koneksi koneksi;
    private Integer index = 0;
    private PerhitunganSementara[] hitungsementara = new PerhitunganSementara[100];

    public DataPerhitunganSementara() {
        this.koneksi = new Koneksi();
    }

    public void TampungData(int jumlah, int total) {
        this.hitungsementara[index] = new PerhitunganSementara(jumlah, total);
        index++;

    }

    public int[] Perhitungan() {
        int hasilperhitungan[] = new int[2];
        for (int i = 0; i < index; i++) {
            hasilperhitungan[0] += this.hitungsementara[i].jumlah;
            hasilperhitungan[1] += this.hitungsementara[i].total;
        }
        return hasilperhitungan;
    }

    public void aksesPerhitungan(int idDagangan) {
        int[] hasilperhitungan = Perhitungan();
        int jumlahSeluruh = hasilperhitungan[0];
        int totalSeluruh = hasilperhitungan[1];
        String sql = "UPDATE dagangan_06932 set jumlah_seluruh = '" + jumlahSeluruh + "' WHERE id_dagangan ='" + idDagangan + "'";
        this.koneksi.manipulasiData(sql);
        String sql1 = "UPDATE dagangan_06932 set total_seluruh = '" + totalSeluruh + "' WHERE id_dagangan ='" + idDagangan + "'";
        this.koneksi.manipulasiData(sql1);
    }

    public void Null() {
        index = 0;
    }
}
