package net.individual.jmhreplaceall.v01;

import java.util.function.Function;

public class TranslationUtils {

	public static String translate(String strText) {
		return strText.replaceAll("ä", "a").replaceAll("Ä", "A")
				.replaceAll("ö", "o").replaceAll("Ö", "O")
				.replaceAll("ü", "u").replaceAll("Ü", "U")
				.replaceAll("ß", "ss").replaceAll("é", "e")
				.replaceAll("ë", "e").replaceAll("è", "e")
				.replaceAll("ê", "e").replaceAll("ô", "o")
				.replaceAll("À", "A").replaceAll("Å", "A")
				.replaceAll("Á", "A").replaceAll("Â", "A")
				.replaceAll("Ç", "C").replaceAll("È", "E")
				.replaceAll("É", "E").replaceAll("Ê", "E")
				.replaceAll("Ë", "E").replaceAll("à", "a")
				.replaceAll("á", "a").replaceAll("â", "a")
				.replaceAll("å", "a").replaceAll("æ", "ae")
				.replaceAll("ç", "c").replaceAll("Ô", "O")
				.replaceAll("Ã", "A").replaceAll("ã", "a")
				.replaceAll("Ã", "A").replaceAll("ã", "a")
				.replaceAll("Ñ", "N").replaceAll("ñ", "n")
				.replaceAll("Õ", "O").replaceAll("õ", "o")
				.replaceAll("Æ", "AE").replaceAll("ò", "o")
				.replaceAll("ó", "o").replaceAll("ø", "o")
				.replaceAll("Ò", "O").replaceAll("Ó", "O")
				.replaceAll("Ø", "O").replaceAll("ì", "i")
				.replaceAll("í", "i").replaceAll("î", "i")
				.replaceAll("Ì", "I").replaceAll("Í", "I")
				.replaceAll("Î", "I").replaceAll("ù", "u")
				.replaceAll("ú", "u").replaceAll("û", "u")
				.replaceAll("Ù", "U").replaceAll("Ú", "U")
				.replaceAll("ï", "i").replaceAll("Ï", "I");
	}

	public static Function<String, String> translateFn = (strText) -> translate(strText);
}
