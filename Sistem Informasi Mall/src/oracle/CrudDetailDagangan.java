
package oracle;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class CrudDetailDagangan {
    private Koneksi koneksi;

    public CrudDetailDagangan() {
        this.koneksi = new Koneksi();
    }

//    public void insertDetailPembelian(int idPesanan, int idMenu) {
//        String sql = "INSERT INTO detail_dagangan_06932 (id_dagangan, id_barang)  VALUES (" + idPesanan + ", " + idMenu + ")";
//        this.koneksi.manipulasiData(sql);
//    }

//    public DefaultTableModel viewtabel() throws SQLException {
//        DefaultTableModel modeltransaksi = new DefaultTableModel();
//        modeltransaksi.addColumn("ID PESANAN");
//        modeltransaksi.addColumn("MENU");
//        modeltransaksi.addColumn("QUANTITY SATUAN");
//        modeltransaksi.addColumn("TOTAL SATUAN");
//        modeltransaksi.addColumn("QUANTITY TOTAL");
//        modeltransaksi.addColumn("GRAND TOTAL HARGA");
//
//        String sql = "select a.id_pesanan, c.nama_menu, a.quantity, a.total, a.quantityperbarang, a.totalperbarang "
//                + "from detailpembelian_06977 a "
//                + "join pesanan_06977 b on a.id_pesanan = b.id_pesanan "
//                + "join menu_06977 c on a.id_menu = c.id_menu "
//                + "ORDER BY id_pesanan ASC";
//
//        ResultSet rs = this.koneksi.GetData(sql);
//        while (rs.next()) {
//            Pesanan pesanan = new Pesanan();
//            Menu menu = new Menu();
//            pesanan.setId_pesanan(rs.getInt("id_pesanan"));
//            menu.setNama_menu(rs.getString("nama_menu"));
//            pesanan.setQuantityperbarang(rs.getInt("quantityperbarang"));
//            pesanan.setTotalperbarang(rs.getInt("totalperbarang"));
//            pesanan.setQuantity(rs.getInt("quantity"));
//            pesanan.setTotal(rs.getInt("total"));
//
//            Object[] var = new Object[6];
//            var[0] = pesanan.getId_pesanan();
//            var[1] = menu.getNama_menu();
//            var[2] = pesanan.getQuantityperbarang();
//            var[3] = pesanan.getTotalperbarang();
//            var[4] = pesanan.getQuantity();
//            var[5] = pesanan.getTotal();
//            modeltransaksi.addRow(var);
//        }
//        return modeltransaksi;
//    }

//    public void UpdateDetailpembelian(Integer idPem) throws SQLException {
//        String sql = "UPDATE detailpembelian_06977 set id_pesanan = null WHERE id_pesanan ='" + idPem + "'";
//        this.koneksi.ManipulasiData(sql);
//    }
//
//    public void DeleteDetailpembelian(Integer idPem) throws SQLException {
//        String sql = "DELETE from detailpembelian_06977 WHERE id_pesanan ='" + idPem + "'";
//        this.koneksi.ManipulasiData(sql);
//    }
    
    public void UpdatePesanan(int idDagangan, int idBarang, int jumlah, int total) {
        String sql = "insert into detail_dagangan_06932 (id_dagangan, id_barang, jumlah, total) values ('" + idDagangan + "', '" + idBarang + "', '" + jumlah + "', '" + total + "')";
        this.koneksi.manipulasiData(sql);
    }

//    public int AmbilID(String Id) throws SQLException {
//        String sql = "select total from detailpembelian_06977 WHERE id_pesanan = '" + Id + "'";
//        ResultSet rs = this.koneksi.GetData(sql);
//        rs.next();
//        return rs.getInt("total");
//    }
}
