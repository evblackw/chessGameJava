package chess;

import java.awt.Point;
import java.awt.Color;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KnightsTourSolverTest {
	
	GameSolver solver = null;

	@Before
	public void setUp() throws Exception {
		GameBoard board = new GameBoard(Color.gray, Color.blue, 5);
		solver = new KnightsTourSolver(board, new Point(2,2));
	}

	@After
	public void tearDown() throws Exception {
		solver = null;
	}

	@Test
	public void testSolution() {
		assertTrue(solver.solve());
	}

}
