package com.drxgb.util.io;

import java.io.BufferedInputStream;
import java.io.InputStream;

import com.drxgb.util.ValueHandler;

/**
 * <p>Classe herdada de {@code BufferedInputStream}.</p>
 * <p>Esta classe lhe permite alterar livremente a posição do
 * buffer da leitura do arquivo.</p> 
 * @author Dr.XGB
 * @version 1.6
 */
public class FlexibleInputStream extends BufferedInputStream
{
	/*
	 * ===========================================================
	 * 			*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	public FlexibleInputStream(InputStream out) {
		super(out);
	}
	
	public FlexibleInputStream(InputStream out, int size)
	{
		super(out, size);
	}
	
	
	/*
	 * ===========================================================
	 * 			*** GETTERS E SETTERS ***
	 * ===========================================================
	 */
	
	public int getPos()
	{
		return pos;
	}
	
	public void setPos(int p)
	{
		pos = ValueHandler.clamp(p, 0, count);
	}
}
