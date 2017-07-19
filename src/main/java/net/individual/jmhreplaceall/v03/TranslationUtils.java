package net.individual.jmhreplaceall.v03;

import java.util.function.Function;

public class TranslationUtils {

	public static String translate(String strText) {
		return strText
				.replaceAll("[äàáâåãã]", "a")
				.replaceAll("[éëèê]", "e")
				.replaceAll("[ìíîï]", "i")
				.replaceAll("[öôõòóø]", "o")
				.replaceAll("[üùúû]", "u")
 				.replaceAll("[ÄÀÅÁÂÃÃ]", "A")
				.replaceAll("[ÈÉÊË]", "E")
				.replaceAll("[ÌÍÎÏ]", "I")
				.replaceAll("[ÖÔÕÒÓØ]", "O")
				.replaceAll("[ÜÙÚÛ]", "U")
				.replaceAll("[æ]", "ae").replaceAll("[Æ]", "AE")
				.replaceAll("[ç]", "c").replaceAll("[Ç]", "C")
				.replaceAll("[ñ]", "n").replaceAll("[Ñ]", "N")
				.replaceAll("[ß]", "ss");
	}

	public static Function<String, String> translateFn = (strText) -> translate(strText);
}
