import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JunitTest {
	int maxX = 5;
	int maxY = 5;

	@Test
	public void testRovermove() {
		Rover rover = new Rover("0 0 N", maxX, maxY);

		rover.move();
		assertEquals("0 1 N", rover.toString());

		rover = new Rover("0 0 E", maxX, maxY);

		rover.move();
		assertEquals("1 0 E", rover.toString());

		rover = new Rover("1 1 S", maxX, maxY);

		rover.move();
		assertEquals("1 0 S", rover.toString());

		rover = new Rover("1 1 W", maxX, maxY);
		rover.move();
		assertEquals("0 1 W", rover.toString());
		
		//at walls
		rover = new Rover("5 5 N", maxX, maxY);
		rover.move();
		assertEquals("5 5 N", rover.toString());
		
		rover = new Rover("5 5 E", maxX, maxY);
		rover.move();
		assertEquals("5 5 E", rover.toString());
		
		rover = new Rover("0 0 S", maxX, maxY);
		rover.move();
		assertEquals("0 0 S", rover.toString());
		
		rover = new Rover("0 0 W", maxX, maxY);
		rover.move();
		assertEquals("0 0 W", rover.toString());
		
	}
	
	@Test
	public void testRoverSetup(){

		//out of bounds
		Rover rover = new Rover("6 6 N", maxX, maxY);
		assertEquals("5 5 N", rover.toString());
		
		rover = new Rover("-1 -1 S", maxX, maxY);
		assertEquals("0 0 S", rover.toString());
	}

	
	@Test
	public void testRoverRotate(){
		Rover rover = new Rover("0 0 N", maxX, maxY);
		
		rover.rotateLeft();
		assertEquals("0 0 W", rover.toString());
		
		rover.rotateLeft();
		assertEquals("0 0 S", rover.toString());
		
		rover.rotateLeft();
		assertEquals("0 0 E", rover.toString());
		
		rover.rotateLeft();
		assertEquals("0 0 N", rover.toString());
		
		rover.rotateRight();
		assertEquals("0 0 E", rover.toString());
		
		rover.rotateRight();
		assertEquals("0 0 S", rover.toString());
		
		rover.rotateRight();
		assertEquals("0 0 W", rover.toString());
		
		rover.rotateRight();
		assertEquals("0 0 N", rover.toString());
		
	}
	
	@Test
	public void testMarsLanding(){
		MarsLanding.setupMap("5 5");
		MarsLanding.setupNewRover("1 2 N");
		MarsLanding.moveRover("LMLMLMLMM");
		assertEquals("1 3 N", MarsLanding.rovers.get(0).toString());
		
		
		MarsLanding.setupNewRover("3 3 E");
		MarsLanding.moveRover("MMRMMRMRRM");
		assertEquals("5 1 E", MarsLanding.rovers.get(1).toString());
	}
}
