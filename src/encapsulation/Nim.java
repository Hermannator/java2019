package encapsulation;
import java.util.List;
import java.util.ArrayList;

public class Nim {
	private List<Integer> piles = new ArrayList<>();
	public Nim(int pileSize) {
		for(int i = 0; i < 3; i++) {
			piles.add(pileSize);
		}
	}
	public Nim() {
		this(10);
	}
	public void removePieces(int number,int targetPile) {
		if(this.isGameOver()) {
			throw new IllegalStateException("Cannot make move after game end.");
		}else {
			if(this.isValidMove(number,targetPile)) {
				piles.set(targetPile,getPile(targetPile) - number);
			}else {
				throw new IllegalArgumentException("Invalid move.");
			}
		}
	}
	public boolean isValidMove(int number, int targetPile) {
		if(this.isGameOver()) {
			return false;
		}else if (targetPile >= piles.size()) {
			return false;
		}else if(number > this.getPile(targetPile)){
			return false;
		}else if(number < 1) {
			return false;
		}
		return true;
	}
	public boolean isGameOver() {
		for(int i = 0; i < 3; i++) {
			if(this.getPile(i) == 0) {
				return true;
			}
		}
		return false;
	}
	public int getPile(int targetPile) {
		return piles.get(targetPile);
	}
	public String toString() {
		return("Pile 0: " + this.getPile(0) + "\nPile 1: " + this.getPile(1) + "\nPile 2: " + this.getPile(2) + "\n");
	}
	public static void main(String[] args) {
		Nim n = new Nim(8);
		n.removePieces(2,0);
		System.out.println(n);
		n.removePieces(8,2);
		System.out.println(n);
		n.removePieces(3,1);
		System.out.println(n);
	}
}
