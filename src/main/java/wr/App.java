package wr;


import java.util.ArrayList;
import java.util.List;

import wr.resources.IBuffer;
import wr.resources.InSecureBuffer;
import wr.resources.LockSemSecureBuffer;
import wr.resources.MonitorSecureBuffer;
import wr.threads.Reader;
import wr.threads.Writer;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Можно использовать конструкторы любой реализации ресурса
		IBuffer b = new MonitorSecureBuffer(8);
		// Создаем читателей и писателей
		List<Thread> lt = new ArrayList<>();
		for (int i=0;i<3;i++) lt.add(new Thread(new Writer(b)));
		for (int i=0;i<1;i++) lt.add(new Thread(new Reader(b)));
		//Стартуем читателей и писателей
		for (Thread thread : lt) {
		thread.start();
		}
		//Блокируем главный поток
		try {
		Thread.sleep(3000); // блокируем поток на 3000 мс = 3 с
		} catch (InterruptedException e) {}
		//Останавливаем потоки. Остановка приводит к изменению значения флага (private поле
		// типа boolean), значение которого можно проверить с помощью метода isInterrupted()
		// см. содержимое методов run() в классах потоках. Если на момент прерывания потока,
		//он оказался заблокированным, например с помощью sleep(), wait(), то jvm инициирует
		//InterruptedException и необходимо его обработать корректно в соответствующем catch
		// блоке
		for (Thread thread : lt) {
		thread.interrupt();
		}
	}

}
