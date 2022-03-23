/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

/**
 *
 * @author moham
 */
public class Board {

    public Square[][] squares;
    Piece wr1, wr2, wn1, wn2, wb1, wb2, wq, wk, wp[];
    Piece br1, br2, bn1, bn2, bb1, bb2, bq, bk, bp[];

    Board() {
        squares = new Square[8][8];
        setBoard();

    }

    public void setBoard() {

        //SET SQUARES
        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {

                if ((i + j) % 2 != 0) {

                    squares[i][j] = new Square(i, j, ChColor.DARK);

                } else {
                    squares[i][j] = new Square(i, j, ChColor.LIGHT);

                }

            }
        }
        //SET PIECES
        //WHITE PIECES
        wr1 = new Rook(7, 0, ChColor.LIGHT, "wr1", false);
        wr2 = new Rook(7, 7, ChColor.LIGHT, "wr2", false);
        wn1 = new Knight(7, 1, ChColor.LIGHT, "wn1", false);
        wn2 = new Knight(7, 6, ChColor.LIGHT, "wn2", false);
        wb1 = new Bishop(7, 2, ChColor.LIGHT, "wb1", false);
        wb2 = new Bishop(7, 5, ChColor.LIGHT, "wb2", false);
        wq = new Queen(7, 3, ChColor.LIGHT, "wq", false);
        wk = new King(7, 4, ChColor.LIGHT, "wk", false);

        wp = new Piece[8];
        for (int i = 0; i < 8; i++) {
            wp[i] = new Pawn(6, i, ChColor.LIGHT, "wp" + (i + 1), false);
        }

        //BLACK PIECES
        br1 = new Rook(0, 0, ChColor.DARK, "br1", false);
        br2 = new Rook(0, 7, ChColor.DARK, "br2", false);
        bn1 = new Knight(0, 1, ChColor.DARK, "bn1", false);
        bn2 = new Knight(0, 6, ChColor.DARK, "bn2", false);
        bb1 = new Bishop(0, 2, ChColor.DARK, "bb1", false);
        bb2 = new Bishop(0, 5, ChColor.DARK, "bb2", false);
        bq = new Queen(0, 3, ChColor.DARK, "bq", false);
        bk = new King(0, 4, ChColor.DARK, "bk", false);

        bp = new Piece[8];
        for (int i = 0; i < 8; i++) {
            bp[i] = new Pawn(1, i, ChColor.DARK, "bp" + (i + 1), false);
        }
        // bp[3] = new Pawn(4, 3, ChColor.DARK, "bp" + (5 + 1), false);

        //SET WHITE PIECES
        squares[7][0].setMyPiece(wr1);
        squares[7][7].setMyPiece(wr2);
        squares[7][1].setMyPiece(wn1);
        squares[7][6].setMyPiece(wn2);
        squares[7][2].setMyPiece(wb1);
        squares[7][5].setMyPiece(wb2);
        squares[7][3].setMyPiece(wq);
        squares[7][4].setMyPiece(wk);
        for (int i = 0; i < 8; i++) {
            squares[6][i].setMyPiece(wp[i]);
        }
        //SET BLACK PIECES

        squares[0][0].setMyPiece(br1);
        squares[0][7].setMyPiece(br2);
        squares[0][1].setMyPiece(bn1);
        squares[0][6].setMyPiece(bn2);
        squares[0][2].setMyPiece(bb1);
        squares[0][5].setMyPiece(bb2);
        squares[0][3].setMyPiece(bq);
        squares[0][4].setMyPiece(bk);
        for (int i = 0; i < 8; i++) {
            squares[1][i].setMyPiece(bp[i]);
        }
        //squares[4][3].setMyPiece(bp[3]);
    }

    public void delete(Piece p) {

        if (p == wk) {
            System.exit(0);
        }
        if (p == wb1) {
            wb1 = null;
        }
        if (p == wb2) {
            wb2 = null;
        }
        if (p == wn1) {
            wn1 = null;
        }
        if (p == wn2) {
            wn2 = null;
        }
        if (p == wr1) {
            wr1 = null;
        }
        if (p == wr2) {
            wr2 = null;
        }
        if (p == wq) {
            wq = null;
        }
        for (int i = 0; i < 8; i++) {
            if (p == wp[i]) {
                wp[i] = null;
            }
        }

        if (p == bk) {
            System.exit(0);
        }
        if (p == bb1) {
            bb1 = null;
        }
        if (p == bb2) {
            bb2 = null;
        }
        if (p == bn1) {
            bn1 = null;
        }
        if (p == bn2) {
            bn2 = null;
        }
        if (p == br1) {
            br1 = null;
        }
        if (p == br2) {
            br2 = null;
        }
        if (p == bq) {
            bq = null;
        }
        for (int i = 0; i < 8; i++) {
            if (p == bp[i]) {
                bp[i] = null;
            }
        }

    }
}
