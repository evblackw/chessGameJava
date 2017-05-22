package chess;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.Color;

public class GameSquareTest {

	private GameSquare square = null;
	
	@Before
	public void setUp() throws Exception {
		square = new GameSquare(Color.red, 2, 3);
	}

	@After
	public void tearDown() throws Exception {
		square = null;
	}

	@Test
	public void testGetPosition() {
		assertTrue(square.getPosition().getX() == 2);
		assertTrue(square.getPosition().getY() == 3);
	}
	
	@Test
	public void testVisitation() {
		assertFalse(square.hasBeenVisited());
		square.setVisited(true);
		assertTrue(square.hasBeenVisited());
		square.setVisited(false);
		assertFalse(square.hasBeenVisited());
	}
	
	@Test
	public void testOccupation() {
		GamePiece piece = new Knight();
		assertFalse(square.isOccupied());
		square.placePiece(piece);
		assertTrue(square.isOccupied());
		assertTrue(piece.equals(square.removePiece()));
		assertFalse(square.isOccupied());
	}

}
