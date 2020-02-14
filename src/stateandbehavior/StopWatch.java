package stateandbehavior;

public class StopWatch {
	int ticks;
	int time = -1;
	int lapTime = -1;
	int lastLapTime = -1;
	boolean running = false;
	boolean hasStarted = false;
	boolean hasStopped = false;
	public boolean isStarted() {
		return hasStarted;
	}
	public boolean isStopped() {
		return hasStopped;
	}
	public int getTicks() {
		return ticks;
	}
	public int getTime() {
		return time;
	}
	public int getLapTime() {
		return lapTime;
	}
	public int getLastLapTime() {
		return lastLapTime;
	}
	public void tick(int ticks) {
		this.ticks += ticks;
		if(running) {
			time += ticks;
			lapTime += ticks;
		}
	}
	public void start() {
		running = true;
		hasStarted = true;
		time = 0;
		lapTime = 0;
	}
	public void lap() {
		lastLapTime = lapTime;
		lapTime = 0;
	}
	public void stop() {
		running = false;
		hasStopped = true;
		this.lap();
	}
	public String toString() {
		return "Ticks: " + this.getTicks() + "\nTime: " + this.getTime() + "\nLap time: " + this.getLapTime() + "\nLast lap time: " + this.getLastLapTime() + "\n";
	}
	public static void main(String[] args) {
		StopWatch s = new StopWatch();
		System.out.println(s);
		s.start();
		s.tick(1);
		System.out.println(s);
		s.lap();
		s.tick(2);
		System.out.println(s);
		s.stop();
		s.tick(3);
		System.out.println(s);
	}
}
