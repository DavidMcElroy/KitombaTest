import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MarsLanding {

	// plateau max coords
	private static int maxX;
	private static int maxY;
	
	public static ArrayList<Rover> rovers = new ArrayList<Rover>();

	private static String inputFile;

	public static void main(String[] args) {
		if (args.length >0){
			inputFile = args[0];
		}else{
			inputFile = "input.txt";
		}
		List<String> file;
		try (Stream<String> stream = Files.lines(Paths.get(inputFile))) {

			file = stream.collect(Collectors.toList());
			String lineOne = file.get(0);
			setupMap(lineOne);
			file.remove(0);
			for (String line : file) {
				if (isNonNumeric(line)) {
					moveRover(line.toUpperCase());
				} else {
					setupNewRover(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		// write output to outputfile
		Path outputFile = Paths.get("outputFile.txt");
		try (BufferedWriter writer = Files.newBufferedWriter(outputFile)) {
			for(Rover rover: rovers){
				 writer.write(rover.toString()+"\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static void setupNewRover(String line) {
		rovers.add(new Rover(line , maxX, maxY));
	}


	public static void moveRover(String line) {
		char [] moves = line.toCharArray();
		for(char move: moves){
			switch(move){
			case('M'):
				rovers.get(rovers.size()-1).move();
				break;
			case('L'):
				rovers.get(rovers.size()-1).rotateLeft();				
				break;
			case('R'):
				rovers.get(rovers.size()-1).rotateRight();
				break;
			}
		}
	}


	private static boolean isNonNumeric(String line) {
		return line.matches("^[A-za-z]+$");
	}

	
	// splits the first line and sets up the max X and Y for the plateau.
	public static void setupMap(String lineOne) {
		String [] coords =lineOne.split(" ");
		maxX= Integer.parseInt(coords[0]);
		maxY= Integer.parseInt(coords[1]);
	}

	
	
}
