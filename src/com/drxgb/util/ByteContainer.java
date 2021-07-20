package com.drxgb.util;

/**
 * Classe responsável por guardar bytes em um container.
 * @author Dr.XGB
 * @version 1.0
 */
public final class ByteContainer extends Container<Byte>
{
	/*
	 * ===========================================================
	 * 			*** MÉTODOS IMPLEMENTADOS ***
	 * ===========================================================
	 */

	@Override
	public byte[] toByteArray() {
		byte[] b = new byte[container.size()];
		for (int i = 0; i < container.size(); ++i)
		{
			b[i] = container.get(i);
		}
		return b;
	}

	@Override
	public char[] toCharArray() {
		char[] ch = new char[container.size()];
		for (int i = 0; i < container.size(); ++i)
		{
			ch[i] = (char) container.get(i).byteValue();
		}
		return ch;
	}	
}
