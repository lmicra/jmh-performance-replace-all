package net.individual.jmhreplaceall.v16;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class TranslationUtils {

	private static final Map<Character, String> MAP;

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
		MAP = new HashMap<>();
		for (int i = MATRIX.length; i-- > 0;) {
			MAP.put(MATRIX[i][0].charAt(0), MATRIX[i][1]);
		}
	}

	public static String translate(final String strText) {
		StringBuilder sb = new StringBuilder();
		char[] strCharArray = strText.toCharArray();
		for (char c : strCharArray) {
			if (c < 127 || !MAP.containsKey(c)) {
				sb.append(c);
			} else {
				sb.append(MAP.get(c));
			}
		}
		return sb.toString();
	}

	public static Function<String, String> translateFn = (strText) -> translate(strText);
}
