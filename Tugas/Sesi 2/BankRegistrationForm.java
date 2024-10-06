import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BankRegistrationForm extends JFrame {
    private JTextField textFieldNama, textFieldNomorHP;
    private JRadioButton radioButtonLaki, radioButtonPerempuan;
    private JCheckBox checkBoxWNA;
    private JTextArea textAreaOutput;
    private JList<String> listJenisTabungan;
    private JSlider sliderTransaksi;
    private JPasswordField passwordField, confirmPasswordField;
    private JSpinner spinnerTanggalLahir;

    public BankRegistrationForm() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Form Pendaftaran Nasabah Bank");
        
        // Existing components
        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(15, 20, 100, 20);
        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 40, 350, 30);

        JLabel labelNomorHP = new JLabel("Nomor HP:");
        labelNomorHP.setBounds(15, 80, 100, 20);
        textFieldNomorHP = new JTextField();
        textFieldNomorHP.setBounds(15, 100, 350, 30);

        JLabel labelJenisKelamin = new JLabel("Jenis Kelamin:");
        labelJenisKelamin.setBounds(15, 140, 100, 20);
        radioButtonLaki = new JRadioButton("Laki-Laki", true);
        radioButtonLaki.setBounds(15, 160, 100, 30);
        radioButtonPerempuan = new JRadioButton("Perempuan");
        radioButtonPerempuan.setBounds(120, 160, 100, 30);
        ButtonGroup bgJenisKelamin = new ButtonGroup();
        bgJenisKelamin.add(radioButtonLaki);
        bgJenisKelamin.add(radioButtonPerempuan);

        checkBoxWNA = new JCheckBox("Warga Negara Asing");
        checkBoxWNA.setBounds(15, 200, 200, 30);

        // New components
        JLabel labelJenisTabungan = new JLabel("Jenis Tabungan:");
        labelJenisTabungan.setBounds(15, 240, 150, 20);
        String[] jenisTabungan = {"Tabungan Biasa", "Tabungan Berjangka", "Tabungan Prioritas", "Tabungan Emas"};
        listJenisTabungan = new JList<>(jenisTabungan);
        JScrollPane scrollPaneTabungan = new JScrollPane(listJenisTabungan);
        scrollPaneTabungan.setBounds(15, 260, 350, 80);

        JLabel labelTransaksi = new JLabel("Frekuensi Transaksi per Bulan:");
        labelTransaksi.setBounds(15, 350, 200, 20);
        sliderTransaksi = new JSlider(JSlider.HORIZONTAL, 1, 100, 1);
        sliderTransaksi.setBounds(15, 370, 350, 50);
        sliderTransaksi.setMajorTickSpacing(20);
        sliderTransaksi.setMinorTickSpacing(5);
        sliderTransaksi.setPaintTicks(true);
        sliderTransaksi.setPaintLabels(true);

        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(15, 430, 100, 20);
        passwordField = new JPasswordField();
        passwordField.setBounds(15, 450, 350, 30);

        JLabel labelConfirmPassword = new JLabel("Confirm Password:");
        labelConfirmPassword.setBounds(15, 490, 150, 20);
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(15, 510, 350, 30);

        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir:");
        labelTanggalLahir.setBounds(15, 550, 100, 20);
        SpinnerDateModel dateModel = new SpinnerDateModel();
        spinnerTanggalLahir = new JSpinner(dateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinnerTanggalLahir, "dd/MM/yyyy");
        spinnerTanggalLahir.setEditor(dateEditor);
        spinnerTanggalLahir.setBounds(15, 570, 350, 30);

        JButton buttonSimpan = new JButton("Simpan");
        buttonSimpan.setBounds(15, 610, 100, 30);

        textAreaOutput = new JTextArea();
        textAreaOutput.setBounds(15, 650, 350, 200);
        textAreaOutput.setEditable(false);

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem menuItemReset = new JMenuItem("Reset");
        JMenuItem menuItemExit = new JMenuItem("Exit");
        
        menu.add(menuItemReset);
        menu.add(menuItemExit);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        // Action Listeners
        buttonSimpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simpanData();
            }
        });

        menuItemReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });

        menuItemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add components to frame
        this.add(labelNama);
        this.add(textFieldNama);
        this.add(labelNomorHP);
        this.add(textFieldNomorHP);
        this.add(labelJenisKelamin);
        this.add(radioButtonLaki);
        this.add(radioButtonPerempuan);
        this.add(checkBoxWNA);
        this.add(labelJenisTabungan);
        this.add(scrollPaneTabungan);
        this.add(labelTransaksi);
        this.add(sliderTransaksi);
        this.add(labelPassword);
        this.add(passwordField);
        this.add(labelConfirmPassword);
        this.add(confirmPasswordField);
        this.add(labelTanggalLahir);
        this.add(spinnerTanggalLahir);
        this.add(buttonSimpan);
        this.add(textAreaOutput);

        this.setSize(400, 900);
        this.setLayout(null);
    }

    private void simpanData() {
        String nama = textFieldNama.getText();
        String nomorHP = textFieldNomorHP.getText();
        String jenisKelamin = radioButtonLaki.isSelected() ? "LAKI-LAKI" : "PEREMPUAN";
        String wna = checkBoxWNA.isSelected() ? "Ya" : "Tidak";
        String jenisTabungan = listJenisTabungan.getSelectedValue();
        int frekuensiTransaksi = sliderTransaksi.getValue();
        boolean passwordMatch = Arrays.equals(passwordField.getPassword(), confirmPasswordField.getPassword());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String tanggalLahir = sdf.format((Date) spinnerTanggalLahir.getValue());

        textAreaOutput.setText("");
        textAreaOutput.append("Nama\t: " + nama + "\n");
        textAreaOutput.append("Nomor HP\t: " + nomorHP + "\n");
        textAreaOutput.append("Jenis Kelamin\t: " + jenisKelamin + "\n");
        textAreaOutput.append("WNA\t: " + wna + "\n");
        textAreaOutput.append("Jenis Tabungan\t: " + jenisTabungan + "\n");
        textAreaOutput.append("Frekuensi Transaksi\t: " + frekuensiTransaksi + " kali per bulan\n");
        textAreaOutput.append("Password Match\t: " + (passwordMatch ? "Ya" : "Tidak") + "\n");
        textAreaOutput.append("Tanggal Lahir\t: " + tanggalLahir + "\n");
        textAreaOutput.append("=====================================\n");
    }

    private void resetForm() {
        textFieldNama.setText("");
        textFieldNomorHP.setText("");
        radioButtonLaki.setSelected(true);
        checkBoxWNA.setSelected(false);
        listJenisTabungan.clearSelection();
        sliderTransaksi.setValue(1);
        passwordField.setText("");
        confirmPasswordField.setText("");
        spinnerTanggalLahir.setValue(new Date());
        textAreaOutput.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BankRegistrationForm().setVisible(true);
            }
        });
    }
}