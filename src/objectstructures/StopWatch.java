package objectstructures;

public class StopWatch {
	private int ticks;
	private int time = -1;
	private int lapTime = -1;
	private int lastLapTime = -1;
	private boolean running = false;
	private boolean hasStarted = false;
	private boolean hasStopped = false;
	public boolean isRunning() {
		return running;
	}
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
}