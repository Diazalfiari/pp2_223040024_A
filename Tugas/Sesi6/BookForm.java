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

public class BookForm extends JFrame {
    private JTextField txtIsbn = new JTextField();
    private JTextField txtTitle = new JTextField();
    private JTextArea txtDescription = new JTextArea();
    private JComboBox<String> comboCategory;
    private JRadioButton radioNew, radioUsed;
    private JCheckBox checkAvailable;
    private JSpinner spinnerStock;
    private JSlider sliderPrice;
    private JTable tblBooks;
    private DefaultTableModel tableModel;
    
    public BookForm() {
        setTitle("Manajemen Buku");
        setSize(600, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Setup components
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // ISBN & Title
        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel("ISBN:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(txtIsbn, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel("Judul:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(txtTitle, gbc);
        
        // Description
        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel("Deskripsi:"), gbc);
        gbc.gridx = 1;
        txtDescription.setRows(3);
        inputPanel.add(new JScrollPane(txtDescription), gbc);
        
        // Category ComboBox
        String[] categories = {"Novel", "Pendidikan", "Komik", "Majalah"};
        comboCategory = new JComboBox<>(categories);
        gbc.gridx = 0; gbc.gridy = 3;
        inputPanel.add(new JLabel("Kategori:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(comboCategory, gbc);
        
        // Condition Radio Buttons
        ButtonGroup groupCondition = new ButtonGroup();
        radioNew = new JRadioButton("Baru");
        radioUsed = new JRadioButton("Bekas");
        groupCondition.add(radioNew);
        groupCondition.add(radioUsed);
        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        radioPanel.add(radioNew);
        radioPanel.add(radioUsed);
        gbc.gridx = 0; gbc.gridy = 4;
        inputPanel.add(new JLabel("Kondisi:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(radioPanel, gbc);
        
        // Available Checkbox
        checkAvailable = new JCheckBox("Tersedia");
        gbc.gridx = 0; gbc.gridy = 5;
        inputPanel.add(new JLabel("Status:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(checkAvailable, gbc);
        
        // Stock Spinner
        spinnerStock = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        gbc.gridx = 0; gbc.gridy = 6;
        inputPanel.add(new JLabel("Stok:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(spinnerStock, gbc);
        
        // Price Slider
        sliderPrice = new JSlider(0, 500000, 50000);
        sliderPrice.setMajorTickSpacing(100000);
        sliderPrice.setPaintTicks(true);
        sliderPrice.setPaintLabels(true);
        gbc.gridx = 0; gbc.gridy = 7;
        inputPanel.add(new JLabel("Harga:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(sliderPrice, gbc);
        
        // Submit Button
        JButton btnSubmit = new JButton("Simpan");
        gbc.gridx = 1; gbc.gridy = 8;
        inputPanel.add(btnSubmit, gbc);
        
        // Table
        String[] columns = {"ISBN", "Judul", "Kategori", "Kondisi", "Status", "Stok", "Harga"};
        tableModel = new DefaultTableModel(columns, 0);
        tblBooks = new JTable(tableModel);
        
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(tblBooks), BorderLayout.CENTER);
        
        add(mainPanel);
        
        // Event handler untuk button submit
        btnSubmit.addActionListener(e -> {
            String isbn = txtIsbn.getText();
            String title = txtTitle.getText();
            String category = (String) comboCategory.getSelectedItem();
            String condition = radioNew.isSelected() ? "Baru" : "Bekas";
            String status = checkAvailable.isSelected() ? "Tersedia" : "Tidak Tersedia";
            int stock = (int) spinnerStock.getValue();
            int price = sliderPrice.getValue();
            
            Object[] row = {isbn, title, category, condition, status, stock, price};
            tableModel.addRow(row);
            
            // Clear inputs
            txtIsbn.setText("");
            txtTitle.setText("");
            txtDescription.setText("");
            comboCategory.setSelectedIndex(0);
            radioNew.setSelected(true);
            checkAvailable.setSelected(false);
            spinnerStock.setValue(0);
            sliderPrice.setValue(50000);
        });
    }
}