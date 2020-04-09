package wr.resources;

public class MonitorSecureBuffer extends InSecureBuffer implements IBuffer{
	public MonitorSecureBuffer(int n) {
		super(n);
		// TODO Auto-generated constructor stub
		}
		public synchronized void addElem() {
		while (index==n)
		try {
		wait();
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		Thread.currentThread().interrupt();
		break;
		}
		if (index!=n) {
		add();
		if (index==1) notifyAll();
		}
		}
		public synchronized void readElem() {
		while (index==0)
		try {
		wait();
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		Thread.currentThread().interrupt();
		break;
		}
		if (index!=0) {
		read();
		if (index==(n-1)) notifyAll();
		}
		}
}
