package chess;
import java.awt.Point;

public class PlacePieceMove extends GameMove{
	
	public PlacePieceMove(GamePiece aPiece, Point aPosition){
		piece = aPiece;
		to = aPosition;
		
	}
	
	public void makeMoveOn(GameBoard board){
		board.placePieceAt(piece, to); 
	}
	
	public void undoMoveOn(GameBoard board){
		board.removePieceAt(to); 
	}
	
	
}
