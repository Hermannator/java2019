package interfaces;

import java.util.Comparator;

public class NamedComparator implements Comparator<Named> {
	public int compare(Named n1, Named n2) {
		int comparison1 = n1.getFamilyName().compareTo(n2.getFamilyName());
		if(comparison1 == 0) {
			return n1.getGivenName().compareTo(n2.getGivenName());
		}
		return comparison1;
	}
}
