package net.individual.jmhreplaceall.v02;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TranslationUtils {

	private static final String TRANSLATION_MATRIX = "ä a,Ä A,ö o,Ö O,ü u,Ü U,ß ss,é e,ë e,è e,ê e,ô o,À A,Å A,Á A,Â A,Ç C,È E,É E,Ê E,Ë E,à a,á a,â a,å a,æ ae,ç c,Ô O,Ã A,ã a,Ã A,ã a,Ñ N,ñ n,Õ O,õ o,Æ AE,ò o,ó o,ø o,Ò O,Ó O,Ø O,ì i,í i,î i,Ì I,Í I,Î I,ù u,ú u,û u,Ù U,Ú U,ï i,Ï I";
	private static final String[][] TRANSLATE_TABLE = Arrays.asList(TRANSLATION_MATRIX.split(",")).stream().map(s -> s.split(" ")).collect(Collectors.toList()).toArray(new String[0][0]);

	public static String translate(String strText) {
		String result = strText;
		for (String[] translation : TRANSLATE_TABLE) {
			result = result.replace(translation[0], translation[1]);
		}
		return result;
	}

	public static Function<String, String> translateFn = (strText) -> translate(strText);
}
