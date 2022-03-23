/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author moham
 */
public class Square implements ActionListener {

    private int X;
    private int Y;
    private Piece myPiece;
    private ChColor squareColor;
    private boolean highlight;
    ImageIcon img;
    JButton myButton;
    static int previousX = -1;
    static int previousY = -1;
    static Piece previousPiece = null;
    static boolean isWhite = true;
    static ArrayList<Square> possibleMoves;
   // static ArrayList<Square> attackPossibleMoves;
    //Piece attackPiece;
    //boolean protect = false;

    public Square(int X, int Y, ChColor squareColor) {
        this.X = X;
        this.Y = Y;
        this.squareColor = squareColor;
        this.myPiece = null;
        possibleMoves = new ArrayList<>();
      //  attackPossibleMoves = new ArrayList<>();
        
        

    }

    public Square(int Y, int X, ChColor squareColor, Piece myPiece) {
        this.X = X;
        this.Y = Y;
        this.squareColor = squareColor;
        this.myPiece = myPiece;

        //  myButton.addActionListener(this);
    }

    void resetSquare() {

        this.myPiece = null;
        img = new ImageIcon();
    }

    public void setX(int X) {
        this.X = X;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public void setMyPiece(Piece myPiece) {
        this.myPiece = myPiece;
    }

    public void setSquareColor(ChColor squareColor) {
        this.squareColor = squareColor;
    }

    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public Piece getMyPiece() {
        return myPiece;
    }

    public ChColor getSquareColor() {
        return squareColor;
    }

    public boolean isHighlight() {
        return highlight;
    }

    public void setbuttons(Board b, JPanel game) {
        this.myButton = new JButton();
        myButton.setFocusable(false);
        this.myButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // FIRST PRESS
        if (previousX == -1 && previousY == -1) {
            if (this.myPiece == null) {
                JOptionPane.showMessageDialog(null, "THIS SQUARE DOESN'T HAVE PIECE");
            } else if (this.myPiece != null) {
                if (this.getMyPiece().getPieceColor() == ChColor.DARK && isWhite) {
                    JOptionPane.showMessageDialog(null, "IT IS WHITE TURN");
                    return;
                }
                if (this.getMyPiece().getPieceColor() == ChColor.LIGHT && !isWhite) {
                    JOptionPane.showMessageDialog(null, "IT IS BLACK TURN");
                    return;
                } else {

                    previousX = this.X;
                    previousY = this.Y;
                    previousPiece = this.getMyPiece();
                    
                    possibleMoves.clear();

                    for (Square old : this.myPiece.moves(ChessBoard.b.squares)) {
                        possibleMoves.add(old);
                    }

                    Border greenBorder = new LineBorder(Color.GREEN, 8);
                    Border redBorder = new LineBorder(Color.RED, 8);
                    for (int i = 0; i < possibleMoves.size(); i++) {
                        if (ChessBoard.b.squares[possibleMoves.get(i).X][possibleMoves.get(i).Y].getMyPiece() == null) {
                            ChessBoard.b.squares[possibleMoves.get(i).X][possibleMoves.get(i).Y].myButton.setBorder(greenBorder);
                        } else {
                            ChessBoard.b.squares[possibleMoves.get(i).X][possibleMoves.get(i).Y].myButton.setBorder(redBorder);
                        }
                    }
                }

            }
            //*****************************************************************//

            //SECOND PRESS 
        } 
        else if (previousX != -1 || previousY != -1) {
            if (possibleMoves.contains(this)) {
                if (this.myPiece != null) {

                   ChessBoard.b.delete(myPiece);
                    this.resetSquare();
                  

                }
                if (previousPiece instanceof King && !(previousPiece.isIsMoved())) {
                    if (this.X == previousX && this.Y == 6) {
                        ChessBoard.b.squares[previousX][previousY + 3].myPiece.setY(5);
                        ChessBoard.b.squares[previousX][previousY + 1].setMyPiece(ChessBoard.b.squares[previousX][previousY + 3].getMyPiece());
                        ChessBoard.b.squares[previousX][previousY + 3].resetSquare();
                        ChessBoard.b.squares[previousX][previousY + 3].myButton.setIcon(img);
                        ChessBoard.b.squares[previousX][previousY + 1].img = new ImageIcon(ChessBoard.b.squares[previousX][previousY + 1].myPiece.getPhotoName());
                        ChessBoard.b.squares[previousX][previousY + 1].myButton.setIcon(ChessBoard.b.squares[previousX][previousY + 1].img);

                    } else if (this.X == previousX && this.Y == 2) {
                        ChessBoard.b.squares[previousX][previousY - 4].myPiece.setY(3);
                        ChessBoard.b.squares[previousX][previousY - 1].setMyPiece(ChessBoard.b.squares[previousX][previousY - 4].getMyPiece());
                        ChessBoard.b.squares[previousX][previousY - 4].resetSquare();
                        ChessBoard.b.squares[previousX][previousY - 4].myButton.setIcon(img);
                        ChessBoard.b.squares[previousX][previousY - 1].img = new ImageIcon(ChessBoard.b.squares[previousX][previousY - 1].myPiece.getPhotoName());
                        ChessBoard.b.squares[previousX][previousY - 1].myButton.setIcon(ChessBoard.b.squares[previousX][previousY - 1].img);
                    }
                }
                //MOVE

                previousPiece.setX(this.X);
                previousPiece.setY(this.Y);

                ChessBoard.b.squares[this.X][this.Y].setMyPiece(previousPiece);
                ChessBoard.b.squares[this.X][this.Y].getMyPiece().setIsMoved(true);

                ChessBoard.b.squares[previousX][previousY].resetSquare();
                ChessBoard.b.squares[previousX][previousY].myButton.setIcon(img);

                ChessBoard.b.squares[this.X][this.Y].img = new ImageIcon(previousPiece.getPhotoName());
                ChessBoard.b.squares[this.X][this.Y].myButton.setIcon(img);
                
                if(isWhite){
                    if(((King)ChessBoard.b.bk).check())
                         JOptionPane.showMessageDialog(null, "BLACK KING UNDER CHECK");
                    
                }
                else{
                     if(((King)ChessBoard.b.wk).check())
                         JOptionPane.showMessageDialog(null, "WHITE KING UNDER CHECK");
                }
                

                isWhite = !isWhite;

            } else if (!(this.X == previousX && this.Y == previousY)) {
                JOptionPane.showMessageDialog(null, "ILLEGAL MOVE");

            }

            //Border Noborder = new LineBorder(null);
            for (int i = 0; i < possibleMoves.size(); i++) {
                ChessBoard.b.squares[possibleMoves.get(i).X][possibleMoves.get(i).Y].myButton.setBorder(null);
            }
            previousX = -1;
            previousY = -1;
            possibleMoves.clear();

        }

    }

}
