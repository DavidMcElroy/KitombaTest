public class Rover {
	//rover coords
	int x;
	int y;
	//map max coords
	int maxX;
	int maxY;

	String direction;

	public Rover(String line, int maxX, int maxY) {
		String[] coords = line.split(" ");
		x = Integer.parseInt(coords[0]);
		y = Integer.parseInt(coords[1]);
		direction = coords[2];

		this.maxX = maxX;
		this.maxY = maxY;
		
		if (x>maxX){
			x=maxX;
		}else if(x<0){
			x=0;
		}
		if (y>maxY){
			y=maxY;
		}else if(y<0){
			y=0;
		}
		
	}

	public void move() {
		switch (direction) {
		case ("N"):
			if (y + 1 <= maxY) {
				y++;
			}
			break;
		case ("E"):
			if (x + 1 <= maxX) {
				x++;
			}
			break;
		case ("S"):
			if (y - 1 >= 0) {
				y--;
			}
			break;
		case ("W"):
			if (x - 1 >= 0) {
				x--;
			}
			break;
		}
	}

	public void rotateRight() {
		switch (direction) {
		case ("N"):
			direction = "E";
			break;
		case ("E"):
			direction = "S";
			break;
		case ("S"):
			direction = "W";
			break;
		case ("W"):
			direction = "N";
			break;
		}
	}

	public void rotateLeft() {
		switch (direction) {
		case ("N"):
			direction = "W";
			break;
		case ("E"):
			direction = "N";
			break;
		case ("S"):
			direction = "E";
			break;
		case ("W"):
			direction = "S";
			break;
		}
	}

	public String toString() {
		return (x + " " + y + " " + direction);
	}
}