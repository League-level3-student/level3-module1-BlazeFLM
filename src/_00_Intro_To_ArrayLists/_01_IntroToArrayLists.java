package _00_Intro_To_ArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		// 1. Create an array list of Strings
		// Don't forget to import the ArrayList class
		ArrayList<String> stringArrList = new ArrayList<String>();
		// 2. Add five Strings to your list
		stringArrList.add("serdt");
		stringArrList.add("asdfg");
		stringArrList.add("gfkhh");
		stringArrList.add("aedht");
		stringArrList.add("fghkj");
		// 3. Print all the Strings using a standard for-loop
		for (int i = 0; i < stringArrList.size(); i++) {
			System.out.println(stringArrList.get(i));
		}
		// 4. Print all the Strings using a for-each loop
		for (String i : stringArrList) {
			System.out.println(i);
		}
		// 5. Print only the even numbered elements in the list.
		for (int i = 0; i < stringArrList.size(); i += 2) {
			System.out.println(stringArrList.get(i));
		}
		// 6. Print all the Strings in reverse order.
		for (int i = stringArrList.size() - 1; i >= 0; i--) {
			System.out.println(stringArrList.get(i));
		}
		// 7. Print only the Strings that have the letter 'e' in them.
		for (int i = 0; i < stringArrList.size(); i++) {
			if (stringArrList.get(i).contains("e")) {
				System.out.println(stringArrList.get(i));
			}
		}
	}
}
