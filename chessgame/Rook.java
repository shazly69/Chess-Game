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
public class Rook extends Piece{
      public Rook(int X, int Y, ChColor pieceColor, String type, boolean isMoved) {
        super(X, Y, pieceColor, type, isMoved);
        
        if(pieceColor==ChColor.LIGHT)
            setPhotoName("D:\\projects\\ChessGame\\ChessImages\\70.png");
        else 
             setPhotoName("D:\\projects\\ChessGame\\ChessImages\\07.png");

    }
      @Override
     ArrayList<Square>moves(Square squares [][]){
        //possibleMoves.clear();
        possibleMoves = new ArrayList< >();
        allpossibleMoves = new ArrayList< >();
        //VERTICAL DOWNWARD POSSIBLEMOVES OF ROOK
        
        for(int i=this.getX()+1;i<=7;i++)
        {
            allpossibleMoves.add(squares[i][this.getY()]);
            if(squares[i][this.getY()].getMyPiece() == null)
            {
                squares[i][this.getY()].setHighlight(true); 
                possibleMoves.add(squares[i][this.getY()]);
            }

            else if(squares[i][this.getY()].getMyPiece() != null)
            {
                if(squares[i][this.getY()].getMyPiece().getPieceColor()==this.getPieceColor())
                {
                    break;
                }

                else
                {
                    squares[i][this.getY()].setHighlight(true); 
                    possibleMoves.add(squares[i][this.getY()]);
                    
                    break;
                }
            }

        }
        
        //VERTICAL UPWARD POSSIBLEMOVES OF ROOK
        
        for(int i=this.getX()-1;i>=0;i--)
        {
            allpossibleMoves.add(squares[i][this.getY()]);
           if(squares[i][this.getY()].getMyPiece() == null)
            {
                squares[i][this.getY()].setHighlight(true); 
                possibleMoves.add(squares[i][this.getY()]);
            }

            else if(squares[i][this.getY()].getMyPiece() != null)
            {
                if(squares[i][this.getY()].getMyPiece().getPieceColor()==this.getPieceColor())
                {
                    break;
                }

                else
                {
                    squares[i][this.getY()].setHighlight(true); 
                    possibleMoves.add(squares[i][this.getY()]);
                    
                    break;
                }
            }

        }
        //HORIZONTAL LEFT POSSIBLEMOVES OF ROOK
        for(int i=this.getY()-1;i>=0;i--)
        {
            allpossibleMoves.add(squares[this.getX()][i]);
            if(squares[this.getX()][i].getMyPiece() == null)
            {
                squares[this.getX()][i].setHighlight(true); 
                possibleMoves.add(squares[this.getX()][i]);
                
            }

            else if(squares[this.getX()][i].getMyPiece() != null)
            {
                if(squares[this.getX()][i].getMyPiece().getPieceColor()==this.getPieceColor())
                {
                    break;
                }

                else
                {
                    squares[this.getX()][i].setHighlight(true); 
                    possibleMoves.add(squares[this.getX()][i]);
                    break;
                }
            }
        }
        //HORIZONTAL RIGHT POSSIBLEMOVES OF ROOK
        
        for(int i=this.getY()+1;i<=7;i++)
        {
            allpossibleMoves.add(squares[this.getX()][i]);
           if(squares[this.getX()][i].getMyPiece() == null)
            {
                squares[this.getX()][i].setHighlight(true); 
                possibleMoves.add(squares[this.getX()][i]);
            }

            else if(squares[this.getX()][i].getMyPiece() != null)
            {
                if(squares[this.getX()][i].getMyPiece().getPieceColor()==this.getPieceColor())
                {
                    break;
                }

                else
                {
                    squares[this.getX()][i].setHighlight(true); 
                    possibleMoves.add(squares[this.getX()][i]);
                    break;
                }
            }
        }
        
        return possibleMoves;
    }
}

