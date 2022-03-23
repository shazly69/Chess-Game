/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author moham
 */
public class Read_me extends JFrame implements ActionListener {

    JButton b1;

    public Read_me() {
        setTitle("READ ME");
        setSize(895, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("D:\\projects\\ChessGame\\ChessImages\\Readme.jpeg"));

        background.setLayout(new FlowLayout());

        b1 = new JButton("BACK");
        b1.setBounds(20, 20, 120, 50);
        b1.setBackground(new Color(153, 153, 153));

        b1.setFocusable(false);
        b1.setFont(new Font("ALGERIAN", Font.BOLD, 30));
        b1.addActionListener(this);

        add(b1);

        add(background);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            setVisible(false);
        }
    }

}
