package com.drxgb.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por armazenar algum conteúdo em um
 * container, onde pode ser convertido para array de algum tipo.
 * @author Dr.XGB
 * @version 1.0
 * @param <T> Conteúdo a ser guardado em um container.
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
	 * Recebe o conjunto do conteúdo do conatiner.
	 * @return
	 */
	public List<T> getContainer()
	{
		return container;
	}
	
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PÚBLICOS ABSTRATOS ***
	 * ===========================================================
	 */
	
	/**
	 * Converte o conteúdo do container em um array de bytes.
	 * @return Array de {@code byte} com os conteúdos do container.
	 */
	public abstract byte[] toByteArray();
	
	/**
	 * Converte o conteúdo do conatiner em um array de chars.
	 * @return Array de {@code char} com os conteúdos do container.
	 */
	public abstract char[] toCharArray();
}
