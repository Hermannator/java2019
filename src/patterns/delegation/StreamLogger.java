package patterns.delegation;

import java.io.IOException;
import java.io.OutputStream;

public class StreamLogger implements ILogger {
	OutputStream stream;
	String formatString;
	public StreamLogger(OutputStream stream) {
		this.stream = stream;
		formatString = "%s: %s (%s)";
	}
	public void log(String severity, String message, Exception exception) {
		String logMessage = String.format(formatString, severity, message, exception);
		byte[] bytes = logMessage.getBytes();
		try {
			stream.write(bytes);
			stream.flush();
			stream.close();
		}catch(IOException e) {}
	}
	public void setFormatString(String formatString) {
		this.formatString = formatString;
	}
}
