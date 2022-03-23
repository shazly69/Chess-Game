/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.util.ArrayList;

/**
 *
 * @author moham
 */
public class Pawn extends Piece {

    //ArrayList<Square> allPossibleMoves;

    public Pawn(int X, int Y, ChColor pieceColor, String type, boolean isMoved) {
        super(X, Y, pieceColor, type, isMoved);
        possibleMoves = new ArrayList<>();
        allpossibleMoves = new ArrayList<>();
        if (pieceColor == ChColor.LIGHT) {
            setPhotoName("D:\\projects\\ChessGame\\ChessImages\\2.png");
        } else {
            setPhotoName("D:\\projects\\ChessGame\\ChessImages\\1.png");
        }

    }

    @Override
    ArrayList<Square> moves(Square squares[][]) {
        allpossibleMoves.clear();
        possibleMoves.clear();
        int x = this.getX();
        int y = this.getY();

        //WHITE PAWNS
        if (this.getPieceColor() == ChColor.LIGHT) {


            //PAWNS MOVING FIRST TIME
            if (!this.isIsMoved()) {
                if (squares[x - 1][y].getMyPiece() == null && squares[x - 2][y].getMyPiece() == null) {
                    squares[x - 2][y].setHighlight(true);
                    possibleMoves.add(squares[x - 2][y]);
                }
            }

            //Move straight upwards
            if (x - 1 >= 0 && squares[x - 1][y].getMyPiece() == null) {
                squares[x - 1][y].setHighlight(true);
                possibleMoves.add(squares[x - 1][y]);
            }

            //Move diagonally left upwards
            if (x - 1 >= 0 && y - 1 >= 0) {
                if (squares[x - 1][y - 1].getMyPiece() != null) {
                    if (squares[x - 1][y - 1].getMyPiece().getPieceColor() != this.getPieceColor()) {
                        squares[x - 1][y - 1].setHighlight(true);
                        possibleMoves.add(squares[x - 1][y - 1]);
//                        diagonalPossibleMoves.add(squares[x - 1][y - 1]);
                    }
                } 
                    allpossibleMoves.add(squares[x - 1][y - 1]);
                
            }

            //Move diagonally right upwards
            if (x - 1 >= 0 && y + 1 <= 7) {
                if (squares[x - 1][y + 1].getMyPiece() != null) {
                    if (squares[x - 1][y + 1].getMyPiece().getPieceColor() != this.getPieceColor()) {
                        squares[x - 1][y + 1].setHighlight(true);
                        possibleMoves.add(squares[x - 1][y + 1]);
//                        diagonalPossibleMoves.add(squares[x - 1][y + 1]);
                    }
                } 
                    allpossibleMoves.add(squares[x - 1][y + 1]);
                
            }
           
        } /**
         * ***************************************************************
         */
        //BLACK PAWNS
        else {
            //CHECK FOR PORMOTION


            //Moving first time
            if (!this.isIsMoved()) {
                if (squares[x + 1][y].getMyPiece() == null && squares[x + 2][y].getMyPiece() == null) {
                    squares[x + 2][y].setHighlight(true);
                    possibleMoves.add(squares[x + 2][y]);
                }
            }

            //Move straight downwards
            if (x + 1 <= 7 && squares[x + 1][y].getMyPiece() == null) {
                squares[x + 1][y].setHighlight(true);
                possibleMoves.add(squares[x + 1][y]);
            }

            //Move diagonally left downwards
            if (x + 1 <= 7 && y - 1 >= 0) {
                if (squares[x + 1][y - 1].getMyPiece() != null) {
                    if (squares[x + 1][y - 1].getMyPiece().getPieceColor() != this.getPieceColor()) {
                        squares[x + 1][y - 1].setHighlight(true);
                        possibleMoves.add(squares[x + 1][y - 1]);
                      //  diagonalPossibleMoves.add(squares[x + 1][y - 1]);
                    }

                } 
                    allpossibleMoves.add(squares[x + 1][y - 1]);
                
            }

            //Move diagonally right downwards
            if (x + 1 <= 7 && y + 1 <= 7) {
                if (squares[x + 1][y + 1].getMyPiece() != null) {
                    if (squares[x + 1][y + 1].getMyPiece().getPieceColor() != this.getPieceColor()) {
                        squares[x + 1][y + 1].setHighlight(true);
                        possibleMoves.add(squares[x + 1][y + 1]);
                       // diagonalPossibleMoves.add(squares[x + 1][y + 1]);
                    }
                } 
                    allpossibleMoves.add(squares[x + 1][y + 1]);
                

            }

           
        }
        return possibleMoves;
    }

    
    

}
