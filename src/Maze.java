import java.util.ArrayList;

import com.google.common.collect.Lists;

public class Maze {
	public int maxx;
	public int maxy;
	public Place places[][];

	public Maze(int maxx, int maxy) {
		this.maxx = maxx;
		this.maxy = maxy;
		this.places = new Place[maxx][maxy];
		
		ArrayList<Place> not_in_maze = Lists.newArrayList();
		ArrayList<Place> in_maze = Lists.newArrayList();

		// Create the objects.
		for (int x = 0; x < maxx; x++) {
			for (int y = 0; y < maxy; y++) {
				Place p = new Place(x, y);
				places[x][y] = p;

				not_in_maze.add(p);
			}
		}

		not_in_maze.remove(places[0][0]);
		in_maze.add(places[0][0]);

		while (not_in_maze.size() > 0) {
			// Random tile
			int toTry = (int) (Math.random() * in_maze.size());
			Place p = in_maze.get(toTry);

			// Pick a random direction
			Direction direction = Direction.values()[(int) (Math.random() * 4)];
			int nx = p.x + direction.dx;
			int ny = p.y + direction.dy;

			if (nx >= 0 && nx < maxx && ny >= 0 && ny < maxy) {
				Place np = places[nx][ny];
				if (not_in_maze.contains(np)) {
					p.connect(direction, np);
					np.connect(direction.reverse(), p);
					
					not_in_maze.remove(np);
					in_maze.add(np);
				}
			}
		}
	}

	public void printMaze() {
		for (int y = 0; y < this.maxy; y++) {
			for (int x = 0; x < this.maxx; x++) {
				if (this.places[x][y].north == null) System.out.print("XXX"); else System.out.print("X.X");
			}
			System.out.println();
			for (int x = 0; x < this.maxx; x++) {
				if (this.places[x][y].west == null) System.out.print("X"); else System.out.print(".");
				System.out.print(".");
				if (this.places[x][y].east == null) System.out.print("X"); else System.out.print(".");
			}
			System.out.println();
			for (int x = 0; x < this.maxx; x++) {
				if (this.places[x][y].south == null) System.out.print("XXX"); else System.out.print("X.X");
			}
			System.out.println();
		}
	}
	
	public Vector getDestination(Direction[] path, int start_x, int start_y) {
		// TODO implement.
		return new Vector(0, 0);
	}
}
