package com.drxgb.util;

/**
 * Classe abstrata responsável por tratar strings e fazer
 * suas devidas conversões
 * @author Dr.XGB
 * @version 1.8
 */
public abstract class StringFormatter
{
	/**
	 * <p>Transforma um string, substituindo a primeira letra
	 * por uma maiúscula.</p>
	 * <p>Exemplo: <em>tomate</em> vira <em>Tomate</em>.</p>
	 * @param str A string a ser transformada.
	 * @return Resultado da transformação.
	 */
	public static String capitalize(String str)
	{
		if (str.isEmpty() || str.isBlank() || str == null)
			return str;
		
		String s = ("" + str.charAt(0)).toUpperCase();
		return s + str.substring(1);
	}
}
