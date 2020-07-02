
package oracle;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.Barang;


public class CrudBarang {

    private Koneksi koneksi;

    public CrudBarang() {
        this.koneksi = new Koneksi();
    }

    public int getSequenceIdBarang() throws SQLException{
        String sql = "SELECT last_number FROM user_sequences WHERE sequence_name = 'ID_BARANG'";
        ResultSet rs = this.koneksi.getData(sql);
        rs.next();
        return rs.getInt("last_number");
    }
    
    public void insert(String nama, int harga, int stok) {
        String sql = "INSERT INTO barang_06932 VALUES (id_barang.NEXTVAL, '" + nama + "', '" + harga
                + "', '" + stok + "')";
        this.koneksi.manipulasiData(sql);
    }
    
    public void update(String nama, int harga, int stok) {
        String sql = "UPDATE barang_06932 SET HARGA = '" + harga + "', STOK = '" + stok 
                + "' WHERE NAMA = '" + nama + "'";
        this.koneksi.manipulasiData(sql);
    }

    public void delete(String nama) {
        String sql = "DELETE FROM barang_06932 WHERE nama = '" + nama + "'";
        this.koneksi.manipulasiData(sql);
    }
    
    public DefaultTableModel viewTable() throws SQLException {
        DefaultTableModel dtmBarang = new DefaultTableModel();
        dtmBarang.addColumn("ID Barang");
        dtmBarang.addColumn("Nama");
        dtmBarang.addColumn("Harga");
        dtmBarang.addColumn("Stok");

        String sql = "SELECT * from barang_06932";
        ResultSet rs = this.koneksi.getData("SELECT id_barang, nama, harga, stok FROM barang_06932");
        while (rs.next()) {
            Barang barang = new Barang();
            barang.setIdBarang(rs.getInt("id_barang"));
            barang.setNama(rs.getString("nama"));
            barang.setHarga(rs.getInt("harga"));
            barang.setStok(rs.getInt("stok"));

            Object[] temp = new Object[4];
            temp[0] = barang.getIdBarang();
            temp[1] = barang.getNama();
            temp[2] = barang.getHarga();
            temp[3] = barang.getStok();
            dtmBarang.addRow(temp);
        }
        return dtmBarang;
    }
    
    public int hitungTotalHarga(int idBarang, int jumlah) throws SQLException {
        ResultSet rs = this.koneksi.getData("SELECT harga FROM barang_06932 WHERE id_barang = " + idBarang);
        rs.next();
        int hargaBarang = rs.getInt("harga");
        int hargaTotal = hargaBarang * jumlah;
        return hargaTotal;
    }
    
//    public boolean cariDataBarang(String nama) throws SQLException {
//        String sql = "SELECT * FROM barang_06932 WHERE nama = " + nama;
//        ResultSet rs = this.koneksi.getData(sql);
//        return rs.next();
//    }
}
