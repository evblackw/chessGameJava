package chess;

import java.awt.Point;
import java.awt.Color;

public class GameSquare {
	private Color color = null;
	private Point position = null;
	private GamePiece piece = null;
	private boolean hasBeenVisited = false;
	
	public GameSquare(Color aColor, int row, int column){
		position = new Point(row, column);
		color = aColor;
	}
	
	public Point getPosition(){
		return position;
	}
	
	public Color getColor(){
		return color;
	}
	
	public void placePiece(GamePiece aPiece){
		piece = aPiece;
		hasBeenVisited = true;
	}
	
	public GamePiece removePiece(){
		GamePiece tmp = piece;
		piece = null;
		return tmp;
	}
	
	public boolean isOccupied(){
		return piece != null;
	}
	
	public boolean hasBeenVisited(){
		return hasBeenVisited;
	}
	
	public void setVisited(boolean aBoolean){
		hasBeenVisited = aBoolean;
	}
}
