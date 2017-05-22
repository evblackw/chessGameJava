package chess;

import java.util.List;

public abstract class GameSolver {

	protected List<GameMove> moves = null;
	protected GameBoard board = null;

	public List<GameMove> getMoves(){
		return moves;
	}
	
	public boolean solve() {
		List<GameMove> nextMoves = nextLegalMoves();
		if(nextMoves.isEmpty()){
			return hasSolution();
		}
		for( GameMove eachMove: nextMoves){
			eachMove.makeMoveOn(board);
			moves.add(eachMove);
			if(solve()){
				return true;
			}
			
			moves.remove(moves.size()-1);
			eachMove.undoMoveOn(board);
		}
		return false;
	}
	
	public abstract boolean hasSolution();

	public abstract List<GameMove> nextLegalMoves();
}

		//need has solution method
		//if you've placed n queens on an n*n board isMoves.size()==board.size() ?
		//need to keep track of what row we're working on and what queens are on the board
		//ask yourself if any queens are threatening the squares. eachMove is one queen on a board
		//for each loop?
		//due last day of class! extra credit...create abstract method in gamesolver that writes
		//the solution of to a file
		//if didn't find solution, print no solution found...
		//scanner.in scanner.out
		//Break it into smaller chunks in order to get this working..
		//Writing tests will save you grief...
		//In class GameBoard we will extend the class Observable
