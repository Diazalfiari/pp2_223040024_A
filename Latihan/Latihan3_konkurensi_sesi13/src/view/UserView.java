/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
/**
 *
 * @author Diaza
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.swing.*;
import java.awt.*;
import java.util.List;
/**
 *
 * @author diaza
 */
public class UserView extends JFrame {
    private JTextField txtName = new JTextField(20); 
    private JTextField txtEmail = new JTextField(20); 
    private JButton btnAdd = new JButton("Add User"); 
    private JButton btnRefresh = new JButton("Refresh"); 
    private JButton btnExport = new JButton("Export"); 
    private JList<String> userList = new JList<>();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    
    // Tambahan komponen baru
    private JProgressBar progressBar;
    private JLabel statusLabel;

    public UserView() {
        setTitle("User Management");
        setSize(400, 400); // Ukuran diperbesar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel utama dengan GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(txtName);
        inputPanel.add(new JLabel("Email:")); 
        inputPanel.add(txtEmail);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout()); 
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnRefresh); 
        buttonPanel.add(btnExport);

        // Progress components
        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        statusLabel = new JLabel("Ready", JLabel.CENTER);

        // Layout arrangement
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(inputPanel, gbc);

        gbc.gridy = 1;
        mainPanel.add(buttonPanel, gbc);

        gbc.gridy = 2;
        mainPanel.add(statusLabel, gbc);

        gbc.gridy = 3;
        mainPanel.add(progressBar, gbc);

        gbc.gridy = 4;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(new JScrollPane(userList), gbc);

        userList.setModel(listModel);
        add(mainPanel);
    }

    // Getter methods yang sudah ada
    public String getNameInput() { 
        return txtName.getText();
    }
    
    public String getEmailInput() {
        return txtEmail.getText();
    }

    public void setUserList(String[] users) {
        listModel.clear();
        for (String user : users) {
            listModel.addElement(user);
        }
    }

    // Menambahkan method untuk progress bar dan status
    public void setProgress(int progress) {
        progressBar.setValue(progress);
    }

    public void setStatus(String status) {
        statusLabel.setText(status);
    }

    public void enableButtons(boolean enable) {
        btnAdd.setEnabled(enable);
        btnRefresh.setEnabled(enable);
        btnExport.setEnabled(enable);
    }
           
    // Listener methods yang sudah ada
    public void addAddUserListener(ActionListener listener) { 
        btnAdd.addActionListener(listener);
    }

    public void addRefreshListener(ActionListener listener) { 
        btnRefresh.addActionListener(listener);
    }
    
    public void addExportListener(ActionListener listener) {
        btnExport.addActionListener(listener);
    }
}
