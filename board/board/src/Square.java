
public class Square {
	private int corrX;
	private int corrY;
	
	public Square(int corrX, int corrY) {
		this.corrX = corrX;
		this.corrY = corrY;
	}
	
	
	public void printSquare(){
		System.out.println("X: "+corrX+" Y: "+corrY);
	}

	public int getCorrX() {
		return corrX;
	}

	public void setCorrX(int corrX) {
		this.corrX = corrX;
	}

	public int getCorrY() {
		return corrY;
	}

	public void setCorrY(int corrY) {
		this.corrY = corrY;
	}
	
	

}
