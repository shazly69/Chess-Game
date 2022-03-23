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
public class Bishop extends Piece{
    
     public Bishop(int X, int Y, ChColor pieceColor, String type, boolean isMoved) {
        super(X, Y, pieceColor, type, isMoved);
        possibleMoves = new ArrayList<>();
        allpossibleMoves = new ArrayList<>();
        if(pieceColor==ChColor.LIGHT)
            setPhotoName("D:\\projects\\ChessGame\\ChessImages\\72.png");
        else 
             setPhotoName("D:\\projects\\ChessGame\\ChessImages\\02.png");

    }
      @Override
     ArrayList<Square>moves(Square squares [][]){
        possibleMoves.clear();
        allpossibleMoves.clear();
        
        //diagonally left upwards POSSIBLEMOVES OF BISHOP
        
        int i = this.getX()-1;
        int j = this.getY()-1;
        
        while(i>=0 && j>=0)
        {
            allpossibleMoves.add(squares[i][j]);
           if(squares[i][j].getMyPiece() == null)
            {
                squares[i][j].setHighlight(true); 
                possibleMoves.add(squares[i][j]);
                
                
            }

            else if(squares[i][j].getMyPiece() != null)
            {
                if(squares[i][j].getMyPiece().getPieceColor()==this.getPieceColor())
                {
                    break;
                }

                else
                {
                    squares[i][j].setHighlight(true); 
                    possibleMoves.add(squares[i][j]);
                    break;
                }
            }
            
              i--;
              j--;
            }
              //diagonally left downwards POSSIBLEMOVES OF BISHOP
              
              i = this.getX()-1;
              j = this.getY()+1;
        
        while(i>=0 && j<=7)
        {
            allpossibleMoves.add(squares[i][j]);
            if(squares[i][j].getMyPiece() == null)
            {
                squares[i][j].setHighlight(true); 
                possibleMoves.add(squares[i][j]);
                
            }

            else if(squares[i][j].getMyPiece() != null)
            {
                if(squares[i][j].getMyPiece().getPieceColor()==this.getPieceColor())
                {
                    break;
                }

                else
                {
                    squares[i][j].setHighlight(true); 
                    possibleMoves.add(squares[i][j]);
                    break;
                }
            }
            i--;
            j++;
        }   
        
         //diagonally right upwards POSSIBLEMOVES OF BISHOP
         
           i = this.getX()+1;
           j = this.getY()-1;
        
        while(i<=7 && j>=0)
        {
            allpossibleMoves.add(squares[i][j]);
            if(squares[i][j].getMyPiece() == null)
            {
                squares[i][j].setHighlight(true); 
                possibleMoves.add(squares[i][j]);
                
            }

            else if(squares[i][j].getMyPiece() != null)
            {
                if(squares[i][j].getMyPiece().getPieceColor()==this.getPieceColor())
                {
                    break;
                }

                else
                {
                    squares[i][j].setHighlight(true); 
                    possibleMoves.add(squares[i][j]);
                    break;
                }
            }
            i++;
            j--;
        }
          //diagonally right downwards POSSIBLEMOVES OF BISHOP 
          
          i = this.getX()+1;
          j = this.getY()+1;
        
        while(i<=7 && j<=7)
        {
            allpossibleMoves.add(squares[i][j]);
             if(squares[i][j].getMyPiece() == null)
            {
                squares[i][j].setHighlight(true); 
                possibleMoves.add(squares[i][j]);
                
            }

            else if(squares[i][j].getMyPiece() != null)
            {
                if(squares[i][j].getMyPiece().getPieceColor()==this.getPieceColor())
                {
                    break;
                }

                else
                {
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

