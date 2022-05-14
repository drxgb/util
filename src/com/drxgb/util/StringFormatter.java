package com.drxgb.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe abstrata respons�vel por tratar strings e fazer
 * suas devidas convers�es
 * @author Dr.XGB
 * @version 1.8.1
 */
public abstract class StringFormatter
{
	/**
	 * <p>Transforma um string, substituindo a primeira letra
	 * por uma mai�scula.</p>
	 * <p>Exemplo: <em>tomate</em> vira <em>Tomate</em>.</p>
	 * @param str String a ser transformada.
	 * @return Resultado da transforma��o.
	 */
	public static String capitalize(String str)
	{
		if (str.isEmpty() || str.isBlank() || str == null)
			return str;
		
		String s = ("" + str.charAt(0)).toUpperCase();
		return s + str.substring(1);
	}
	
	
	/**
	 * <p>Retira quaisquer espa�os em branco e quebras de linha.</p>
	 * <p><strong>Exemplo:</strong> <em>Alegria do Brasil</em> vira <em>AlegriadoBrasil</em></p>
	 * @param str String para ser minificada.
	 * @return Resultado da minifica��o.
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
	 * Converte os caracteres Unicode para o padr�o do Java.
	 * <p>Exemplo:</p>
	 * <code>\u0048</code> vira <code>H</code>.
	 * @param str A entrada do string a ser convertido.
	 * @return Sa�da do string com os caracteres Unicode substitu�dos.
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
