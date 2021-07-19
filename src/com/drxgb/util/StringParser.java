package com.drxgb.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * Classe abstrata respons�vel por receber e tratar dados para
 * torn�-los em uma {@code String}.
 * @author Dr.XGB
 * @version 1.0
 */
public abstract class StringParser
{
	/**
	 * <p>L� os dados de um arquivo e o transforma em string.</p>
	 * <p>A leitura � realizada em uma tripa de bytes e se encerra at�
	 * chegar ao fim do arquivo ou quando encontrar um caractere nulo (0x00).</p>
	 * @param reader Inst�ncia de {@code Reader}.
	 * @return O resultado da leitura do arquivo.
	 * @throws IOException
	 */
	public static String fromReader(Reader reader) throws IOException
	{
		String str = "";
		int ch = 0;
		do
		{
			ch = reader.read();
			if (ch != 0)
				str += (char) ch;
		} while (ch != 0 && ch != -1);
		return str;
	}
	
	/**
	 * <p>L� os dados de um arquivo e o transforma em string.</p>
	 * <p>A leitura � realizada em uma tripa de bytes e se encerra at�
	 * chegar ao fim do arquivo ou quando encontrar um caractere nulo (0x00).</p>
	 * @param reader Inst�ncia de {@code InputStream}.
	 * @return O resultado da leitura do arquivo.
	 * @throws IOException
	 */
	public static String fromInputStream(InputStream is) throws IOException
	{
		String str = "";
		int ch = 0;
		do
		{
			ch = is.read();
			if (ch != 0)
				str += (char) ch;
		} while (ch != 0 && ch != -1);
		return str;
	}
	
	
	/**
	 * L� os dados de um arranjo de caracteres e gera uma string.
	 * @param ch Cadeia de caracteres.
	 * @return O conet�do da cadeira de caracteres em um tipo {@code String}
	 */
	public static String fromCharArray(char[] ch)
	{
		String str = "";
		for (char c : ch)
			str += c;
		return str;
	}
}
