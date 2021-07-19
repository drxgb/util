package com.drxgb.util;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Classe abstrata responsável por receber e tratar dados para
 * torná-los em uma {@code String}.
 * @author Dr.XGB
 * @version 1.0
 */
public abstract class StringParser
{
	/**
	 * <p>Lê os dados de um arquivo e o transforma em string.</p>
	 * <p>A leitura é realizada em uma tripa de bytes e se encerra até
	 * chegar ao fim do arquivo ou quando encontrar um caractere nulo (0x00).</p>
	 * @param reader Instância de {@code InputStreamReader}.
	 * @return O resultado da leitura do arquivo.
	 * @throws IOException
	 */
	public static String fromInputStreamReader(InputStreamReader reader) throws IOException
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
}
