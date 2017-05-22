package chess;

import java.awt.Point;

public abstract class GameMove {

	protected Point from = null;
	protected Point to = null;
	protected GamePiece piece = null;

	public Point getTo(){
		return to;
	}
	public Point getFrom(){
		return from;
	}
	public abstract void makeMoveOn(GameBoard board);
	public abstract void undoMoveOn(GameBoard board);
	
	public boolean isPositionThreatened(Point position){
		return((position.x == to.x) 
				|| (position.y == to.y) 
				|| (Math.abs(position.y-to.y) == Math.abs(position.x - to.x)));

	}
	
	
	

}
