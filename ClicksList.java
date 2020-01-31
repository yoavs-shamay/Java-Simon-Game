import java.util.*;

public class ClicksList {
	private LinkedList<Integer> list;
	private Random random;
	public ClicksList() {
		list = new LinkedList<Integer>();
		random = new Random();
	}
	public void addColor() {
		int num = random.nextInt(4) + 1;
		list.add(num);
	}
	public ListIterator<Integer> iterator() {
		return list.listIterator();
	}
	public LinkedList<Integer> getList() {
		return list;
	}
	
}
