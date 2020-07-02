package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Login {

    public Login() {
        JFrame frame = new JFrame();
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("MANAGER");
        label.setFont(new Font("Times New Roman", Font.BOLD, 35));
        label.setBounds(230, 10, 200, 40);
        frame.add(label);

        JLabel label3 = new JLabel("Password");
        label3.setFont(new Font("Times New Roman", Font.BOLD, 20));
        label3.setBounds(30, 120, 100, 30);
        frame.add(label3);

        JPasswordField text_pw = new JPasswordField();
        text_pw.setBounds(135, 120, 205, 30);
        frame.add(text_pw);

        JButton button_login = new JButton("Login");
        button_login.setFont(new Font("Arial", Font.BOLD, 12));
        button_login.setBounds(135, 170, 100, 50);
        button_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (text_pw.getText().equals("qwerty")) {
                    JOptionPane.showMessageDialog(null, "anda berhasil login");
                    Toko toko = new Toko();
                    frame.dispose();
                }
            }
        });
        frame.add(button_login);

        JButton button_cancel = new JButton("Cancel");
        button_cancel.setFont(new Font("Arial", Font.BOLD, 12));
        button_cancel.setBounds(240, 170, 100, 50);
        button_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                frame.dispose();
            }
        });
        frame.add(button_cancel);

        frame.setVisible(true);
    }
}
