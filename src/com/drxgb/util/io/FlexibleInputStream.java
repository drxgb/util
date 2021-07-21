package com.drxgb.util.io;

import java.io.BufferedInputStream;
import java.io.InputStream;

import com.drxgb.util.ValueHandler;

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
		ValueHandler.clamp(p, 0, count);
	}
}
