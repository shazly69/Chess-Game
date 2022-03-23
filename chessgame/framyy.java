/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 *
 * @author DELL
 */
public class framyy extends JFrame implements ActionListener {

    JButton play_button = new JButton();
    JButton readme_button = new JButton();
    JButton au_button = new JButton();
    JButton quit_button = new JButton();
    JFrame main_frame = new JFrame();
    //JLabel welcome_label = new JLabel(new ImageIcon("C:\\Users\\moham\\Downloads\\beautiful-hologram-water-color-frame-png_119551.jpg"));
    JLabel welcome_label = new JLabel();

    framyy() {

        welcome_label.setText("Welcome To CHESSCAMP");
        welcome_label.setBounds(135, 50, 1000, 50);
        welcome_label.setFont(new Font("hi", Font.PLAIN, 50));
        welcome_label.setLayout(new FlowLayout());
        welcome_label.setVisible(true);

        play_button.setBounds(275, 150, 250, 50);
        play_button.addActionListener(this);
        play_button.setText("PLAY NOW!");
        play_button.setFocusable(false);
        play_button.setFont(new Font("", Font.BOLD, 25));
        //b1.setForeground(Color.white);
        //b1.setBackground(Color.magenta);
        readme_button.setBounds(275, 250, 250, 50);
        readme_button.addActionListener(this);
        readme_button.setText("READ ME");
        readme_button.setFocusable(false);
        readme_button.setFont(new Font("", Font.BOLD, 25));
        //b2.setForeground(Color.white);
        //b2.setBackground(Color.BLUE);
        au_button.setBounds(275, 350, 250, 50);
        au_button.addActionListener(this);
        au_button.setText("ABOUT US");
        au_button.setFocusable(false);
        au_button.setFont(new Font("", Font.BOLD, 25));
        //b3.setForeground(Color.white);
        //b3.setBackground(Color.BLUE);
        quit_button.setBounds(275, 450, 250, 50);
        quit_button.addActionListener(this);
        quit_button.setText("QUIT GAME");
        quit_button.setFocusable(false);
        quit_button.setFont(new Font("", Font.BOLD, 25));
        //b4.setForeground(Color.white);
        //  quit_button.setBackground(Color.BLACK);

        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setLayout(null);
        main_frame.setSize(850, 550);
        main_frame.setVisible(true);
        main_frame.setTitle("CHESSCAMP");
        main_frame.getContentPane().setBackground(Color.CYAN);
        
        main_frame.setResizable(false);
        main_frame.setLocationRelativeTo(null);
        main_frame.add(welcome_label);
        main_frame.add(play_button);
        main_frame.add(readme_button);
        main_frame.add(au_button);
        main_frame.add(quit_button);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == play_button) {
            ChessBoard firstrun = new ChessBoard();
            main_frame.setVisible(false);
            

        }
        if (ae.getSource() == readme_button) {
             Read_me readme = new Read_me();
            readme.setVisible(true);
          
        }
        if (ae.getSource() == au_button) {
          Aboutus aboutus = new Aboutus();
            aboutus.setVisible(true);

        }
        if (ae.getSource() == quit_button) {
           // main_frame.dispose();
            System.exit(0);
        }
    }
}
