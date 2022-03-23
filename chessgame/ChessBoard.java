/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author moham
 */
public class ChessBoard {

    static Board b;
    static String message = "this's CHESSCAMP";

    ChessBoard() {

        b = new Board();
        JPanel game = new JPanel();
        game.setBounds(0, 0, 600, 600);
        game.setBorder(new LineBorder(Color.BLACK));
        game.setLayout(new GridLayout(8, 8));
        fillTheBoard(game);

        JLabel l = new JLabel();
        l.setText(message);
        l.setFont(new Font("ALGERIAN", Font.BOLD, 30));
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setHorizontalTextPosition(JLabel.CENTER);

        JPanel rightmid = new JPanel();
        rightmid.setBounds(600, 250, 300, 75);
        rightmid.setBackground(Color.white);
        rightmid.add(l);

        JPanel rightup = new JPanel();
        rightup.setBounds(600, 0, 300, 250);
        rightup.setBackground(new Color(153, 153, 153));

        JPanel rightdown = new JPanel();
        rightdown.setBounds(600, 325, 300, 275);
        rightdown.setBackground(new Color(153, 153, 153));

        JFrame f = new JFrame("CHESSCAMP");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setSize(915, 638);
        f.getContentPane().setBackground(Color.cyan);
        f.setResizable(false);
        f.add(rightup);
        f.add(rightdown);
        f.add(rightmid);
        f.add(game);
        f.setVisible(true);

    }

    public void fillTheBoard(JPanel game) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                b.squares[i][j].setbuttons(b, game);
                if (b.squares[i][j].getSquareColor() == ChColor.DARK) {
                    b.squares[i][j].myButton.setBackground(new Color(51, 51, 255));
                } else {
                    b.squares[i][j].myButton.setBackground(Color.white);
                }
                if (b.squares[i][j].getMyPiece() != null) {

                    b.squares[i][j].img = new ImageIcon(b.squares[i][j].getMyPiece().getPhotoName());
                    b.squares[i][j].myButton.setIcon(b.squares[i][j].img);
                } else {

                    b.squares[i][j].img = new ImageIcon();

                }

                game.add(b.squares[i][j].myButton);
            }
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

   

}
