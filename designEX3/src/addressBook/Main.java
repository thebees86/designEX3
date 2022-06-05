package addressBook;

public class Main {
	public static void main(String args[]) {
		Book b = new Book();
		b.add("john", 8157800857L, 8157882783L, 8002930234L);
		b.add("tyler", 1928384928L, 4442932044L);
		b.add(1292384859L, "becky","hansel","gretel");
		System.out.println(b.getPeople());
		System.out.println(b.getNumbers());
	}
}
