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
public class Knight extends Piece{

    public Knight(int X, int Y, ChColor pieceColor, String type, boolean isMoved) {
        super(X, Y, pieceColor, type, isMoved);
        possibleMoves = new ArrayList<>();
        allpossibleMoves = new ArrayList<>();
        if(pieceColor==ChColor.LIGHT)
            setPhotoName("D:\\projects\\ChessGame\\ChessImages\\76.png");
        else 
             setPhotoName("D:\\projects\\ChessGame\\ChessImages\\01.png");

    }
   @Override
     ArrayList<Square>moves(Square squares [][]){
        possibleMoves.clear();
        allpossibleMoves.clear();
                // A Knight can move to maximum 8 possible squares
        int[] Xpos ={this.getX()-1,this.getX()-2,this.getX()-2,this.getX()-1,
            this.getX()+1,this.getX()+2,this.getX()+2,this.getX()+1};
        
        int [] Ypos ={this.getY()-2,this.getY()-1,this.getY()+1,this.getY()+2,
            this.getY()+2,this.getY()+1,this.getY()-1,this.getY()-2};
        
  
         for(int i=0;i<=7;i++)
        {
            if(Xpos[i]>=0 && Xpos[i]<=7 && Ypos[i]>=0 && Ypos[i]<=7)
            {
                allpossibleMoves.add(squares[Xpos[i]][Ypos[i]]);
                 if(squares[Xpos[i]][Ypos[i]].getMyPiece()==null)
                {
                    
                    squares[Xpos[i]][Ypos[i]].setHighlight(true);
                    possibleMoves.add(squares[Xpos[i]][Ypos[i]]);
                    
                }
                 else if (squares[Xpos[i]][Ypos[i]].getMyPiece().getPieceColor()!=this.getPieceColor()){
                     squares[Xpos[i]][Ypos[i]].setHighlight(true);
                    possibleMoves.add(squares[Xpos[i]][Ypos[i]]);
            }
            }
                
            }
        
         return possibleMoves;
    }
    
}
