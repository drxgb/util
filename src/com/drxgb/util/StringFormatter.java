package com.drxgb.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	
	/**
	 * Converte os caracteres Unicode para o padrão do Java.
	 * <p>Exemplo:</p>
	 * <code>\u0048</code> vira <code>H</code>.
	 * @param str A entrada do string a ser convertido.
	 * @return Saída do string com os caracteres Unicode substituídos.
	 */
	public static String unescape(String str)
	{
		Pattern p = Pattern.compile("(\\\\u[0-9A-Fa-f]+)");
		Matcher m = p.matcher(str);		
		for (int i = 0; m.find(); ++i)
		{
			String group = m.group(i);
			int hex = Integer.parseInt(group.substring(2), 16);
			str = str.replace(group, "" + (char) hex);
		}
		return str;
	}
}
