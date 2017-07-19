package net.individual.jmhreplaceall.v11;

import java.util.function.Function;
import java.util.regex.Pattern;
import static net.individual.jmhreplaceall.TranslationUtilsTable.MATRIX;

public class TranslationUtils {

	private static final Pattern GLOBAL_PATTERN;
	private static final String FROM;
	private static final String[] TO;

	static {
		StringBuilder sb = new StringBuilder();
		int matrixLength = MATRIX.length;
		TO = new String[matrixLength];
		for (int i = 0; i < matrixLength; i++) {
			sb.append(MATRIX[i][0]);
			TO[i] = MATRIX[i][1];
		}
		FROM = sb.toString();
		GLOBAL_PATTERN = Pattern.compile("[" + FROM + "]");
	}

	public static String translate(final String strText) {
		if (!GLOBAL_PATTERN.matcher(strText).find()) {
			return strText;
		}
		StringBuilder sb = new StringBuilder();
		char[] strCharArray = strText.toCharArray();
		for (char c : strCharArray) {
			int indexOf = FROM.indexOf(c);
			sb.append(indexOf == -1 ? c : TO[indexOf]);
		}
		return sb.toString();
	}

	public static Function<String, String> translateFn = (strText) -> translate(strText);
}
