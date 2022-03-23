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
public class King extends Piece {

    ArrayList<Square>[] dangerousMoves = new ArrayList[17];
    boolean shortCastling;
    boolean longCastling;
    boolean check = false;

    public King(int X, int Y, ChColor pieceColor, String type, boolean isMoved) {
        super(X, Y, pieceColor, type, isMoved);
        possibleMoves = new ArrayList<>();
        allpossibleMoves = new ArrayList<>();

        if (pieceColor == ChColor.LIGHT) {
            setPhotoName("D:\\projects\\ChessGame\\ChessImages\\74.png");
        } else {
            setPhotoName("D:\\projects\\ChessGame\\ChessImages\\04.png");
        }

    }

    // TO GET DANGEROUS SQUARES
    public void cantMoves() {

        for (int i = 0; i < 17; i++) {
            dangerousMoves[i] = new ArrayList<>();
        }
        if (this.getPieceColor() == ChColor.LIGHT) {
            if (ChessBoard.b.br1 != null) {
                ChessBoard.b.br1.moves(ChessBoard.b.squares);
            }
            if (ChessBoard.b.br2 != null) {
                ChessBoard.b.br2.moves(ChessBoard.b.squares);
            }
            if (ChessBoard.b.bb1 != null) {
                ChessBoard.b.bb1.moves(ChessBoard.b.squares);
            }
            if (ChessBoard.b.bb2 != null) {
                ChessBoard.b.bb2.moves(ChessBoard.b.squares);
            }
            if (ChessBoard.b.bk != null) {
                ((King) ChessBoard.b.bk).GetallpossibleMoves(ChessBoard.b.squares);
            }
            if (ChessBoard.b.bn1 != null) {
                ChessBoard.b.bn1.moves(ChessBoard.b.squares);
            }
            if (ChessBoard.b.bn2 != null) {
                ChessBoard.b.bn2.moves(ChessBoard.b.squares);
            }
            if (ChessBoard.b.bq != null) {
                ChessBoard.b.bq.moves(ChessBoard.b.squares);
            }
            dangerousMoves[0] = (ChessBoard.b.br1 != null) ? ChessBoard.b.br1.allpossibleMoves : null;
            dangerousMoves[1] = (ChessBoard.b.br2 != null) ? ChessBoard.b.br2.allpossibleMoves : null;
            dangerousMoves[2] = (ChessBoard.b.bb1 != null) ? ChessBoard.b.bb1.allpossibleMoves : null;
            dangerousMoves[3] = (ChessBoard.b.bb2 != null) ? ChessBoard.b.bb2.allpossibleMoves : null;
            dangerousMoves[4] = (ChessBoard.b.bk != null) ? ChessBoard.b.bk.allpossibleMoves : null;
            dangerousMoves[5] = (ChessBoard.b.bn1 != null) ? ChessBoard.b.bn1.allpossibleMoves : null;
            dangerousMoves[6] = (ChessBoard.b.bn2 != null) ? ChessBoard.b.bn2.allpossibleMoves : null;
            dangerousMoves[7] = (ChessBoard.b.bq != null) ? ChessBoard.b.bq.allpossibleMoves : null;
            for (int i = 0; i < 8; i++) {
                if (ChessBoard.b.bp[i] != null) {
                    ChessBoard.b.bp[i].moves(ChessBoard.b.squares);
                }
                dangerousMoves[i + 8] = (ChessBoard.b.bp[i] != null) ?  ChessBoard.b.bp[i].allpossibleMoves : null;
            }
            for (int i = 0; i < 16; i++) {
                if (dangerousMoves[i] != null) {
                    for (Square s : dangerousMoves[i]) {
                        if (Math.abs(s.getX() - this.getX()) <= 1 && Math.abs(s.getY() - this.getY()) <= 1) {
                            dangerousMoves[16].add(s);
                        }
                    }
                }
            }
        } else {
            if (ChessBoard.b.wr1 != null) {
                ChessBoard.b.wr1.moves(ChessBoard.b.squares);
            }
            if (ChessBoard.b.wr2 != null) {
                ChessBoard.b.wr2.moves(ChessBoard.b.squares);
            }
            if (ChessBoard.b.wb1 != null) {
                ChessBoard.b.wb1.moves(ChessBoard.b.squares);
            }
            if (ChessBoard.b.wb2 != null) {
                ChessBoard.b.wb2.moves(ChessBoard.b.squares);
            }
            if (ChessBoard.b.wk != null) {
                ((King) ChessBoard.b.wk).GetallpossibleMoves(ChessBoard.b.squares);

            }
            if (ChessBoard.b.wn1 != null) {
                ChessBoard.b.wn1.moves(ChessBoard.b.squares);
            }
            if (ChessBoard.b.wn2 != null) {
                ChessBoard.b.wn2.moves(ChessBoard.b.squares);
            }
            if (ChessBoard.b.wq != null) {
                ChessBoard.b.wq.moves(ChessBoard.b.squares);
            }
            dangerousMoves[0] = (ChessBoard.b.wr1 != null) ? ChessBoard.b.wr1.allpossibleMoves : null;
            dangerousMoves[1] = (ChessBoard.b.wr2 != null) ? ChessBoard.b.wr2.allpossibleMoves : null;
            dangerousMoves[2] = (ChessBoard.b.wb1 != null) ? ChessBoard.b.wb1.allpossibleMoves : null;
            dangerousMoves[3] = (ChessBoard.b.wb2 != null) ? ChessBoard.b.wb2.allpossibleMoves : null;
            dangerousMoves[4] = (ChessBoard.b.wk != null) ? ChessBoard.b.wk.allpossibleMoves : null;
            dangerousMoves[5] = (ChessBoard.b.wn1 != null) ? ChessBoard.b.wn1.allpossibleMoves : null;
            dangerousMoves[6] = (ChessBoard.b.wn2 != null) ? ChessBoard.b.wn2.allpossibleMoves : null;
            dangerousMoves[7] = (ChessBoard.b.wq != null) ? ChessBoard.b.wq.allpossibleMoves : null;
            for (int i = 0; i < 8; i++) {
                if (ChessBoard.b.wp[i] != null) {
                    ChessBoard.b.wp[i].moves(ChessBoard.b.squares);
                }
                dangerousMoves[i + 8] = (ChessBoard.b.wp[i] != null) ? ((Pawn) ChessBoard.b.wp[i]).allpossibleMoves : null;
            }
            for (int i = 0; i < 16; i++) {
                if (dangerousMoves[i] != null) {
                    for (Square s : dangerousMoves[i]) {
                        if (Math.abs(s.getX() - this.getX()) <= 1 && Math.abs(s.getY() - this.getY()) <= 1) {
                            dangerousMoves[16].add(s);
                        }
                    }
                }
            }
        }

    }

