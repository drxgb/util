package com.drxgb.util;

/**
 * Classe abstrata responsável por tratar strings e fazer
 * suas devidas conversões
 * @author Dr.XGB
 * @version 1.8.1
 */
public abstract class StringFormatter
{
	/**
	 * <p>Transforma um string, substituindo a primeira letra
	 * por uma maiúscula.</p>
	 * <p>Exemplo: <em>tomate</em> vira <em>Tomate</em>.</p>
	 * @param str String a ser transformada.
	 * @return Resultado da transformação.
	 */
	public static String capitalize(String str)
	{
		if (str.isEmpty() || str.isBlank() || str == null)
			return str;
		
		String s = ("" + str.charAt(0)).toUpperCase();
		return s + str.substring(1);
	}
	
	
	/**
	 * <p>Retira quaisquer espaços em branco e quebras de linha.</p>
	 * <p><strong>Exemplo:</strong> <em>Alegria do Brasil</em> vira <em>AlegriadoBrasil</em></p>
	 * @param str String para ser minificada.
	 * @return Resultado da minificação.
	 */
	public static String minify(String str)
	{
		if (str.isEmpty() || str.isBlank() || str == null)
			return str;
		
		String out = "";
		for (int i = 0; i < str.length(); ++i)
		{
			char c = str.charAt(i);
			if (c != 0x0A && c != 0x0D && c != 0x20)
				out += c;
		}
		return out;
	}
}
