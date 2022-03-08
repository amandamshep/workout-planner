package workout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class planner {
	
	private static ArrayList<String> glutesAndHams  = new ArrayList<String>(
			Arrays.asList("Dead Lifts",
					"Glute Bridges",
					"Good Mornings"));;
	private static ArrayList<String> quads  = new ArrayList<String>(
			Arrays.asList("Squats",
					"Lunges",
					"Step ups",
					"Cable TKE"));
	
	private static ArrayList<String> push  = new ArrayList<String>(
			Arrays.asList("Bench Press",
					"Overhead Press",
					"Push ups",
					"Tricep Press"));
	
	private static ArrayList<String> pull  = new ArrayList<String>(
			Arrays.asList("Pullups",
					"Bent Over Rows",
					"Bicep Curls",
					"Inverted Rows",
					"Rear Delt Flies",
					"Shoulder Raises"));
	static HashMap<String, ArrayList<String>> variations;
	
	
	public static void main(String[] args)
	{
	
		variations = generateVariations();
		
		System.out.println("Enter 1 for lower body, 2 for upper body, 3 for full body: ");
		Scanner input = new Scanner (System.in);
		int split = 0;
		
		try {
			split = input.nextInt();
		} catch( Exception e ){
			System.out.println("Invalid selection. ");
			input.close();
			return;
		}
		
		input.close();
		
		if(split != 1 && split != 2 && split != 3) {
			System.out.println("Invalid selection. ");
			return;
		}
		
		ArrayList<String> blocks = generateBlock(split);
		reportBlock(blocks);
		
	}
	
	//Select unique moves to construct the blocks
	private static ArrayList<String> generateBlock(int area){
		
		Random rand = new Random();
		String first = "";
		String second = "";
		String third = "";
		String fourth = "";
		
		if(area == 1) {
			 first = glutesAndHams.get(rand.nextInt(3));
			 third = glutesAndHams.get(rand.nextInt(3));
			while(first == third) {
				third = glutesAndHams.get(rand.nextInt(3));
			}
			
			 second = quads.get(rand.nextInt(3));
			 fourth = quads.get(rand.nextInt(3));
			while(second == fourth) {
				fourth = quads.get(rand.nextInt(3));
			}
		} else if(area == 2) {
			 first = push.get(rand.nextInt(3));
			 third = push.get(rand.nextInt(3));
			while(first == third) {
				third = push.get(rand.nextInt(3));
			}
			
			 second = pull.get(rand.nextInt(3));
			 fourth = pull.get(rand.nextInt(3));
			while(second == fourth) {
				fourth = pull.get(rand.nextInt(3));
			}
		} else {
			 first = glutesAndHams.get(rand.nextInt(3));
			 third = quads.get(rand.nextInt(3));		
			 second = push.get(rand.nextInt(3));
			 fourth = pull.get(rand.nextInt(3));
		}
		
		first = first + " " + getVariation(first);
		second = second + " " + getVariation(second);
		third = third + " " + getVariation(third);
		fourth = fourth + " " + getVariation(fourth);
		
		ArrayList<String> blocks  = new ArrayList<String>(
				Arrays.asList(first, second, third, fourth));
		
		return blocks;
	}
	
	private static HashMap<String, ArrayList<String>> generateVariations(){
		HashMap<String, ArrayList<String>> v = new HashMap<String, ArrayList<String>>();
		

		v.put("Dead Lifts",  new ArrayList<String>(
				Arrays.asList("Romanian", "Single Legged (L & R)", "Staggered (L & R)")));		
		v.put("Glute Bridges",  new ArrayList<String>(
				Arrays.asList("Single Legged (L & R)", "On a Decline", "Classic")));
		v.put("Good Mornings",  new ArrayList<String>(
				Arrays.asList("Kneeling", "Standing")));
		v.put("Cable TKE",  new ArrayList<String>(
				Arrays.asList("Classic")));
		v.put("Step ups",  new ArrayList<String>(
				Arrays.asList("Classic (L & R)")));
		v.put("Lunges",  new ArrayList<String>(
				Arrays.asList("Side (L & R)", "Bulgarian (L & R)", "Walking","Static (L & R)", "Curtsy (L & R)")));
		v.put("Squats",  new ArrayList<String>(
				Arrays.asList("Pistol (L & R)", "Sumo", "Jumping","Goblet")));
		v.put("Bench Press",  new ArrayList<String>(
				Arrays.asList("Incline Barbell", "Incline Dumbbell", "Barbell","Dumbbell")));
		v.put("Overhead Press",  new ArrayList<String>(
				Arrays.asList("Seated Barbell", "Seated Dumbbell", "Standing Barbell","Standing Dumbbell")));
		v.put("Push ups",  new ArrayList<String>(
				Arrays.asList("On Knees", "Incline", "Classic")));
		v.put("Tricep Press",  new ArrayList<String>(
				Arrays.asList("Sitting", "Standing")));
		v.put("Pullups",  new ArrayList<String>(
				Arrays.asList("Classic")));
		v.put("Bicep Curls",  new ArrayList<String>(
				Arrays.asList("Barbell", "Dumbbell (L & R)")));
		v.put("Bent Over Rows",  new ArrayList<String>(
				Arrays.asList("Barbell", "Dumbbell (L & R)")));								
		v.put("Inverted Rows",  new ArrayList<String>(
				Arrays.asList("Classic")));
		v.put("Rear Delt Flies",  new ArrayList<String>(
				Arrays.asList("Classic")));
		v.put("Shoulder Raises",  new ArrayList<String>(
				Arrays.asList("Front", "Side")));

		return v;
	}
	
	private static String getVariation(String base) {
		Random rand = new Random();	
		ArrayList<String> v = variations.get(base);	
		return v.get(rand.nextInt(v.size()));
	}
	
	private static void reportBlock(ArrayList<String> blocks) {
		System.out.println();
		System.out.println("Block 1: Repeat 4 times");
		System.out.println("12 reps: "  + blocks.get(0));
		System.out.println("12 reps: "  + blocks.get(1));
		
		System.out.println();
		System.out.println("Block 2: Repeat 4 times");
		System.out.println("12 reps: "  + blocks.get(2));
		System.out.println("12 reps: "  + blocks.get(3));
		
	}
}
