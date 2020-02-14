package patterns.delegation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringLogger implements ILogger {
	List<String> severities;
	ILogger logger;
	public FilteringLogger(ILogger logger, String... severities) {
		this.logger = logger;
		this.severities = new ArrayList<String>(Arrays.asList(severities));
	}
	public void log(String severity, String message, Exception exception) {
		if(isLogging(severity)) {
			logger.log(severity, message, exception);
		}
	}
	public boolean isLogging(String severity) {
		return severities.contains(severity);
	}
	public void setIsLogging(String severity, boolean value) {
		if(isLogging(severity)) {
			if(!value) {
				severities.remove(severities.indexOf(severity));
			}
		}else {
			if(value) {
				severities.add(severity);
			}
		}
	}
}
