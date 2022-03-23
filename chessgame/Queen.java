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
public class Queen extends Piece {

    public Queen(int X, int Y, ChColor pieceColor, String type, boolean isMoved) {
        super(X, Y, pieceColor, type, isMoved);
        possibleMoves = new ArrayList<>();
        allpossibleMoves = new ArrayList<>();
        if (pieceColor == ChColor.LIGHT) {
            setPhotoName("D:\\projects\\ChessGame\\ChessImages\\73.png");
        } else {
            setPhotoName("D:\\projects\\ChessGame\\ChessImages\\03.png");
        }

    }

    @Override
    ArrayList<Square> moves(Square squares[][]) {
        possibleMoves.clear();
        allpossibleMoves.clear();
        //ROOK MOVES
        //HORIZONTAL RIGHT POSSIBLEMOVES OF ROOK

        for (int i = this.getX() + 1; i <= 7; i++) {
            allpossibleMoves.add(squares[i][this.getY()]);
            if (squares[i][this.getY()].getMyPiece() == null) {
                squares[i][this.getY()].setHighlight(true);
                possibleMoves.add(squares[i][this.getY()]);

            } else if (squares[i][this.getY()].getMyPiece() != null) {
                if (squares[i][this.getY()].getMyPiece().getPieceColor() == this.getPieceColor()) {
                    break;
                } else {
                    squares[i][this.getY()].setHighlight(true);
                    possibleMoves.add(squares[i][this.getY()]);
                    break;
                }
            }

        }

        //HORIZONTAL LEFT POSSIBLEMOVES OF ROOK
        for (int i = this.getX() - 1; i >= 0; i--) {
            allpossibleMoves.add(squares[i][this.getY()]);
            if (squares[i][this.getY()].getMyPiece() == null) {
                squares[i][this.getY()].setHighlight(true);
                possibleMoves.add(squares[i][this.getY()]);
            } else if (squares[i][this.getY()].getMyPiece() != null) {
                if (squares[i][this.getY()].getMyPiece().getPieceColor() == this.getPieceColor()) {
                    break;
                } else {
                    squares[i][this.getY()].setHighlight(true);
                    possibleMoves.add(squares[i][this.getY()]);
                    break;
                }
            }

        }
        //VERTICAL UP POSSIBLEMOVES OF ROOK
        for (int i = this.getY() - 1; i >= 0; i--) {
            allpossibleMoves.add(squares[this.getX()][i]);

            if (squares[this.getX()][i].getMyPiece() == null) {
                squares[this.getX()][i].setHighlight(true);
                possibleMoves.add(squares[this.getX()][i]);
            } else if (squares[this.getX()][i].getMyPiece() != null) {
                if (squares[this.getX()][i].getMyPiece().getPieceColor() == this.getPieceColor()) {
                    break;
                } else {
                    squares[this.getX()][i].setHighlight(true);
                    possibleMoves.add(squares[this.getX()][i]);
                    break;
                }
            }
        }
        //VERTICAL DOWN POSSIBLEMOVES OF ROOK

        for (int i = this.getY() + 1; i <= 7; i++) {
            allpossibleMoves.add(squares[this.getX()][i]);

            if (squares[this.getX()][i].getMyPiece() == null) {
                squares[this.getX()][i].setHighlight(true);
                possibleMoves.add(squares[this.getX()][i]);
            } else if (squares[this.getX()][i].getMyPiece() != null) {
                if (squares[this.getX()][i].getMyPiece().getPieceColor() == this.getPieceColor()) {
                    break;
                } else {
                    squares[this.getX()][i].setHighlight(true);
                    possibleMoves.add(squares[this.getX()][i]);
                    break;
                }
            }
        }
        /**
         * ***************************************************************
         */

        //BISHOP MOVES
        //diagonally left upwards POSSIBLEMOVES OF BISHOP
        int i = this.getX() - 1;
        int j = this.getY() - 1;

        while (i >= 0 && j >= 0) {
            allpossibleMoves.add(squares[i][j]);

            if (squares[i][j].getMyPiece() == null) {
                squares[i][j].setHighlight(true);
                possibleMoves.add(squares[i][j]);
            } else if (squares[i][j].getMyPiece() != null) {
                if (squares[i][j].getMyPiece().getPieceColor() == this.getPieceColor()) {
                    break;
                } else {
                    squares[i][j].setHighlight(true);
                    possibleMoves.add(squares[i][j]);
                    break;
                }
            }

            i--;
            j--;
        }
        //diagonally left downwards POSSIBLEMOVES OF BISHOP

        i = this.getX() - 1;
        j = this.getY() + 1;

        while (i >= 0 && j <= 7) {
            allpossibleMoves.add(squares[i][j]);

            if (squares[i][j].getMyPiece() == null) {
                squares[i][j].setHighlight(true);
                possibleMoves.add(squares[i][j]);
            } else if (squares[i][j].getMyPiece() != null) {
                if (squares[i][j].getMyPiece().getPieceColor() == this.getPieceColor()) {
                    break;
                } else {
                    squares[i][j].setHighlight(true);
                    possibleMoves.add(squares[i][j]);
                    break;
                }
            }
            i--;
            j++;
        }

        //diagonally right upwards POSSIBLEMOVES OF BISHOP
        i = this.getX() + 1;
        j = this.getY() - 1;

        while (i <= 7 && j >= 0) {
            allpossibleMoves.add(squares[i][j]);

            if (squares[i][j].getMyPiece() == null) {
                squares[i][j].setHighlight(true);
                possibleMoves.add(squares[i][j]);
            } else if (squares[i][j].getMyPiece() != null) {
                if (squares[i][j].getMyPiece().getPieceColor() == this.getPieceColor()) {
                    break;
                } else {
                    squares[i][j].setHighlight(true);
                    possibleMoves.add(squares[i][j]);
                    break;
                }
            }
            i++;
            j--;
        }
        //diagonally right downwards POSSIBLEMOVES OF BISHOP 

        i = this.getX() + 1;
        j = this.getY() + 1;

        while (i <= 7 && j <= 7) {
            allpossibleMoves.add(squares[i][j]);

            if (squares[i][j].getMyPiece() == null) {
                squares[i][j].setHighlight(true);
                possibleMoves.add(squares[i][j]);
            } else if (squares[i][j].getMyPiece() != null) {
                if (squares[i][j].getMyPiece().getPieceColor() == this.getPieceColor()) {
                    break;
                } else {
                    squares[i][j].setHighlight(true);
                    possibleMoves.add(squares[i][j]);
                    break;
                }
            }
            i++;
            j++;
        }
        return possibleMoves;
    }
}
