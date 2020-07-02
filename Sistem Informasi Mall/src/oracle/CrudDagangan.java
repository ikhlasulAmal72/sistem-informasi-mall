/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import model.Barang;
import model.Dagangan;
import model.DetailDagangan;
import model.Karyawan;

/**
 *
 * @author ikhla
 */
public class CrudDagangan {

    private Koneksi koneksi;

    public CrudDagangan() {
        this.koneksi = new Koneksi();
    }

    public int getSequenceIdDagangan() throws SQLException {
        String sql = "SELECT last_number FROM user_sequences WHERE sequence_name = 'ID_DAGANGAN'";
        ResultSet rs = this.koneksi.getData(sql);
        rs.next();
        return rs.getInt("last_number");
    }

    public void insert(int idKaryawan, String tanggalDagangan) {
        String sql = "INSERT INTO dagangan_06932 (id_dagangan, id_karyawan, tanggal_dagangan) VALUES "
                + "(id_dagangan.NEXTVAL, '" + idKaryawan + "', "
                + "TO_DATE('" + tanggalDagangan + "', 'dd/mm/yyyy'))";
        this.koneksi.manipulasiData(sql);
    }

    public DefaultTableModel viewTable() throws SQLException {
        DefaultTableModel dtmDagangan = new DefaultTableModel();
        dtmDagangan.addColumn("ID Dagangan");
        dtmDagangan.addColumn("ID Barang");
        dtmDagangan.addColumn("Tanggal Dagangan");
        dtmDagangan.addColumn("Jumlah Per Barang");
        dtmDagangan.addColumn("Total Per Barang");
        dtmDagangan.addColumn("Jumlah Seluruh");
        dtmDagangan.addColumn("Total Seluruh");

        String sql = "SELECT a.id_dagangan, a.id_barang, a.jumlah, a.total, "
                + "b.tanggal_dagangan, b.jumlah_seluruh, b.total_seluruh "
                + "FROM detail_dagangan_06932 a "
                + "JOIN dagangan_06932 b ON a.id_dagangan = b.id_dagangan "
                + "ORDER BY id_dagangan ASC";
        ResultSet rs = this.koneksi.getData(sql);
        while (rs.next()) {
            Barang barang = new Barang();
            barang.setIdBarang(rs.getInt("id_barang"));

            Dagangan dagangan = new Dagangan();
            dagangan.setIdDagangan(rs.getInt("id_dagangan"));
            dagangan.setBarang(barang);
            dagangan.setTanggalDagangan(rs.getDate("tanggal_dagangan"));
            dagangan.setJumlahSeluruh(rs.getInt("jumlah_seluruh"));
            dagangan.setTotalSeluruh(rs.getInt("total_seluruh"));
            
            DetailDagangan detailDagangan = new DetailDagangan();
            detailDagangan.setBarang(barang);
            detailDagangan.setDagangan(dagangan);
            detailDagangan.setJumlahPerBarang(rs.getInt("jumlah"));
            detailDagangan.setTotalPerBarang(rs.getInt("total"));

            Object[] temp = new Object[7];
            temp[0] = detailDagangan.getDagangan().getIdDagangan();
            temp[1] = detailDagangan.getBarang().getIdBarang();
            String tanggalDaganganTerformat = new SimpleDateFormat("dd/MM/yyyy").format(detailDagangan.getDagangan().getTanggalDagangan());
            temp[2] = tanggalDaganganTerformat;
            temp[3] = detailDagangan.getJumlahPerBarang();
            temp[4] = detailDagangan.getTotalPerBarang();
            temp[5] = dagangan.getJumlahSeluruh();
            temp[6] = dagangan.getTotalSeluruh();
            dtmDagangan.addRow(temp);
        }
        return dtmDagangan;
    }
}
