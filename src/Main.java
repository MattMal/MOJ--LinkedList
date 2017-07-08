import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		LinkedList<String> placesToVisit = new LinkedList<String>();
		// placesToVisit.add("Sydney");
		// placesToVisit.add("Melbourne");
		// placesToVisit.add("Brisbane");
		// placesToVisit.add("Perth");
		// placesToVisit.add("Canberra");
		// placesToVisit.add("Adelaide");
		// placesToVisit.add("Darwin");
		//
		// printList(placesToVisit);
		// placesToVisit.add(0, "Alice Springs");
		// printList(placesToVisit);
		addWithOrder(placesToVisit, "Sydney");
		addWithOrder(placesToVisit, "Melbourne");
		addWithOrder(placesToVisit, "Brisbane");
		addWithOrder(placesToVisit, "Perth");
		addWithOrder(placesToVisit, "Canberra");
		addWithOrder(placesToVisit, "Adelaide");
		addWithOrder(placesToVisit, "Darwin");
		addWithOrder(placesToVisit, "Montreal");

		printCities(placesToVisit);
		visit(placesToVisit);

	}

	private static void printCities(LinkedList<String> placesToVisitIn) {
		Iterator<String> i = placesToVisitIn.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

	}

	private static boolean addWithOrder(LinkedList<String> placesToVisitIn, String newCityIn) {
		ListIterator<String> i = placesToVisitIn.listIterator();
		while (i.hasNext()) {
			int compare = i.next().compareTo(newCityIn); // You create a value
															// of compare,
															// because everytime
															// you call .next(),
															// the pointer moves
			if (compare == 0) {
				System.out.println("City already exists");
				return false;
			} else if (compare > 0) {
				i.previous();
				i.add(newCityIn);
				return true;
			}
		}
		i.add(newCityIn);
		return true;
	}

	public static void visit(LinkedList<String> placesToVisitIn) {
		ListIterator<String> i = placesToVisitIn.listIterator(); // In the
																	// switch,
																	// the
																	// iterator
																	// is kept
																	// Live,
																	// thats how
																	// were able
																	// to move
																	// around
																	// contents
																	// of the
																	// list
																	// concurrently

		int option;
		Scanner scan = new Scanner(System.in);
		boolean quit = false;
		boolean goingForward = true;
		while (!quit) {

			option = scan.nextInt();
			switch (option) {
			case 1:
				quit = true;
				System.out.println("Vacation is over");
				break;
			case 2:

				if (i.hasNext()) {
					if (goingForward) {
						System.out.println("You are currently visiting " + i.next());
					} else if (!goingForward) {
						i.next();
						System.out.println("You are currently visiting " + i.next());
						goingForward = true;
					}
				}

				else {
					System.out.println("Vacation is over");
				}

				//
				// if (i.hasNext() == true && goingForward == true) {
				// System.out.println("You are currently visiting " + i.next());
				// } else if(i.hasNext() && goingForward==false){
				// i.next();
				// System.out.println("You are currently visiting " + i.next());
				// goingForward = false;
				// } else {
				// System.out.println("Vacation is over");
				//
				// }

				break;
			case 3:

				if (i.hasPrevious()) {
					if (!goingForward) {
						System.out.println("You are currently visiting " + i.previous());
					} else if (goingForward) {
						i.previous();
						System.out.println("You are currently visiting " + i.previous());
						goingForward = false;
					}
				} else {
					System.out.println("Vacation is over");
				}
				// if (i.hasPrevious() == true && goingForward == false) {
				// System.out.println("You are currently visiting
				// "+i.previous());
				// } else if(i.hasPrevious() == true && goingForward == true){
				// i.previous();
				// System.out.println("You are currently visiting
				// "+i.previous());
				// goingForward = false;
				// }else {
				// System.out.println("Vacation is over");
				//
				// }
				break;
			}
		}

	}

	// private static void printList(LinkedList<String> placeToVisitIn) {
	// Iterator<String> i = placeToVisitIn.iterator();
	// while (i.hasNext()) {
	// System.out.println("Now visiting " + i.next());
	// }
	// System.out.println("=======================");
	// }
	//
	// private static boolean addInOrder(LinkedList<String> placeToVisitIn,
	// String newCityIn) {
	// ListIterator<String> listStringIterator = placeToVisitIn.listIterator();
	//
	// while (listStringIterator.hasNext()) {
	// int compare = listStringIterator.next().compareTo(newCityIn);
	// if (compare == 0) {
	// System.out.println("THe city already exists in our list");
	// return false;
	//
	// } else if (compare > 0) {
	// listStringIterator.previous();
	// listStringIterator.add(newCityIn);
	// return true;
	// }
	//
	// }
	// listStringIterator.add(newCityIn);
	// return true;
	// }

}
