package chess;

import java.awt.Color;
import java.awt.Point;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameBoardTest {
	
	private GameBoard board = null;
	GameSquare square = null;
	

	@Before
	public void setUp() throws Exception {
		board = new GameBoard(Color.red,Color.black,8);
	}

	@After
	public void tearDown() throws Exception {
		board = null;
		square = null;
		
	}

	@Test
	public void testSize() {
		assertTrue(board.size() == 8);
	}
	@Test
	public void testSquareAt(){
	
		square = board.squareAt(new Point (0,0));
		assertTrue(square.getColor() == Color.black);
		
		square = board.squareAt(new Point(0,1));
		assertTrue(square.getColor() == Color.red);
		
		square = board.squareAt(new Point(0,2));
		assertTrue(square.getColor() == Color.black);
		
		square = board.squareAt(new Point(0,3));
		assertTrue(square.getColor() == Color.red);
		
		square = board.squareAt(new Point(1,1));
		assertTrue(square.getColor() == Color.black);
		
	}
	
}
