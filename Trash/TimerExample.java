package Trash;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TimerExample implements ActionListener {

	private String st = "Hello world";
	private int indexInString = 0;
	private Timer t;
	
	private void setTimer() {
		t = new Timer(1000, this);
		t.start();
	}
	
	public static void main(String[] args) throws InterruptedException {
		TimerExample example = new TimerExample();
		example.setTimer();
		Thread.sleep(50000);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(st.charAt(indexInString));
		indexInString++;
		if (indexInString >= st.length()) {
			t.stop();
		}
	}
}
