import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// A Pokemon Namer ~ By: Tejas Shah
// Based on an algorithm found on Reddit (you Redditors are complete nerds)

public class Pokemon_namer {
	
	public static ArrayList<Character> StrToArray(String str) {
		ArrayList<Character> charList = new ArrayList<Character>();
		for(int i = 0; i < str.length(); i++) {
			charList.add(str.charAt(i));
		}
		return charList;
	}
	
	public static void print(String item) {
		System.out.println(item);
	}
	
	public static void blankln() {
		System.out.println("");
	}
	
	public static boolean IsAlpha(String rawstr) {
		String str = rawstr.toLowerCase();
		ArrayList<Character> strlist = StrToArray(str);
		
		List<Character> letters = Arrays.asList(new Character[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'});
		
		Iterator<Character> striter = strlist.iterator();
		while(striter.hasNext()) {
			char chariter = striter.next();
			if(!(letters.contains(chariter))) {
				return(false);
			}
		}
		return(true);
	}

	public static String pokemonify(String rawhuman_name) {
		
		String human_name = rawhuman_name.toLowerCase();
		ArrayList<Character> name_list = StrToArray(human_name);
		ArrayList<String> pokemon_name_list = new ArrayList<String>();
		Iterator<Character> humaniter = name_list.iterator();
		
		while(humaniter.hasNext()) {
			char item = humaniter.next();
	        if(item == 'a') {
	            pokemon_name_list.add("PI");
	        } else if(item == 'b') {
	            pokemon_name_list.add("MON");
	        } else if(item == 'c') {
	            pokemon_name_list.add("FLA");
	        } else if(item == 'd') {
	            pokemon_name_list.add("LU");
	        } else if(item == 'e') {
	            pokemon_name_list.add("SA");
	        } else if(item == 'f') {
	            pokemon_name_list.add("ME");
	        } else if(item == 'g') {
	            pokemon_name_list.add("AR");
	        } else if(item == 'h') {
	            pokemon_name_list.add("KA");
	        } else if(item == 'i') {
	            pokemon_name_list.add("GLU");
	        } else if(item == 'j') {
	            pokemon_name_list.add("CHU");
	        } else if(item == 'k') {
	            pokemon_name_list.add("MAN");
	        } else if(item == 'l') {
	            pokemon_name_list.add("KAR");
	        } else if(item == 'm') {
	            pokemon_name_list.add("SON");
	        } else if(item == 'n') {
	            pokemon_name_list.add("TU");
	        } else if(item == 'o') {
	            pokemon_name_list.add("MUS");
	        } else if(item == 'p') {
	            pokemon_name_list.add("REG");
	        } else if(item == 'q') {
	            pokemon_name_list.add("PA");
	        } else if(item == 'r') {
	            pokemon_name_list.add("KLA");
	        } else if(item == 's') {
	            pokemon_name_list.add("SE");
	        } else if(item == 't') {
	            pokemon_name_list.add("DOR");
	        } else if(item == 'u') {
	            pokemon_name_list.add("SUN");
	        } else if(item == 'v') {
	            pokemon_name_list.add("AS");
	        } else if(item == 'w') {
	            pokemon_name_list.add("MO");
	        } else if(item == 'x') {
	            pokemon_name_list.add("GE");
	        } else if(item == 'y') {
	            pokemon_name_list.add("TRON");
	        } else if(item == 'z') {
	            pokemon_name_list.add("ZU");
	        }
		}
		
		String pokename = String.join("", pokemon_name_list);
		
		return(pokename);
	}
	
	public static void main(String[] args) {
		
		Boolean hold = true;
		while(true) {
			@SuppressWarnings("resource") // Don't worry about this; It's just to counteract Eclipse's annoyingness
			Scanner askname = new Scanner(System.in);
			String human_name;
			if(hold) {
				print("Hello! This is a program that turns your name into a pokemon name! What's your name? ");
				human_name = askname.next();	
			} else {
				print("Want to do another one? Enter it in! Or you can just leave... *sniffle* ");
				human_name  = askname.next();
			}
			
			while(!(IsAlpha(human_name))) {
				print("That's not a name! Real Letters only, please! ");
				human_name = askname.next();
			}
			
			print("Alright, " + human_name + ", Let's turn you into a pokemon!");
			
			String poke_name = pokemonify((String) human_name);
			
			print("Your pokemon name is: " + poke_name + "!");
			blankln();
			
			hold = false;
		}
		// print("Okay... that's *sniffle* fine... Have a ... *sniffle* nice day... ");
		// System.exit(1738);
	}
}
