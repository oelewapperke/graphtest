enum Direction {
	north(0, -1), east(1, 0), south(0, 1), west(-1, 0);

	public final int dx, dy;

	Direction(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public Direction reverse() {
		switch (this) {
		case east:
			return west;
		case west:
			return east;
		case north:
			return south;
		case south:
			return north;
		}
		throw new AssertionError("Illegal state for direction object.");
	}
}