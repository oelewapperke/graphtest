import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestMaze {
	@Test
	public void testMaze() {
		Maze m = new Maze(10,10);
		m.printMaze();
	}
	
	@Test
	public void testFindPath() {
		Maze m = new Maze(10,10);
		Direction[] path = FindPath.findPath(m, 0, 0, 9, 9);
		Vector x = m.getDestination(path, 0, 0);
		assertEquals(9, x.x);
		assertEquals(9, x.y);
	}
}
