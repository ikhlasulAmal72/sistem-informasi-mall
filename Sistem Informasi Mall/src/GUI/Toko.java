package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.AllObject;

public class Toko {

    public Toko() {

        JFrame frame_toko = new JFrame();
        frame_toko.setTitle("Toko");
        frame_toko.setSize(400, 300);
        frame_toko.setLocationRelativeTo(null);
        frame_toko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_toko.setLayout(null);

        JLabel label = new JLabel("TOKO");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBounds(155, 10, 200, 40);
        frame_toko.add(label);

        JButton button_karyawan = new JButton("KARYAWAN");
        button_karyawan.setFont(new Font("Arial", Font.BOLD, 12));
        button_karyawan.setBounds(10, 120, 170, 50);
        button_karyawan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Karyawan m = new Karyawan();
                    frame_toko.dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(Toko.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        frame_toko.add(button_karyawan);

        JButton button_dagangan = new JButton("DAGANGAN");
        button_dagangan.setFont(new Font("Arial", Font.BOLD, 12));
        button_dagangan.setBounds(180, 120, 170, 50);
        button_dagangan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Dagangan m = new Dagangan();
                } catch (SQLException ex) {
                    Logger.getLogger(Toko.class.getName()).log(Level.SEVERE, null, ex);
                }
                frame_toko.dispose();
            }
        });
        frame_toko.add(button_dagangan);

        JButton button_barang = new JButton("BARANG");
        button_barang.setFont(new Font("Arial", Font.BOLD, 12));
        button_barang.setBounds(90, 70, 170, 50);
        button_barang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Barang m = new Barang();
                    frame_toko.dispose();
                } catch (SQLException ex) {
                    Logger.getLogger(Toko.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        frame_toko.add(button_barang);

        JButton button_keluar = new JButton("KELUAR");
        button_keluar.setFont(new Font("Arial", Font.BOLD, 12));
        button_keluar.setBounds(140, 210, 100, 30);
        button_keluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                frame_toko.dispose();
            }
        });
        frame_toko.add(button_keluar);

        frame_toko.setVisible(true);
    }
}
