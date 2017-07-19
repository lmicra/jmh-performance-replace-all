package net.individual.jmhreplaceall.v09;

import java.util.function.Function;
import org.apache.commons.lang3.StringUtils;

public class TranslationUtils {

	public static String translate(final String strText) {
		return StringUtils
				.stripAccents(strText)
				.replace("ß", "ss")
				.replaceAll("Æ", "AE")
				.replaceAll("æ", "ae")
				.replaceAll("Ø", "O")
				.replaceAll("ø", "o")
				;
	}

	public static Function<String, String> translateFn = (strText) -> translate(strText);
}
