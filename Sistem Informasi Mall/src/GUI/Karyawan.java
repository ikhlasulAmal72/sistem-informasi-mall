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
import oracle.CrudKaryawan;

public class Karyawan {

    CrudKaryawan crudKaryawan;

    public Karyawan() throws SQLException {
        this.crudKaryawan = new CrudKaryawan();

        JFrame frame_karyawan = new JFrame();
        frame_karyawan.setSize(600, 600);
        frame_karyawan.setLocationRelativeTo(null);
        frame_karyawan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_karyawan.setLayout(null);

        JLabel label = new JLabel("KARYAWAN");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBounds(120, 10, 200, 40);
        frame_karyawan.add(label);

        JLabel label2 = new JLabel("ID Karyawan");
        label2.setFont(new Font("Arial", Font.PLAIN, 12));
        label2.setBounds(30, 70, 100, 30);
        frame_karyawan.add(label2);

        JLabel label3 = new JLabel("Nama Karyawan");
        label3.setFont(new Font("Arial", Font.PLAIN, 12));
        label3.setBounds(30, 120, 100, 30);
        frame_karyawan.add(label3);

        JLabel label4 = new JLabel("Alamat");
        label4.setFont(new Font("Arial", Font.PLAIN, 12));
        label4.setBounds(30, 170, 100, 30);
        frame_karyawan.add(label4);

        JLabel label5 = new JLabel("No Telp");
        label5.setFont(new Font("Arial", Font.PLAIN, 12));
        label5.setBounds(30, 220, 100, 30);
        frame_karyawan.add(label5);

        JLabel label6 = new JLabel("Gaji");
        label6.setFont(new Font("Arial", Font.PLAIN, 12));
        label6.setBounds(30, 270, 100, 30);
        frame_karyawan.add(label6);

        JTextField text_id = new JTextField();
        text_id.setBounds(140, 70, 200, 30);
        text_id.setEnabled(false);
        text_id.setText(String.valueOf(this.crudKaryawan.getSequenceIdKaryawan()));
        frame_karyawan.add(text_id);

        JTextField text_nama = new JTextField();
        text_nama.setBounds(140, 120, 200, 30);
        frame_karyawan.add(text_nama);

        JTextField tfAlamat = new JTextField();
        tfAlamat.setBounds(140, 170, 200, 30);
        frame_karyawan.add(tfAlamat);

        JTextField tfNoTelp = new JTextField();
        tfNoTelp.setBounds(140, 220, 200, 30);
        frame_karyawan.add(tfNoTelp);

        JTextField tfGaji = new JTextField();
        tfGaji.setBounds(140, 270, 200, 30);
        frame_karyawan.add(tfGaji);

        JTable tabel = new JTable();
        JScrollPane scroll_pane = new JScrollPane(tabel);
        scroll_pane.setBounds(30, 350, 500, 150);

        JButton button_insert = new JButton("Insert");
        button_insert.setFont(new Font("Arial", Font.PLAIN, 12));
        button_insert.setBounds(30, 320, 80, 20);
        frame_karyawan.add(button_insert);
        button_insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String id = text_id.getText();
                    String namaKaryawan = text_nama.getText();
                    String alamat = tfAlamat.getText();
                    int noTelp = Integer.parseInt(tfNoTelp.getText());
                    int gaji = 0;
                    boolean error = true;
                    try {
                        gaji = Integer.parseInt(tfGaji.getText());
                        error = false;
                    } catch (NumberFormatException a) {
                        JOptionPane.showMessageDialog(null, "gaji harus angka");
                    }
                    crudKaryawan.insert(namaKaryawan, alamat, noTelp, gaji); 
                    tabel.setModel(crudKaryawan.viewTable());
                    text_id.setText(String.valueOf(crudKaryawan.getSequenceIdKaryawan()));
                } catch (SQLException ex) {
                    Logger.getLogger(Karyawan.class.getName()).log(Level.SEVERE,null, ex);
                }
            }
        });



        JButton button_keluar = new JButton("keluar");
        button_keluar.setFont(new Font("Arial", Font.PLAIN, 12));
        button_keluar.setBounds(250, 320, 80, 20);
        button_keluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Toko t = new Toko();
                frame_karyawan.dispose();
            }
        });
        frame_karyawan.add(button_keluar);

        tabel.setModel(crudKaryawan.viewTable());
        frame_karyawan.add(scroll_pane);

        frame_karyawan.setVisible(true);
    }
}
