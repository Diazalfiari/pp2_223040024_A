package view;

import dao.BiodataDao;
import model.Biodata;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BiodataFrame extends JFrame {
    private JTextField txtId;
    private JTextField txtNama;
    private JTextField txtAlamat;
    private JTextField txtTelepon;
    private JButton btnSave;
    private JButton btnUpdate;
    private JButton btnDelete;
    private BiodataDao dao;

    public BiodataFrame() {
        dao = new BiodataDao();

        txtId = new JTextField(20);
        txtNama = new JTextField(20);
        txtAlamat = new JTextField(20);
        txtTelepon = new JTextField(20);

        btnSave = new JButton("Save");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Biodata biodata = new Biodata(txtId.getText(), txtNama.getText(), txtAlamat.getText(),
                        txtTelepon.getText());
                dao.save(biodata);
                loadData();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Biodata biodata = new Biodata(txtId.getText(), txtNama.getText(), txtAlamat.getText(),
                        txtTelepon.getText());
                dao.update(biodata);
                loadData();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dao.delete(txtId.getText());
                loadData();
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("ID:"));
        panel.add(txtId);
        panel.add(new JLabel("Nama:"));
        panel.add(txtNama);
        panel.add(new JLabel("Alamat:"));
        panel.add(txtAlamat);
        panel.add(new JLabel("Telepon:"));
        panel.add(txtTelepon);
        panel.add(btnSave);
        panel.add(btnUpdate);
        panel.add(btnDelete);

        add(panel);
        setTitle("Aplikasi Biodata");
        setSize(280, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void loadData() {
        // Refresh the data in the UI (e.g., reload the JTable)
        JOptionPane.showMessageDialog(this, "Data berhasil dimuat ulang!");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BiodataFrame().setVisible(true));
    }
}
