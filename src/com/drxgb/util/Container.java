package com.drxgb.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe respons�vel por armazenar algum conte�do em um
 * container, onde pode ser convertido para array de algum tipo.
 * @author Dr.XGB
 * @version 1.0
 * @param <T> Conte�do a ser guardado em um container.
 */
public abstract class Container<T>
{
	/*
	 * ===========================================================
	 * 			*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	protected List<T> container = new ArrayList<>();	
	
	
	/*
	 * ===========================================================
	 * 			*** GETTERS ***
	 * ===========================================================
	 */
	
	/**
	 * Recebe o conjunto do conte�do do conatiner.
	 * @return
	 */
	public List<T> getContainer()
	{
		return container;
	}
	
	
	/*
	 * ===========================================================
	 * 			*** M�TODOS P�BLICOS ABSTRATOS ***
	 * ===========================================================
	 */
	
	/**
	 * Converte o conte�do do container em um array de bytes.
	 * @return Array de {@code byte} com os conte�dos do container.
	 */
	public abstract byte[] toByteArray();
	
	/**
	 * Converte o conte�do do conatiner em um array de chars.
	 * @return Array de {@code char} com os conte�dos do container.
	 */
	public abstract char[] toCharArray();
}
