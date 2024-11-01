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
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Sistem Manajemen Perpustakaan");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Membuat menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuForms = new JMenu("Forms");
        
        JMenuItem menuItemExit = new JMenuItem("Exit");
        JMenuItem menuItemBook = new JMenuItem("Manajemen Buku");
        JMenuItem menuItemMember = new JMenuItem("Manajemen Anggota");
        JMenuItem menuItemLoan = new JMenuItem("Peminjaman");
        
        menuFile.add(menuItemExit);
        menuForms.add(menuItemBook);
        menuForms.add(menuItemMember);
        menuForms.add(menuItemLoan);
        
        menuBar.add(menuFile);
        menuBar.add(menuForms);
        
        setJMenuBar(menuBar);
        
        // Event handlers
        menuItemExit.addActionListener(e -> System.exit(0));
        menuItemBook.addActionListener(e -> new BookForm().setVisible(true));
        menuItemMember.addActionListener(e -> new MemberForm().setVisible(true));
        menuItemLoan.addActionListener(e -> new LoanForm().setVisible(true));
        
        // Label selamat datang
        JLabel welcomeLabel = new JLabel("Selamat Datang di Sistem Manajemen Perpustakaan", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(welcomeLabel);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}