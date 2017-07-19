package net.individual.jmhreplaceall.v17;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class TranslationUtils {

	private static final Map<Character, String> MAP = new HashMap<Character, String>() {
		{
			put('ä', "a");
			put('Ä', "A");
			put('ö', "o");
			put('Ö', "O");
			put('ü', "u");
			put('Ü', "U");
			put('ß', "ss");
			put('é', "e");
			put('ë', "e");
			put('è', "e");
			put('ê', "e");
			put('ô', "o");
			put('À', "A");
			put('Å', "A");
			put('Á', "A");
			put('Â', "A");
			put('Ç', "C");
			put('È', "E");
			put('É', "E");
			put('Ê', "E");
			put('Ë', "E");
			put('à', "a");
			put('á', "a");
			put('â', "a");
			put('å', "a");
			put('æ', "ae");
			put('ç', "c");
			put('Ô', "O");
			put('Ã', "A");
			put('ã', "a");
			put('Ã', "A");
			put('ã', "a");
			put('Ñ', "N");
			put('ñ', "n");
			put('Õ', "O");
			put('õ', "o");
			put('Æ', "AE");
			put('ò', "o");
			put('ó', "o");
			put('ø', "o");
			put('Ò', "O");
			put('Ó', "O");
			put('Ø', "O");
			put('ì', "i");
			put('í', "i");
			put('î', "i");
			put('Ì', "I");
			put('Í', "I");
			put('Î', "I");
			put('ù', "u");
			put('ú', "u");
			put('û', "u");
			put('Ù', "U");
			put('Ú', "U");
			put('ï', "i");
			put('Ï', "I");
		}
	};

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
