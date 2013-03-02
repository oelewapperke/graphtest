public class Place {
	public int x;
	public int y;
	public Place north;
	public Place south;
	public Place east;
	public Place west;

	public Place(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void connect(Direction d, Place p) {
		switch (d) {
		case north:
			north = p;
			break;
		case south:
			south = p;
			break;
		case east:
			east = p;
			break;
		case west:
			west = p;
			break;
		}
	}
}
