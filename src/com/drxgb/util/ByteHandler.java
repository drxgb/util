package com.drxgb.util;

/**
 * Classe abstrata responsável por converter número em tripa de bytes.
 * @author Dr.XGB
 * @version 1.0
 */
public abstract class ByteHandler
{
	/**
	 * Converte um valor do tipo {@code Long} para uma tripa de bytes.
	 * @param n O valor numérico a ser convertido
	 * @return Uma tripa de bytes correspendente ao valor dado por argumento.
	 */
	public static byte[] getBytes(Long n)
	{
		return parseByteArray(n, Long.BYTES);
	}
	
	
	/**
	 * Converte um valor do tipo {@code Integer} para uma tripa de bytes.
	 * @param n O valor numérico a ser convertido
	 * @return Uma tripa de bytes correspendente ao valor dado por argumento.
	 */
	public static byte[] getBytes(Integer n)
	{
		return parseByteArray(n.longValue(), Integer.BYTES);
	}
	
	
	/**
	 * Converte uma tripa de bytes para um valor do tipo {@code Long}.
	 * @param b Conjunto de bytes a ser convertido.
	 * @return Um valor do tipo {@code Long}.
	 */
	public static Long getLong(byte[] b)
	{
		return parseNumber(0L, b, Long.BYTES);
	}
	
	
	/**
	 * Converte uma tripa de bytes para um valor do tipo {@code Integer}.
	 * @param b Conjunto de bytes a ser convertido.
	 * @return Um valor do tipo {@code Integer}.
	 */
	public static Integer getInteger(byte[] b)
	{
		return parseNumber(0L, b, Integer.BYTES).intValue();
	}
	
	
	/**
	 * Converte uma tripa de bytes para um valor do tipo {@code Byte}.
	 * @param b Conjunto de bytes a ser convertido.
	 * @return Um valor do tipo {@code Byte}.
	 */
	public static Byte getByte(byte[] b)
	{
		return parseNumber(0L, b, Byte.BYTES).byteValue();
	}
	
	
	/**
	 * Função auxiliar que converte o conjunto de bytes a um valor numérico.
	 * @param n Valor afetado pela função.
	 * @param b Conjunto de bytes para ser convertido.
	 * @param size Quantidade de bytes a serem lidas.
	 * @return O resultado final da conversão, que foi o argumento {@code n}.
	 */
	private static Long parseNumber(Long n, byte[] b, int size)
	{
		for (int i = 0; i < size; ++i)
			n += b[i] << (i * 8);
		return n;
	}
	
	
	/**
	 * Função auxiliar que recebe um valor e os divide em um grupo de bytes.
	 * @param n Valor afetado pela função.
	 * @param size Tamanho do conjunto de bytes.
	 * @return Um array de bytes extraídos do valor dado por argumento.
	 */
	private static byte[] parseByteArray(Long n, int size)
	{
		byte[] b = new byte[size];
		for (int i = 0; i < size; ++i)
		{
			Long l = (n >> (i * 8)) % 0x100;
			b[i] = l.byteValue();
		}
		return b;
	}
}
