package net.individual.jmhreplaceall.v13;

import java.util.function.Function;
import java.util.regex.Pattern;

public class TranslationUtils {

	private static final Pattern GLOBAL_PATTERN;
	private static final char[] FROM;
	private static final String[] TO;
	private static final int LENGTH;

	static {
		final String[][] MATRIX = new String[][]{
			{"ä", "a"},
			{"Ä", "A"},
			{"ö", "o"},
			{"Ö", "O"},
			{"ü", "u"},
			{"Ü", "U"},
			{"ß", "ss"},
			{"é", "e"},
			{"ë", "e"},
			{"è", "e"},
			{"ê", "e"},
			{"ô", "o"},
			{"À", "A"},
			{"Å", "A"},
			{"Á", "A"},
			{"Â", "A"},
			{"Ç", "C"},
			{"È", "E"},
			{"É", "E"},
			{"Ê", "E"},
			{"Ë", "E"},
			{"à", "a"},
			{"á", "a"},
			{"â", "a"},
			{"å", "a"},
			{"æ", "ae"},
			{"ç", "c"},
			{"Ô", "O"},
			{"Ã", "A"},
			{"ã", "a"},
			{"Ã", "A"},
			{"ã", "a"},
			{"Ñ", "N"},
			{"ñ", "n"},
			{"Õ", "O"},
			{"õ", "o"},
			{"Æ", "AE"},
			{"ò", "o"},
			{"ó", "o"},
			{"ø", "o"},
			{"Ò", "O"},
			{"Ó", "O"},
			{"Ø", "O"},
			{"ì", "i"},
			{"í", "i"},
			{"î", "i"},
			{"Ì", "I"},
			{"Í", "I"},
			{"Î", "I"},
			{"ù", "u"},
			{"ú", "u"},
			{"û", "u"},
			{"Ù", "U"},
			{"Ú", "U"},
			{"ï", "i"},
			{"Ï", "I"}
		};
		LENGTH = MATRIX.length;
		FROM = new char[LENGTH];
		TO = new String[LENGTH];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < LENGTH; i++) {
			sb.append(MATRIX[i][0]);
			FROM[i] = MATRIX[i][0].charAt(0);
			TO[i] = MATRIX[i][1];
		}
		GLOBAL_PATTERN = Pattern.compile("[" + sb.toString() + "]");
	}

	private static int indexOf(char c) {
		for (int i = LENGTH - 1; i >= 0; i--) {
			if (FROM[i] == c) {
				return i;
			}
		}
		return -1;
	}

	public static String translate(final String strText) {
		if (!GLOBAL_PATTERN.matcher(strText).find()) {
			return strText;
		}
		StringBuilder sb = new StringBuilder();
		char[] strCharArray = strText.toCharArray();
		for (char c : strCharArray) {
			if (c < 127) {
				sb.append(c);
				continue;
			}
			int indexOf = indexOf(c);
			if (indexOf == -1) {
				sb.append(c);
				continue;
			}
			sb.append(TO[indexOf]);
		}
		return sb.toString();
	}

	public static Function<String, String> translateFn = (strText) -> translate(strText);
}
