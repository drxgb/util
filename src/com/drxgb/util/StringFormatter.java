package com.drxgb.util;

/**
 * Classe abstrata respons�vel por tratar strings e fazer
 * suas devidas convers�es
 * @author Dr.XGB
 * @version 1.8
 */
public abstract class StringFormatter
{
	/**
	 * <p>Transforma um string, substituindo a primeira letra
	 * por uma mai�scula.</p>
	 * <p>Exemplo: <em>tomate</em> vira <em>Tomate</em>.</p>
	 * @param str A string a ser transformada.
	 * @return Resultado da transforma��o.
	 */
	public static String capitalize(String str)
	{
		if (str.isEmpty() || str.isBlank() || str == null)
			return str;
		
		String s = ("" + str.charAt(0)).toUpperCase();
		return s + str.substring(1);
	}
}
