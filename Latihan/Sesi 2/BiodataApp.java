import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BiodataApp extends JFrame {
    private JTextField nameField, phoneField;
    private JTextArea biodataArea;
    private JButton addButton;

    public BiodataApp() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Biodata Teman");

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Nama:"));
        nameField = new JTextField(20);
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Nomor Telepon:"));
        phoneField = new JTextField(20);
        inputPanel.add(phoneField);
        addButton = new JButton("Tambah");
        inputPanel.add(addButton);

        // Text area
        biodataArea = new JTextArea(10, 30);
        biodataArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(biodataArea);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String phone = phoneField.getText();
                if (!name.isEmpty() && !phone.isEmpty()) {
                    biodataArea.append(name + " - " + phone + "\n");
                    biodataArea.append("============================\n");
                    nameField.setText("");
                    phoneField.setText("");
                } else {
                    JOptionPane.showMessageDialog(BiodataApp.this, "Nama dan nomor telepon harus diisi!");
                }
            }
        });

        this.add(mainPanel);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BiodataApp();
            }
        });
    }
}