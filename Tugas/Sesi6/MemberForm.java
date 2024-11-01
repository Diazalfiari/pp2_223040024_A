/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas.Sesi6;

/**
 *
 * @author diaza
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MemberForm extends JFrame {
    private JTextField txtId = new JTextField();
    private JTextField txtName = new JTextField();
    private JTextArea txtAddress = new JTextArea();
    private JRadioButton radioMale, radioFemale;
    private JCheckBox checkActive;
    private JComboBox<String> comboMembership;
    private JList<String> listHobbies;
    private JTable tblMembers;
    private DefaultTableModel tableModel;
    
    public MemberForm() {
        setTitle("Manajemen Anggota");
        setSize(600, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // ID & Name
        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(txtId, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("Nama:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(txtName, gbc);
        
        // Address
        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel("Alamat:"), gbc);
        gbc.gridx = 1;
        txtAddress.setRows(3);
        inputPanel.add(new JScrollPane(txtAddress), gbc);
        
        // Gender Radio Buttons
        ButtonGroup groupGender = new ButtonGroup();
        radioMale = new JRadioButton("Laki-laki");
        radioFemale = new JRadioButton("Perempuan");
        groupGender.add(radioMale);
        groupGender.add(radioFemale);
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioPanel.add(radioMale);
        radioPanel.add(radioFemale);
        gbc.gridx = 0; gbc.gridy = 3;
        inputPanel.add(new JLabel("Jenis Kelamin:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(radioPanel, gbc);
        
        // Active Status Checkbox
        checkActive = new JCheckBox("Aktif");
        gbc.gridx = 0; gbc.gridy = 4;
        inputPanel.add(new JLabel("Status:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(checkActive, gbc);
        
        // Membership ComboBox
        String[] memberships = {"Regular", "Silver", "Gold", "Platinum"};
        comboMembership = new JComboBox<>(memberships);
        gbc.gridx = 0; gbc.gridy = 5;
        inputPanel.add(new JLabel("Membership:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(comboMembership, gbc);
        
        // Hobbies List
        String[] hobbies = {"Membaca", "Menulis", "Menggambar", "Fotografi", "Musik"};
        listHobbies = new JList<>(hobbies);
        listHobbies.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        gbc.gridx = 0; gbc.gridy = 6;
        inputPanel.add(new JLabel("Hobi:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(new JScrollPane(listHobbies), gbc);
        
        // Submit Button
        JButton btnSubmit = new JButton("Simpan");
        gbc.gridx = 1; gbc.gridy = 7;
        inputPanel.add(btnSubmit, gbc);
        
        // Table
        String[] columns = {"ID", "Nama", "Jenis Kelamin", "Status", "Membership", "Hobi"};
        tableModel = new DefaultTableModel(columns, 0);
        tblMembers = new JTable(tableModel);
        
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(tblMembers), BorderLayout.CENTER);
        
        add(mainPanel);
        
        // Event handler untuk button submit
        btnSubmit.addActionListener(e -> {
            String id = txtId.getText();
            String name = txtName.getText();
            String gender = radioMale.isSelected() ? "Laki-laki" : "Perempuan";
            String status = checkActive.isSelected() ? "Aktif" : "Tidak Aktif";
            String membership = (String) comboMembership.getSelectedItem();
            Object[] row = {id, name, gender, status, membership, hobbies};
            tableModel.addRow(row);
            
            // Clear inputs
            txtId.setText("");
            txtName.setText("");
            txtAddress.setText("");
            radioMale.setSelected(true);
            checkActive.setSelected(false);
            comboMembership.setSelectedIndex(0);
            listHobbies.clearSelection();
        });
    }
}