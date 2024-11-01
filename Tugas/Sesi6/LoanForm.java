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
import java.time.LocalDate;

public class LoanForm extends JFrame {
    private JTextField txtLoanId = new JTextField();
    private JTextField txtMemberId = new JTextField();
    private JComboBox<String> comboBooks;
    private JSpinner spinnerDuration;
    private JCheckBox checkReturn;
    private JTable tblLoans;
    private DefaultTableModel tableModel;
    
    public LoanForm() {
        setTitle("Peminjaman Buku");
        setSize(600, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Loan ID & Member ID
        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("ID Peminjaman:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(txtLoanId, gbc);
        
       gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("ID Anggota:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(txtMemberId, gbc);
        
        // Book ComboBox
        String[] books = {"Java Programming", "Database Design", "Web Development", "Mobile App Development"};
        comboBooks = new JComboBox<>(books);
        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel("Buku:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(comboBooks, gbc);
        
        // Duration Spinner
        spinnerDuration = new JSpinner(new SpinnerNumberModel(7, 1, 30, 1));
        gbc.gridx = 0; gbc.gridy = 3;
        inputPanel.add(new JLabel("Durasi (hari):"), gbc);
        gbc.gridx = 1;
        inputPanel.add(spinnerDuration, gbc);
        
        // Return Checkbox
        checkReturn = new JCheckBox("Sudah Dikembalikan");
        gbc.gridx = 0; gbc.gridy = 4;
        inputPanel.add(new JLabel("Status:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(checkReturn, gbc);
        
        // Submit Button
        JButton btnSubmit = new JButton("Simpan");
        gbc.gridx = 1; gbc.gridy = 5;
        inputPanel.add(btnSubmit, gbc);
        
        // Table
        String[] columns = {"ID Peminjaman", "ID Anggota", "Buku", "Tanggal Pinjam", "Durasi", "Status"};
        tableModel = new DefaultTableModel(columns, 0);
        tblLoans = new JTable(tableModel);
        
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(tblLoans), BorderLayout.CENTER);
        
        add(mainPanel);
        
        // Event handler untuk button submit
        btnSubmit.addActionListener(e -> {
            String loanId = txtLoanId.getText();
            String memberId = txtMemberId.getText();
            String book = (String) comboBooks.getSelectedItem();
            LocalDate loanDate = LocalDate.now();
            int duration = (int) spinnerDuration.getValue();
            String status = checkReturn.isSelected() ? "Dikembalikan" : "Dipinjam";
            
            Object[] row = {loanId, memberId, book, loanDate.toString(), duration, status};
            tableModel.addRow(row);
            
            // Clear inputs
            txtLoanId.setText("");
            txtMemberId.setText("");
            comboBooks.setSelectedIndex(0);
            spinnerDuration.setValue(7);
            checkReturn.setSelected(false);
        });
    }
}