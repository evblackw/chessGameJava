package chess;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.Color;
import java.awt.Point;

public class GameMoveTest {
	private TravelMove move = null;
	private Knight piece = new Knight();
	private GameBoard board = new GameBoard(Color.cyan, Color.magenta, 8);
	
	@Before
	public void setUp() throws Exception {
		move = new TravelMove(new Point(0,0), new Point(2,1), piece);
	}

	@After
	public void tearDown() throws Exception {
		move = null;
	}

	@Test
	public void testMakeMove() {
		Point start = new Point(0,0);
		Point end = new Point(2,1);
		board.placePieceAt(piece, start);
		
		assertFalse(board.hasBeenVisited(end));
		assertFalse(board.isOccupied(end));
		assertTrue(board.hasBeenVisited(start));
		assertTrue(board.isOccupied(start));
	
		move.makeMoveOn(board); 
		
		assertTrue(board.hasBeenVisited(end));
		assertTrue(board.isOccupied(end));
		assertTrue(board.hasBeenVisited(start));
		assertFalse(board.isOccupied(start));
	}
	
	@Test
	public void testUndoMove(){
		Point end = new Point(0,0);
		Point start = new Point(2,1);
		board.placePieceAt(piece, start);
		move.undoMoveOn(board);
		assertFalse(board.hasBeenVisited(start));
		assertFalse(board.isOccupied(start));
		move.undoMoveOn(board);
		assertTrue(board.hasBeenVisited(end));
		assertTrue(board.isOccupied(end));
	}
	@Test
	public void testIsPositionThreatened(){
		
		GameMove move = new PlacePieceMove(new Queen(), new Point(0,1));
		
		assertTrue(move.isPositionThreatened(new Point(0,2)));
		assertTrue(move.isPositionThreatened(new Point(1,2)));
		assertTrue(move.isPositionThreatened(new Point(0,3)));
		assertTrue(move.isPositionThreatened(new Point(0,5)));
		assertFalse(move.isPositionThreatened(new Point(1,4)));
		assertFalse(move.isPositionThreatened(new Point(5,2)));
		assertTrue(move.isPositionThreatened(new Point(5,6)));
	}

}
