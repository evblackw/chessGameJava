package chess;

import java.util.List;
import java.util.ArrayList;
import java.awt.Point;

public class KnightsTourSolver extends GameSolver {
	Knight piece = new Knight();
	
	public KnightsTourSolver(GameBoard aBoard, Point aPosition){
		board = aBoard;
		board.placePieceAt(piece, aPosition);
		moves = new ArrayList<GameMove>();
		moves.add(new TravelMove(aPosition, aPosition, piece));
	}

	public Point getPosition(){
		GameMove aMove = moves.get(moves.size()-1);
		return aMove.getTo();
	}
	
	// This does not return a meaningful answer until 
	//    a solution has been attempted.
	public boolean hasSolution(){
		return moves.size() == (board.size() * board.size());
		
	}
	
	public List<GameMove> nextLegalMoves(){
		return piece.allMovesToUnvisitedPosition(board, getPosition());
	}
}