    @Override
    ArrayList<Square> moves(Square[][] squares) {
        possibleMoves.clear();
        this.cantMoves();
        int x = this.getX();
        int y = this.getY();
        int Xpos[] = {x, x - 1, x - 1, x - 1, x, x + 1, x + 1, x + 1};
        int Ypos[] = {y - 1, y - 1, y, y + 1, y + 1, y + 1, y, y - 1};
        CanCastling(squares);
        if (longCastling) {
            possibleMoves.add(squares[x][y - 2]);
        }
        if (shortCastling) {
            possibleMoves.add(squares[x][y + 2]);
        }
        for (int i = 0; i < 8; i++) {
            if ((Xpos[i] >= 0 && Xpos[i] <= 7 && Ypos[i] >= 0 && Ypos[i] <= 7)
                    && !(dangerousMoves[16].contains(squares[Xpos[i]][Ypos[i]]))) {
                if (squares[Xpos[i]][Ypos[i]].getMyPiece() == null) {

                    squares[Xpos[i]][Ypos[i]].setHighlight(true);
                    possibleMoves.add(squares[Xpos[i]][Ypos[i]]);

                } else if (squares[Xpos[i]][Ypos[i]].getMyPiece().getPieceColor() != this.getPieceColor()) {
                    squares[Xpos[i]][Ypos[i]].setHighlight(true);
                    possibleMoves.add(squares[Xpos[i]][Ypos[i]]);
                }
            }

        }
        dangerousMoves[16].clear();
        return possibleMoves;
    }

    public void GetallpossibleMoves(Square[][] squares) {
        allpossibleMoves.clear();
        int x = this.getX();
        int y = this.getY();
        int Xpos[] = {x, x - 1, x - 1, x - 1, x, x + 1, x + 1, x + 1};
        int Ypos[] = {y - 1, y - 1, y, y + 1, y + 1, y + 1, y, y - 1};
        for (int i = 0; i < 8; i++) {
            if (Xpos[i] >= 0 && Xpos[i] <= 7 && Ypos[i] >= 0 && Ypos[i] <= 7) {
                allpossibleMoves.add(squares[Xpos[i]][Ypos[i]]);
            }
        }

    }

    public void CanCastling(Square[][] squares) {
        shortCastling = false;
        longCastling = false;
        ArrayList<Square> checkCastling = new ArrayList<>();
        if (!this.isIsMoved()) {
            int x = this.getX();
            int y = this.getY();
            for (int i = 0; i < 16; i++) {
                if (dangerousMoves[i] != null) {
                    for (Square s : dangerousMoves[i]) {
                        if (Math.abs(s.getX() - this.getX()) == 0 && Math.abs(s.getY() - this.getY()) <= 3) {
                            checkCastling.add(s);
                        }
                    }
                }
            }
            //SHORT CASTLING

            if (squares[x][7].getMyPiece() instanceof Rook && !squares[x][7].getMyPiece().isIsMoved()
                    && !(checkCastling.contains(squares[x][y]))) {
                for (int i = y + 1; i < 7; i++) {
                    if (squares[x][i].getMyPiece() == null && !(checkCastling.contains(squares[x][i]))) {
                        shortCastling = true;
                        continue;
                    } else {
                        shortCastling = false;
                        break;
                    }
                }
            }
            //LONG CASTLING
            if (squares[x][0].getMyPiece() instanceof Rook && !(squares[x][0].getMyPiece().isIsMoved())
                    && !(checkCastling.contains(squares[x][y]))) {
                for (int i = y - 1; i > 0; i--) {
                    if (squares[x][i].getMyPiece() == null && !(checkCastling.contains(squares[x][i]))) {
                        longCastling = true;
                        continue;
                    } else {
                        longCastling = false;
                        break;
                    }
                }
            }

        }

    }

    public boolean check() {
        check = false;
        this.cantMoves();

        if (dangerousMoves[16].contains(ChessBoard.b.squares[this.getX()][this.getY()])) {
            check = true;
        }

        return check;
    }

}
