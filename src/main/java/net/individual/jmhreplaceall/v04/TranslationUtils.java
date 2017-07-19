package net.individual.jmhreplaceall.v04;

import java.util.function.Function;

public class TranslationUtils {

	private static final String[][] TRANSLATIONS = {
		{"[äàáâåãã]", "a"},
		{"[éëèê]", "e"},
		{"[ìíîï]", "i"},
		{"[öôõòóø]", "o"},
		{"[üùúû]", "u"},
		{"[ÄÀÅÁÂÃÃ]", "A"},
		{"[ÈÉÊË]", "E"},
		{"[ÌÍÎÏ]", "I"},
		{"[ÖÔÕÒÓØ]", "O"},
		{"[ÜÙÚÛ]", "U"},
		{"[æ]", "ae"},
		{"[Æ]", "AE"},
		{"[ç]", "c"},
		{"[Ç]", "C"},
		{"[ñ]", "n"},
		{"[Ñ]", "N"},
		{"[ß]", "ss"}
	};

	public static String translate(final String strText) {
		String r = strText;
		for (String[] translation : TRANSLATIONS) {
			r = r.replaceAll(translation[0], translation[1]);
		}
		return r;
	}

	public static Function<String, String> translateFn = (strText) -> translate(strText);
}
