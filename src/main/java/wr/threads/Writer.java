package wr.threads;

import wr.resources.IBuffer;

public class Writer implements Runnable{
	private IBuffer b;
	public Writer(IBuffer b) {
	super();
	this.b = b;
	}
	@Override
	public void run() {
	// TODO Auto-generated method stub
	while(true) {
	// Проверяем, был ли получен сигнал на прерывание потока, если да, то выходим
	// из цикла и завершаем работу потока
	if (Thread.currentThread().isInterrupted()) break;
	//Обращаемся к ресурсу и записываем элемент в массив
	b.addElem();
	try {
	Thread.sleep(10);
	} catch (InterruptedException e) {
	// Проверяем, был ли получен сигнал на прерывание потока, если да, то
	//выходим из цикла и завершаем работу потока
	break;
	}
	}
	System.out.println("Писатель остановлен...");
	}
}
