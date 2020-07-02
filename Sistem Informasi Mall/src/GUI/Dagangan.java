package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.DataPerhitunganSementara;
import oracle.CrudBarang;
import oracle.CrudDagangan;
import oracle.CrudDetailDagangan;

public class Dagangan {

    CrudDagangan crudDagangan;
    CrudBarang crudBarang;
    CrudDetailDagangan crudDetailDagangan;
    DataPerhitunganSementara dataPerhitunganSementara;
    int click;

    public Dagangan() throws SQLException {
        this.crudDagangan = new CrudDagangan();
        this.crudDetailDagangan = new CrudDetailDagangan();
        this.crudBarang = new CrudBarang();
        this.dataPerhitunganSementara = new DataPerhitunganSementara();

        JFrame frame_dagangan = new JFrame();
        frame_dagangan.setSize(600, 600);
        frame_dagangan.setLocationRelativeTo(null);
        frame_dagangan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame_dagangan.setLayout(null);

        JLabel label = new JLabel("DAGANGAN");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setBounds(230, 10, 200, 40);
        frame_dagangan.add(label);

        JLabel label1 = new JLabel("ID Dagangan");
        label1.setFont(new Font("Arial", Font.PLAIN, 12));
        label1.setBounds(30, 70, 100, 30);
        frame_dagangan.add(label1);

        JLabel label2 = new JLabel("ID Karyawan");
        label2.setFont(new Font("Arial", Font.PLAIN, 12));
        label2.setBounds(30, 110, 100, 30);
        frame_dagangan.add(label2);

        JLabel label3 = new JLabel("ID Barang");
        label3.setFont(new Font("Arial", Font.PLAIN, 12));
        label3.setBounds(30, 160, 100, 30);
        frame_dagangan.add(label3);

        JLabel label4 = new JLabel(" jumlah ");
        label4.setFont(new Font("Arial", Font.PLAIN, 12));
        label4.setBounds(30, 200, 100, 30);
        frame_dagangan.add(label4);

//        JLabel label5 = new JLabel("total ");
//        label5.setFont(new Font("Arial", Font.PLAIN, 12));
//        label5.setBounds(30, 240, 100, 30);
//        frame_dagangan.add(label5);

        JTextField tfIdDagangan = new JTextField();
        tfIdDagangan.setBounds(120, 70, 200, 30);
        tfIdDagangan.setEnabled(false);
        tfIdDagangan.setText(String.valueOf(this.crudDagangan.getSequenceIdDagangan()));
        frame_dagangan.add(tfIdDagangan);

        JTextField tfIdKaryawan = new JTextField();
        tfIdKaryawan.setBounds(120, 110, 200, 30);
        frame_dagangan.add(tfIdKaryawan);

        JTextField tfIdBarang = new JTextField();
        tfIdBarang.setBounds(120, 160, 200, 30);
        frame_dagangan.add(tfIdBarang);

        JTextField tfJumlah = new JTextField();
        tfJumlah.setBounds(120, 200, 200, 30);
        frame_dagangan.add(tfJumlah);

//        JTextField tfTotal = new JTextField();
//        tfTotal.setBounds(120, 240, 200, 30);
//        frame_dagangan.add(tfTotal);
        JTable tabel = new JTable();
        JScrollPane scroll_pane = new JScrollPane(tabel);
        scroll_pane.setBounds(30, 310, 500, 200);

        JButton button_insert = new JButton("Insert");
        button_insert.setFont(new Font("Arial", Font.PLAIN, 12));
        button_insert.setBounds(30, 280, 80, 20);
        frame_dagangan.add(button_insert);
        button_insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    int idKaryawan = Integer.parseInt(tfIdKaryawan.getText());
                    int idBarang = Integer.parseInt(tfIdBarang.getText());
                    int idDagangan = crudDagangan.getSequenceIdDagangan();
                    int idDagangan2 = crudDagangan.getSequenceIdDagangan() - 1;
                    String tanggalDagangan = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
                    int jumlah = 0;
                    boolean error1 = true;
                    try {
                        jumlah = Integer.parseInt(tfJumlah.getText());
                        error1 = false;
                    } catch (NumberFormatException a) {
                        JOptionPane.showMessageDialog(null, "Jumlah harus angka");
                    }

                    int total = crudBarang.hitungTotalHarga(idBarang, jumlah);

                    if (error1 == false) {
                        Object source = evt.getSource();
                        if (source == button_insert) {

                            if (click == 0) {
                                crudDagangan.insert(idKaryawan, tanggalDagangan);
                                crudDetailDagangan.UpdatePesanan(idDagangan, idBarang, jumlah, total);
                                dataPerhitunganSementara.TampungData(jumlah, total);
                                tabel.setModel(crudDagangan.viewTable());
                                tfIdDagangan.setText(String.valueOf(crudDagangan.getSequenceIdDagangan()));

                            } else {
                                crudDetailDagangan.UpdatePesanan(idDagangan2, idBarang, jumlah, total);
                                dataPerhitunganSementara.TampungData(jumlah, total);
                                tabel.setModel(crudDagangan.viewTable());
                            }
                            click++;
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Dagangan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        JButton buttonClear = new JButton("Clear");
        buttonClear.setFont(new Font("Arial", Font.PLAIN, 12));
        buttonClear.setBounds(250, 280, 80, 20);
        frame_dagangan.add(buttonClear);
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    int idDagangan = crudDagangan.getSequenceIdDagangan() - 1;
                    dataPerhitunganSementara.aksesPerhitungan(idDagangan);
                    tabel.setModel(crudDagangan.viewTable());
                    dataPerhitunganSementara.Null();
                    click = 0;
                } catch (SQLException ex) {
                    Logger.getLogger(Dagangan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        JButton button_keluar = new JButton("keluar");
        button_keluar.setFont(new Font("Arial", Font.PLAIN, 12));
        button_keluar.setBounds(440, 280, 80, 20);
        button_keluar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Toko t = new Toko();
                frame_dagangan.dispose();
            }
        });
        frame_dagangan.add(button_keluar);
        tabel.setModel(this.crudDagangan.viewTable());
        frame_dagangan.add(scroll_pane);

        frame_dagangan.setVisible(true);
    }
}
