package chess;

import java.awt.Point;

public class TravelMove extends GameMove {
	public TravelMove( Point aFromPoint, Point aToPoint, GamePiece aPiece){
		from = aFromPoint;
		to = aToPoint;
		piece = aPiece;
	} 
	
	public void makeMoveOn(GameBoard board){
		board.removePieceAt(from);
		board.placePieceAt(piece, to);
	}
	
	public Point getTo(){
		return to;
	}
	
	public Point getFrom(){
		return from;
	}
	
	public void undoMoveOn(GameBoard board){
		board.removePieceAt(to);
		board.placePieceAt(piece, from);
		board.setVisitedAt(false, to);
	}
}
