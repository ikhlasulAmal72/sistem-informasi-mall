/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.Karyawan;

/**
 *
 * @author ikhla
 */
public class CrudKaryawan {

    private Koneksi koneksi;

    public CrudKaryawan() {
        this.koneksi = new Koneksi();
    }

    public int getSequenceIdKaryawan() throws SQLException {
        String sql = "SELECT last_number FROM user_sequences WHERE sequence_name = 'ID_KARYAWAN'";
        ResultSet rs = this.koneksi.getData(sql);
        rs.next();
        return rs.getInt("last_number");
    }

    public void insert(String namaKaryawan, String alamat, int noTelp, int gaji) {
        String sql = "INSERT INTO karyawan_06932 VALUES (id_karyawan.NEXTVAL, '" + namaKaryawan + "', '" + alamat
                + "', '" + noTelp + "', '" + gaji + "')";
        this.koneksi.manipulasiData(sql);
    }

    public DefaultTableModel viewTable() throws SQLException {
        DefaultTableModel dtmkaryawan = new DefaultTableModel();
        dtmkaryawan.addColumn("ID Karyawan");
        dtmkaryawan.addColumn("Nama Karyawan");
        dtmkaryawan.addColumn("Alamat");
        dtmkaryawan.addColumn("No Telp");
        dtmkaryawan.addColumn("Gaji");

        String sql = "SELECT * FROM karyawan_06932";
        ResultSet rs = this.koneksi.getData(sql);
        while (rs.next()) {
            Karyawan karyawan = new Karyawan();
            karyawan.setIdKaryawan(rs.getInt("id_karyawan"));
            karyawan.setNamaKaryawan(rs.getString("nama_karyawan"));
            karyawan.setAlamat(rs.getString("alamat"));
            karyawan.setNoTlp(rs.getInt("no_tlp"));
            karyawan.setGaji(rs.getInt("gaji"));

            Object[] temp = new Object[5];
            temp[0] = karyawan.getIdKaryawan();
            temp[1] = karyawan.getNamaKaryawan();
            temp[2] = karyawan.getAlamat();
            temp[3] = karyawan.getNoTlp();
            temp[4] = karyawan.getGaji();
            dtmkaryawan.addRow(temp);
        }
        return dtmkaryawan;
    }

}
