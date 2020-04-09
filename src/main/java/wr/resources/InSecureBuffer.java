package wr.resources;

public class InSecureBuffer implements IBuffer {
	protected int n;
	protected int index=0;
	private int[] li;
	public InSecureBuffer(int n) {
	super();
	this.n = n;
	this.li = new int[n];
	}
	// ------------------------------------------------------
	// Операции с массивом
	protected void add() {
	li[index] = 0;
	System.out.println("Записали 0 в ячейку "+index);
	index++;
	}
	protected void read() {
	System.out.println("Считали "+li[index-1] +" из ячейки "+(index-1));
	index--;
	}
	//-----------------------------------------------------
	// Обрабатываются в потоках
	public void addElem() {
	add();
	System.out.println("*****");
	}
	public void readElem() {
	read();
	System.out.println("*****");
	}
}
