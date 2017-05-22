package chess;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NQueenSolver extends GameSolver {
	Queen piece = new Queen();
	
	public NQueenSolver(GameBoard aBoard){
		board = aBoard;
		moves = new ArrayList<GameMove>(); //if you are going to cheat, cheat all the way!	
	}
	

	@Override
	public boolean hasSolution(){
		return moves.size()==board.size();
	}
	
	@Override
	public List<GameMove> nextLegalMoves(){
		List<GameMove> legalMoves = new ArrayList <GameMove>();
		int rowIndex = moves.size();
		
		for(int col = 0; col < board.size(); col++){
			Point position = new Point(col, rowIndex);
			if(isPositionSafe(position)){
				GameMove safeMove = new PlacePieceMove(piece, position);
				legalMoves.add(safeMove);
			}
			
		}
		return legalMoves;
	}
	
	public boolean isPositionSafe(Point aPosition){
		for(GameMove eachMove: moves){
			if(eachMove.isPositionThreatened(aPosition)){
				return false;
			}
		}
		return true;			
	}
	

}
	
	

