package patterns.delegation;

public class DistributingLogger implements ILogger {
	ILogger errorLogger, warningLogger, infoLogger;
	public DistributingLogger(ILogger errorLogger, ILogger warningLogger, ILogger infoLogger) {
		this.errorLogger = errorLogger;
		this.warningLogger = warningLogger;
		this.infoLogger = infoLogger;
	}
	public void log(String severity, String message, Exception exception) {
		if(severity == ERROR) {
			errorLogger.log(severity, message, exception);
		}else if(severity == WARNING) {
			warningLogger.log(severity, message, exception);
		}else if(severity == INFO) {
			infoLogger.log(severity, message, exception);
		}
	}
	public void setLogger(String severity, ILogger logger) {
		if(severity == ERROR) {
			errorLogger = logger;
		}else if(severity == WARNING) {
			warningLogger = logger;
		}else if(severity == INFO) {
			infoLogger = logger;
		}
	}
}
