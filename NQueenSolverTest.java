package chess;


import java.awt.Color;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NQueenSolverTest {
	
	GameSolver solver = null;

	@Before
	public void setUp() throws Exception {
		GameBoard board = new GameBoard(Color.gray, Color.blue, 8);
		solver = new NQueenSolver(board);
	}

	@After
	public void tearDown() throws Exception {
		solver = null;
	}

	@Test
	public void testSolution() {
		assertTrue(solver.solve());
		assertTrue(true);
	}

}
