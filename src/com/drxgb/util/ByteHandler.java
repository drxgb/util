package com.drxgb.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/**
 * Classe abstrata responsável por converter número em tripa de bytes.
 * @author Dr.XGB
 * @version 1.5
 */
public abstract class ByteHandler
{
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Converte um valor do tipo {@code Long} para um container de bytes.
	 * @param n O valor numérico a ser convertido
	 * @return Um container de bytes correspendente ao valor dado por argumento.
	 * @see ByteContainer
	 */
	public static ByteContainer getBytes(Long n)
	{
		return parseByteArray(n, Long.BYTES);
	}
	
	
	/**
	 * Converte um valor do tipo {@code Integer} para um container de bytes.
	 * @param n O valor numérico a ser convertido
	 * @return Um container de bytes correspendente ao valor dado por argumento.
	 * @see ByteContainer
	 */
	public static ByteContainer getBytes(Integer n)
	{
		return parseByteArray(n.longValue(), Integer.BYTES);
	}
	
	
	/**
	 * Separa todos os caracteres contidos na {@code String} e os armazena
	 * em um container de bytes.
	 * @param str Texto a ser guardado no container.
	 * @param charset Tipo de codificação dos caracteres.
	 * @return Um container de bytes com todos os caracteres da string.
	 * @throws UnsupportedEncodingException Quando o tipo de codificação não é corresponde a nenhum
	 * dos tipos suportados.
	 */
	public static ByteContainer getBytes(String str, String charset) throws UnsupportedEncodingException
	{
		ByteContainer container = new ByteContainer();
		for (byte b : str.getBytes(charset))
			container.append(b);
		return container;
	}
	
	
	/**
	 * Separa todos os caracteres contidos na {@code String} e os armazena
	 * em um container de bytes.
	 * @param str Texto a ser guardado no container.
	 * @param charset Tipo de codificação dos caracteres.
	 * @return Um container de bytes com todos os caracteres da string.
	 * @throws UnsupportedEncodingException Quando o tipo de codificação não é corresponde a nenhum
	 * dos tipos suportados.
	 */
	public static ByteContainer getBytes(String str, Charset charset) throws UnsupportedEncodingException
	{
		return getBytes(str, charset.displayName());
	}
	
	
	/**
	 * Separa todos os caracteres contidos na {@code String} e os armazena
	 * em um container de bytes, já com o padrão UTF-8.
	 * @param str Texto a ser guardado no container.
	 * @return Um container de bytes com todos os caracteres da string.
	 * @throws UnsupportedEncodingException Quando o tipo de codificação não é corresponde a nenhum
	 * dos tipos suportados.
	 */
	public static ByteContainer getBytes(String str) throws UnsupportedEncodingException
	{
		return getBytes(str, "UTF-8");
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
	 * Converte {@code byte[]} para {@code Byte[]}.
	 * @param b Array de bytes.
	 * @return Array convertido de bytes.
	 */
	public static Byte[] box(byte[] b)
	{
		Byte[] boxBytes = new Byte[b.length];
		for (int i = 0; i < b.length; ++i)
			boxBytes[i] = b[i];
		return boxBytes;
	}
	
	
	/**
	 * Converte {@code Byte[]} para {@code byte[]}.
	 * @param box Array de bytes.
	 * @return Array convertido de bytes.
	 */
	public static byte[] unbox(Byte[] box)
	{
		byte[] b = new byte[box.length];
		for (int i = 0; i < box.length; ++i)
			b[i] = box[i];
		return b;
	}
	
	
	/**
	 * Insere um array de bytes em uma Lista.
	 * @param b Array de bytes.
	 * @return Uma lista com os mesmo bytes do array dado por argumento.
	 */
	public static List<Byte> collect(byte[] b)
	{
		return Arrays.asList(box(b));
	}
	
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PRIVADOS ***
	 * ===========================================================
	 */
	
	
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
		{
			long a = (long) b[i] & 0xFF;
			n += a << (i * 8);
		}
		return n;
	}
	
	
	/**
	 * Função auxiliar que recebe um valor e os divide em um grupo de bytes.
	 * @param n Valor afetado pela função.
	 * @param size Tamanho do conjunto de bytes.
	 * @return Um container de bytes extraídos do valor dado por argumento.
	 */
	private static ByteContainer parseByteArray(Long n, int size)
	{
		ByteContainer container = new ByteContainer();
		for (int i = 0; i < size; ++i)
		{
			Long l = (n >> (i * 8)) & 0xFF;
			container.append(l.byteValue());
		}
		return container;
	}
}
