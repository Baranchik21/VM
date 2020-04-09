package wr.resources;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSemSecureBuffer extends InSecureBuffer implements IBuffer{
	private final Lock l = new ReentrantLock();
	private final Semaphore free = new Semaphore(n);
	private final Semaphore full = new Semaphore(n);
	public LockSemSecureBuffer(int n) {
	super(n);
	// TODO Auto-generated constructor stub
	full.release(n);
	}
	public void addElem() {
	try {
	free.acquire();
	} catch (InterruptedException e1) {
	// TODO Auto-generated catch block
	//e1.printStackTrace();
	Thread.currentThread().interrupt();
	}
	l.lock();
	try {
	add();
	}
	catch (Exception e) {}
	finally {
	l.unlock();
	}
	full.release();
	}
	//-----------------------------------
	public void readElem() {
	try {
	full.acquire();
	} catch (InterruptedException e1) {
	// TODO Auto-generated catch block
	//e1.printStackTrace();
	Thread.currentThread().interrupt();
	}
	l.lock();
	try {
	read();
	}
	catch (Exception e) {}
	finally {
	l.unlock();
	}
	free.release();
	}
	
}
