/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.*;
import view.UserView;
import view.UserPdf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author Diaza
 */
public class UserController {
    private UserView view;
    private UserMapper mapper;
    private UserPdf pdf;
    
    public UserController(UserView view, UserMapper mapper, UserPdf pdf) {
        this.view = view;
        this.mapper = mapper;
        this.pdf = pdf;
        
        this.view.addAddUserListener(new AddUserListener()); 
        this.view.addRefreshListener(new RefreshListener());
        this.view.addExportListener(new ExportListener());
    }

    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) { 
            String name = view.getNameInput();
            String email = view.getEmailInput();
            if (!name.isEmpty() && !email.isEmpty()) {
                view.enableButtons(false);
                view.setStatus("Adding user...");

                SwingWorker<Void, Void> worker = new SwingWorker<>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        User user = new User();
                        user.setName(name);
                        user.setEmail(email);
                        mapper.insertUser(user);
                        return null;
                    }

                    @Override
                    protected void done() {
                        view.enableButtons(true);
                        view.setStatus("User added successfully!");
                        JOptionPane.showMessageDialog(view, "User added successfully!");
                    }
                };
                worker.execute();
            } else {
                JOptionPane.showMessageDialog(view, "Please fill in all fields.");
            }
        }
    }

    class RefreshListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.enableButtons(false);
            view.setStatus("Refreshing user list...");

            SwingWorker<List<User>, Void> worker = new SwingWorker<>() {
                @Override
                protected List<User> doInBackground() throws Exception {
                    return mapper.getAllUsers();
                }

                @Override
                protected void done() {
                    try {
                        List<User> users = get();
                        String[] userArray = users.stream()
                            .map(u -> u.getName() + " (" + u.getEmail() + ")")
                            .toArray(String[]::new);
                        view.setUserList(userArray);
                        view.setStatus("User list refreshed");
                        view.enableButtons(true);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        view.setStatus("Error refreshing users");
                    }
                }
            };
            worker.execute();
        }
    }
    
    class ExportListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.enableButtons(false);
            view.setStatus("Exporting to PDF...");
            view.setProgress(0);

            SwingWorker<Void, Integer> worker = new SwingWorker<>() {
                @Override
                protected Void doInBackground() throws Exception {
                    List<User> users = mapper.getAllUsers();
                    // Simulate progress
                    for (int i = 0; i <= 100; i += 10) {
                        Thread.sleep(100); // Simulate work
                        publish(i);
                    }
                    pdf.exportPdf(users);
                    return null;
                }

                @Override
                protected void process(List<Integer> chunks) {
                    int latestProgress = chunks.get(chunks.size() - 1);
                    view.setProgress(latestProgress);
                }

                @Override
                protected void done() {
                    view.setProgress(100);
                    view.setStatus("PDF exported successfully");
                    view.enableButtons(true);
                    JOptionPane.showMessageDialog(view, "PDF exported successfully!");
                }
            };
            worker.execute();
        }
    }
}