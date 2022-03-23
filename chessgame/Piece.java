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
public abstract class Piece {
    private int X;
    private int Y;
    private ChColor pieceColor;
    private String type;
    ArrayList <Square>possibleMoves;
    ArrayList <Square>allpossibleMoves;
    private String photoName;
    private boolean isMoved;

    public Piece(int X, int Y, ChColor pieceColor, String type, boolean isMoved) {
        this.X = X;
        this.Y = Y;
        this.pieceColor = pieceColor;
        this.type = type;
        this.isMoved = isMoved;
 
    }
    
    
    abstract ArrayList<Square>moves(Square squares [][]);

    public void setX(int X) {
        this.X = X;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public void setPieceColor(ChColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPossibleMoves(ArrayList<Square> possibleMoves) {
        this.possibleMoves = possibleMoves;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public void setIsMoved(boolean isMoved) {
        this.isMoved = isMoved;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public ChColor getPieceColor() {
        return pieceColor;
    }

    public String getType() {
        return type;
    }

    public ArrayList<Square> getPossibleMoves() {
        return possibleMoves;
    }

    public String getPhotoName() {
        return photoName;
    }

    public boolean isIsMoved() {
        return isMoved;
    }
    
    

   
    
}
