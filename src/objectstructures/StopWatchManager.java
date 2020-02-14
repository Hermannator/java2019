package objectstructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StopWatchManager {
	Map<String, StopWatch> stopwatches = new HashMap<>();
	public StopWatch newStopWatch(String name) {
		StopWatch stopwatch = new StopWatch();
		stopwatches.put(name,stopwatch);
		return stopwatch;
	}
	public void removeStopWatch(String name) {
		stopwatches.remove(name);
	}
	public void tick(int ticks) {
		for(StopWatch stopwatch : this.getAllWatches()) {
			stopwatch.tick(ticks);
		}
	}
	public StopWatch getStopWatch(String name) {
		return stopwatches.get(name);
	}
	public Collection<StopWatch> getAllWatches() {
		Collection<StopWatch> allWatches = stopwatches.values();
		return allWatches;
	}
	public Collection<StopWatch> getStartedWatches(){
		Collection<StopWatch> startedWatches = new ArrayList<>();
		for(StopWatch stopwatch : this.getAllWatches()) {
			if(stopwatch.isStarted()) {
				startedWatches.add(stopwatch);
			}
		}
		return startedWatches;
	}
	public Collection<StopWatch> getStoppedWatches(){
		Collection<StopWatch> stoppedWatches = new ArrayList<>();
		for(StopWatch stopwatch : this.getAllWatches()) {
			if(stopwatch.isStopped()) {
				stoppedWatches.add(stopwatch);
			}
		}
		return stoppedWatches;
	}
}
