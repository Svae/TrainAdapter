package filter;

import java.util.ArrayList;

public class Foreach {

	public static void main(String[] args) {
		ArrayList<String> s = new ArrayList<>();
		s.add("h");
		s.add("e");
		s.add("i");
		s.stream().forEach(c -> System.out.println(c));
	}

}
