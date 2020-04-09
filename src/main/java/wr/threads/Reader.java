package wr.threads;

import wr.resources.IBuffer;

public class Reader implements Runnable {
	private IBuffer b; // ссылка на объект ресурса
	// Конструктор с нинициализацией
	public Reader(IBuffer b) {
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
	//Обращаемся к ресурсу и считываем элемент из массива
	b.readElem();
	try {
	Thread.sleep(10);
	} catch (InterruptedException e) {
	// Проверяем, был ли получен сигнал на прерывание потока, если да, то
	//выходим из цикла и завершаем работу потока
	break;
	}
	}
	System.out.println("Читатель остановлен...");
	}
}
