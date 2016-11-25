package checkerssolitaire;

class CheckerNode {
	int pos_x;
	int pos_y;
	
	public CheckerNode(int x, int y) {
		pos_x = x;
		pos_y = y;
	}
	
	public int getX() { return pos_x; }
	public int getY() { return pos_y; }
}
