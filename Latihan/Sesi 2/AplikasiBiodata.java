import javax.swing.*;
import java.awt.event.*;

public class AplikasiBiodata extends JFrame {

    public AplikasiBiodata() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Aplikasi Biodata");

        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(15, 20, 100, 20);

        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 40, 350, 30);

        JLabel labelNomorHP = new JLabel("Nomor HP:");
        labelNomorHP.setBounds(15, 80, 100, 20);

        JTextField textFieldNomorHP = new JTextField();
        textFieldNomorHP.setBounds(15, 100, 350, 30);

        JLabel labelJenisKelamin = new JLabel("Jenis Kelamin:");
        labelJenisKelamin.setBounds(15, 140, 100, 20);

        JRadioButton radioButtonLaki = new JRadioButton("Laki-Laki", true);
        radioButtonLaki.setBounds(15, 160, 100, 30);

        JRadioButton radioButtonPerempuan = new JRadioButton("Perempuan");
        radioButtonPerempuan.setBounds(120, 160, 100, 30);

        ButtonGroup bgJenisKelamin = new ButtonGroup();
        bgJenisKelamin.add(radioButtonLaki);
        bgJenisKelamin.add(radioButtonPerempuan);

        JCheckBox checkBoxWNA = new JCheckBox("Warga Negara Asing");
        checkBoxWNA.setBounds(15, 200, 200, 30);

        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 240, 100, 30);

        JTextArea textAreaOutput = new JTextArea();
        textAreaOutput.setBounds(15, 280, 350, 150);
        textAreaOutput.setEditable(false);

        buttonSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String nomorHP = textFieldNomorHP.getText();
                String jenisKelamin = radioButtonLaki.isSelected() ? "LAKI-LAKI" : "PEREMPUAN";
                String wna = checkBoxWNA.isSelected() ? "Ya" : "Tidak";

                textAreaOutput.setText("");
                textAreaOutput.append("Nama\t: " + nama + "\n");
                textAreaOutput.append("Nomor HP\t: " + nomorHP + "\n");
                textAreaOutput.append("Jenis Kelamin\t: " + jenisKelamin + "\n");
                textAreaOutput.append("WNA\t: " + wna + "\n");
                textAreaOutput.append("=====================================\n");
            }
        });

        this.add(labelNama);
        this.add(textFieldNama);
        this.add(labelNomorHP);
        this.add(textFieldNomorHP);
        this.add(labelJenisKelamin);
        this.add(radioButtonLaki);
        this.add(radioButtonPerempuan);
        this.add(checkBoxWNA);
        this.add(buttonSimpan);
        this.add(textAreaOutput);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AplikasiBiodata().setVisible(true);
            }
        });
    }
}