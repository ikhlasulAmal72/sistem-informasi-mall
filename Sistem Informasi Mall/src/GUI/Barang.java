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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.AllObject;
import oracle.CrudBarang;

public class Barang {

    CrudBarang crudBarang;
    
    public Barang() throws SQLException {
        crudBarang = new CrudBarang();
        
        JFrame frame_barang = new JFrame();
        frame_barang.setSize(600, 600);
        frame_barang.setLocationRelativeTo(null);
        frame_barang.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_barang.setLayout(null);

        JLabel label = new JLabel("BARANG");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBounds(120, 10, 200, 40);
        frame_barang.add(label);

        JLabel label2 = new JLabel("ID Barang");
        label2.setFont(new Font("Arial", Font.PLAIN, 12));
        label2.setBounds(30, 70, 100, 30);
        frame_barang.add(label2);

        JLabel label3 = new JLabel("Nama");
        label3.setFont(new Font("Arial", Font.PLAIN, 12));
        label3.setBounds(30, 120, 100, 30);
        frame_barang.add(label3);

        JLabel label4 = new JLabel("Harga");
        label4.setFont(new Font("Arial", Font.PLAIN, 12));
        label4.setBounds(30, 170, 100, 30);
        frame_barang.add(label4);

        JLabel label5 = new JLabel("Stok");
        label5.setFont(new Font("Arial", Font.PLAIN, 12));
        label5.setBounds(30, 220, 100, 30);
        frame_barang.add(label5);

        JTextField text_id = new JTextField();
        text_id.setBounds(120, 70, 200, 30);
        text_id.setEnabled(false);
        text_id.setText(String.valueOf(this.crudBarang.getSequenceIdBarang()));
        frame_barang.add(text_id);

        JTextField text_nama = new JTextField();
        text_nama.setBounds(120, 120, 200, 30);
        frame_barang.add(text_nama);

        JTextField text_harga = new JTextField();
        text_harga.setBounds(120, 170, 200, 30);
        frame_barang.add(text_harga);

        JTextField tfStok = new JTextField();
        tfStok.setBounds(120, 220, 200, 30);
        frame_barang.add(tfStok);

        JTable tabel = new JTable();
        JScrollPane scroll_pane = new JScrollPane(tabel);
        scroll_pane.setBounds(30, 310, 500, 200);

        JButton button_insert = new JButton("Insert");
        button_insert.setFont(new Font("Arial", Font.PLAIN, 12));
        button_insert.setBounds(30, 270, 80, 20);
        frame_barang.add(button_insert);
        button_insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String nama = text_nama.getText();
                    int harga = 0;
                    int stok = 0;
                    boolean error = true;
                    try {
                        harga = Integer.parseInt(text_harga.getText());
                        stok = Integer.parseInt(tfStok.getText());
                        error = false;
                    } catch (NumberFormatException a) {
                        JOptionPane.showMessageDialog(null, "harga atau stok harus angka");
                    }
                    crudBarang.insert(nama, harga, stok);
                    tabel.setModel(crudBarang.viewTable());
                    text_id.setText(String.valueOf(crudBarang.getSequenceIdBarang()));
                } catch (SQLException ex) {
                    Logger.getLogger(Barang.class.getName()).log(Level.SEVERE,null, ex);
                }
            }
        });
        
        JButton button_update = new JButton("Update");
        button_update.setFont(new Font("Arial", Font.PLAIN, 12));
        button_update.setBounds(120, 270, 80, 20); 
        frame_barang.add(button_update);
        button_update.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e) {
                try {
                    String nama = text_nama.getText();
//                    Boolean ketemu = crudBarang.cariDataBarang(nama);
//                    if (ketemu) {
                        int harga = Integer.parseInt(text_harga.getText());
                        int stok = Integer.parseInt(tfStok.getText());
                        crudBarang.update(nama, harga, stok);
                        tabel.setModel(crudBarang.viewTable());
//                    }
//                    if (!ketemu) {
//                        JOptionPane.showMessageDialog(null, "Barang yang ingin diupdate tidak ditemukan");
//                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Barang.class.getName()).log(Level.SEVERE,null, ex);
                }
            }
                });

        JButton button_delete = new JButton("Delete");
        button_delete.setFont(new Font("Arial", Font.PLAIN, 12));
        button_delete.setBounds(210, 270, 80, 20);
        frame_barang.add(button_delete);
        button_delete.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e) {
                try {
                    String nama = text_nama.getText();
//                    boolean ketemu = crudBarang.cariDataBarang(nama);
//                    if (ketemu) {
                        crudBarang.delete(nama);
                        tabel.setModel(crudBarang.viewTable());
//                    }
//                    if (!ketemu) {
//                        JOptionPane.showMessageDialog(null, "Barang yang ingin didelete tidak ditemukan");
//                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Barang.class.getName()).log(Level.SEVERE,null, ex);
                }
            }
        });
        
        JButton button_keluar = new JButton("keluar");
        button_keluar.setFont(new Font("Arial", Font.PLAIN, 12));
        button_keluar.setBounds(300, 270, 80, 20);
        button_keluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Toko t = new Toko();
                frame_barang.dispose();
            }
        });
        frame_barang.add(button_keluar);

        tabel.setModel(crudBarang.viewTable());
        frame_barang.add(scroll_pane);

        frame_barang.setVisible(true);
    }
}
