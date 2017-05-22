package chess;

import java.awt.Point;
import java.util.List;
import java.util.ArrayList;

public class Knight extends GamePiece {
	private int[] xMoves = {-2, -2, -1, -1,  1, 1,  2, 2};
	private int[] yMoves = {-1,  1, -2,  2, -2, 2, -1, 1};
	
	public boolean isLegalAndUnvisitedPosition(GameBoard board, Point position){
		if(
				position.x < 0 || position.y < 0
				|| position.x >= board.size()
				|| position.y >= board.size()){	
			return false;
		}
		return !board.hasBeenVisited(position);
	}
	
	public List<GameMove> allMovesToUnvisitedPosition(GameBoard board, Point start){
		List<GameMove> moves = new ArrayList<GameMove>();
		for(int i=0; i < xMoves.length; i++){
			Point toPosition = new Point(start.x + xMoves[i], start.y + yMoves[i]);
			if(isLegalAndUnvisitedPosition(board, toPosition)){
				moves.add(new TravelMove(start, toPosition, this));
			}
		}
		return moves;
	}
}
