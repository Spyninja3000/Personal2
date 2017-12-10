// A Simple Text-Based Adventure Game made in Java
// By: Tejas Shah

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Adventure_Game {
	
	public static String random_item(ArrayList<String> list) {
		String random = list.get(new Random().nextInt(list.size()));
		return(random);
	}
	
	public static void print(String item) {
		System.out.println(item);
	}

	public static void main(String[] args) {
		
		boolean hold = true;
		
		int games = 0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Hello there! What's your name? ");
		String name = sc.nextLine();
		sc.nextLine();
		print("Hello there, " + name + "! Would you like to go on an Adventure?");
		String confirm = sc.nextLine();
		sc.nextLine();
		while(true) {
			if(!(confirm == "yes" || confirm == "no" || confirm == "y" || confirm == "n")) {
				System.out.println("Please only enter 'yes' or 'no'. ");
				confirm = sc.nextLine();
				sc.nextLine();
			} else {
				break;
			}
		}
			
		while(games != 7) {
			
			if(confirm == "yes" || confirm == "y" || confirm == "Y" || confirm == "Yes") {
				print("Perfect!");
			} else if(confirm == "no" || confirm == "n" || confirm == "N" || confirm == "No") {
				print("Aww... Okay then...");
				System.exit(0);
			}
			
			if(hold) {
				print("");
				print("You have three options: Sword, Shield, or Potion. The Sword reduces your opponent's life if his shield isn't up. ");
				print("You use one energy each time you use the sword. The Shield protects you from your opponent's sword. ");
				print("The Potion gives you energy to use the Sword. If the opponent uses the sword and you use the potion, you die! ");
				print("Good Luck!");
			}
			
		    int energy = 0;

		    int op_energy = 0;

		    int over_shield = 0;

		    int shield_durability = 7;

		    int sword_durability = 9;

		    int potion_durability = 12;
		    
		    while(true) {
		    		String opponent_move = null;
		    		if(op_energy == 0) {
		    			ArrayList<String> options = new ArrayList<String>();
		    			options.add("Shield");
		    			options.add("Potion");
		    			opponent_move = random_item(options);
		    		} else if(op_energy != 0) {
		    			ArrayList<String> options = new ArrayList<String>();
		    			options.add("Shield");
		    			options.add("Potion");
		    			options.add("Sword");
		    			opponent_move = random_item(options);
		    		}
		    		
		    		if(opponent_move == "Sword") {
		    			op_energy -= 1;
		    		}
		    		
		    		if(opponent_move == "Potion") {
		    			op_energy += 1;
		    		}
		    		
		    		print("");
		    		
		    		if(shield_durability == 0) {
		    			print("Your shield broke! You've used it too much! Because your shield is broken, your opponent");
		    			print("skips ahead and thrusts his sword into your face. GAME OVER");
		            		break;
		    		}
		    		
	            if(sword_durability == 0) {
	                print("Your sword broke! You've used it too much! Because your sword is broken, your opponent");
	                print("skips ahead and thrusts his sword into your face. GAME OVER");
	                break;
	            }
	            
	            if(potion_durability == 0) {
	            	print("You have run out of potion. Seeing this, your opponent");
	            	print("skips ahead and thrusts his sword into your face. GAME OVER");
	                break;
	            }
			    
	            String move = null;
	            if(over_shield != 5) {
	            		if(energy == 0) {
	            			print("What is your move? Please enter 'Shield', or 'Potion'. ");
	            			move = sc.nextLine();
	            			sc.nextLine();
	            			while(move != "Shield" && move != "Potion") {
	            				if(move == "Sword") {
	            					print("You are out of energy and can't use your sword! Please only enter 'Shield', or 'Potion'. ");
	    	            				move = sc.nextLine();
	    	            				sc.nextLine();
	            				} else {
	            					print("Please only enter 'Shield', or 'Potion'. ");
	            					move = sc.nextLine();
	            					sc.nextLine();
	            				}
	            			}
	            		} else if(energy != 0) {
	            			print("What is your move? Please enter 'Sword', 'Shield', or 'Potion'. ");
	            			move = sc.nextLine();
	            			sc.nextLine();
	            			while(move != "Sword" && move != "Shield" && move != "Potion") {
	            				print("Please only enter 'Sword', 'Shield', or 'Potion'. ");
		            			move = sc.nextLine();
		            			sc.nextLine();
	            			}
	            		}
	            } else if(over_shield==5) {
	                if(energy == 0) {
	                    move = "Potion";
	                    print("Since you have used your shield too many times in a row, and you are out of energy and");
	                    print("cannot use your sword, the only thing you could do was drink your Potion.");
	                } else if(energy != 0) {
	                    print("What is your move? Please enter 'Sword' or 'Potion'. ");
	                    	move = sc.nextLine();
	                    	sc.nextLine();
	                    while(move != "Sword" && move != "Shield" && move != "Potion") {
	                        if(move == "Shield") {
	                            print("You have used your shield too many times in a row! Please only enter 'Sword' or 'Potion'. ");
	                            move = sc.nextLine();
	                            sc.nextLine();
	                        } else {
	                        		print("Please only enter 'Sword' or 'Potion'. ");
	                        		move = sc.nextLine();
	                        		sc.nextLine();
	                        }
	                    }
	                }
	            }
	            
	            if(move == "Shield") {
	                over_shield += 1;
	                shield_durability -= 1;
	            }

	            if(move == "Sword") {
	                energy -= 1;
	                over_shield = 0;
	                sword_durability -= 1;
	            }

	            if(move == "Potion") {
	                energy += 1;
	                over_shield = 0;
	                potion_durability -= 1;
	            }

	            print("");
	            
	            print("You picked: " + move);
	            print("Your energy level now: " + energy);
	            print("Your opponent picked: " + opponent_move);

	            print("");
	            String charge = null;
	            if(energy == 10) {
	                print("Your energy level is at 10! With the massive amount of energy in your body, you jump up, do a flip, and slice your opponent clean in half. You Win!");
	                break;
	            } else if(energy == 5 || energy == 8) {
	                print("Your energy level is at " + energy + ". You can charge at your opponent and risk either victory or death. Please pick either 'Charge' or 'Stay'. ");
	                charge = sc.nextLine();
	                sc.nextLine();
	                while(charge != "Charge" && charge != "Stay") {
	                    print("Please either put in 'Charge' or 'Stay'. ");
	                    charge = sc.nextLine();
	                    sc.nextLine();
	                }
	                print("");
	                if(charge == "Charge") {
	                		ArrayList<String> chargelist = new ArrayList<String>();
	                    chargelist.add("Win");
	                    chargelist.add("Die");
	                    String answer = random_item(chargelist);
	                    if(answer == "Die") {
	                        print("You charge ahead, but the opponent parries your attack and slices your face clean. GAME OVER!");
	                        break;
	                    } else if(answer == "Win") {
	                        print("You charge ahead, catching your opponent off guard. You ram your sword straight into his heart, killing him! You Win!");
	                        break;
	                    }
	                } else if(charge == "Stay") {
	                    print("Safe Bet, not charging!");
	                    print("");
	                }
	            } 
	            
	            if(move == "Sword" && opponent_move == "Shield") {
	                print("You struck with your Sword, but your opponent blocked it!");
	            } else if(move == "Sword" && opponent_move == "Sword") {
	            		String deadlock = null;
	            		print("You both strike with your Sword, and you enter a Deadlock! Do you fall back or push on? Please enter 'Fall' or 'Push'. ");
	            		deadlock = sc.nextLine();
	            		sc.nextLine();
                    while(deadlock != "Fall" && deadlock != "Push") {
                        print("Please only enter either 'Push' or 'Fall'. ");
                        deadlock = sc.nextLine();
                        sc.nextLine();
                    }
                    ArrayList<String> deadlock_choices = new ArrayList<String>();
                    deadlock_choices.add("Fall");
                    deadlock_choices.add("Push");
                    String op_deadlock = random_item(deadlock_choices);
                    print("");
                    if(deadlock == "Push" && op_deadlock == "Fall") {
                        print("You pushed on while your opponent fell back. In one epic swoop, you slice him with your sword and claim victory. You Win!");
                        break;
                    } else if(deadlock == "Push" && op_deadlock == "Push") {
                        print("You try to push on, but your opponent jumps ahead and severs your head. GAME OVER!");
                        break;
                    } else if(deadlock == "Fall" && op_deadlock == "Fall") {
                        print("You both fall back! The deadlock is over!");
                    } else if(deadlock == "Fall" && op_deadlock == "Push") {
                        print("Your opponent pushed on and might have killed you if you had not fallen back. The deadlock is over!");
                    } print("");	            
	            } else if(move == "Sword" && opponent_move == "Potion") {
	                print("Bingo! While your opponent was taking a potion, you struck 'em with your sword, killing him! You Win!");
	                break;	            
	            } else if(move == "Shield" && opponent_move == "Shield") {
	                print("Cowards! You both used your shield!");
	            } else if(move == "Shield" && opponent_move == "Sword") {
	                print("Your opponent went in for the kill with his sword, but you blocked it with your shield!");
	            } else if(move == "Shield" && opponent_move == "Potion") {
	                print("While you had your shield up, your opponent took a sip of his potion!");
	            } else if(move == "Potion" && opponent_move == "Shield") {
	                print("While your opponent used his shield, you drank some of your potion!");
	            } else if(move == "Potion" && opponent_move == "Sword") {
	                print("Alas! While you were drinking your potion, your opponent killed you with his Sword! GAME OVER!");
	                break;
	            } else if(move == "Potion" && opponent_move == "Potion") {
	                print("Whew! This fight is tiring! You both took a swig of your potion!");
	            }
	          
	    
		    }
		    
		    hold = false;
		    games += 1;
		    print("");
		    print("Thanks for playing. Would you like to go on another adventure?");
		    print("Please only enter 'yes' or 'no'. ");
			confirm = sc.nextLine();
			sc.nextLine();
			while(confirm != "yes" && confirm != "no" && confirm != "y" && confirm != "n") {
				print("I had one rule... Only 'yes' or 'no' please.");
				confirm = sc.nextLine();
				sc.nextLine();
			}
			
		    print("");
		}
		
		print("Okay, enough is enough, " + name + ". You have played a total of seven games, and while I appreciate the dedication, ");
		print("I don't think that's very healthy. Boredom can lead us to do weird things, and you my friend appear to be SUPER BORED.");
		print("Get off the computer, stop playing 1-Dimensional Text-Based Java games created by 14-year olds, and go outside.");
		System.exit(0);
		
	}

}
