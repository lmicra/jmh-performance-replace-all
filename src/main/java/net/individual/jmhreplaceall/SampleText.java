package net.individual.jmhreplaceall;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;

public class SampleText {

	private static final Logger LOGGER = Logger.getLogger(SampleText.class.getName());

	private static final String FILENAME = "text01.txt";

	public static final String[] TEXT;

	static {
		String fileContents;
		try {
			fileContents = IOUtils.toString(SampleText.class.getClassLoader().getResourceAsStream(FILENAME), "UTF-8");
		} catch (IOException ex) {		
			LOGGER.log(Level.WARNING, "cannot read file: " + FILENAME, ex);
			fileContents = "";
		}
		TEXT = Pattern.compile("[\\.\\!\\s]+").split(fileContents);
	}
}
