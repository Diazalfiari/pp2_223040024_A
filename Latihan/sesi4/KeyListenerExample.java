package Latihan.sesi4;

import javax.swing.*;
import java.awt.event.*;

public class KeyListenerExample {
    
    public static void main(String[] args) {
        //membuat frame
        JFrame frame = new JFrame("KeyListener Example");

        //Membuat label untuk menampilan pesan
        JLabel label = new JLabel("Tekan tombol pada keyboard.");
        label.setBounds(50, 50, 300, 30);

        //membuat text field untuk fokus keyboard
        JTextField textField = new JTextField();
        textField.setBounds(50, 100, 200, 30);

        //Menambahkan KeyListener ke text filed
        textField.addKeyListener(new KeyAdapter() {
            //Dijalankan ketika tombol ditekan
            public void keyPressed(KeyEvent e) {
                label.setText("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
            }

            //dijalankan ketika tombol di lepaskan
            public void keyReleased(KeyEvent e) {
                label.setText("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()));
            }

            //digunakan ketika tombol ditekan dan dilepaskan (sama dengan mengetik karakter
            public void keyTyped(KeyEvent e) {
                label.setText("Key Typed: " + e.getKeyChar());
            }
            });

            // Menambahkan komponen ke frame 
            frame.add(label);
            frame.add(textField);

            //setting frame
            frame.setSize(400, 200);
            frame.setLayout(null);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
