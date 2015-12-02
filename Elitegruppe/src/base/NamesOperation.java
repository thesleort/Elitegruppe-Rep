package base;

import java.util.ArrayList;

public class NamesOperation {

	public ArrayList<String> addName(ArrayList<String> names, String name) {
		names.add(name);
		return names;
	}
	public ArrayList<String> removeName(ArrayList<String> names, String name) {
		names.remove(name);
		return names;
	}
}