package com.drxgb.util;

import java.util.LinkedList;
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
	
	protected List<T> container = new LinkedList<>();	
	
	
	/*
	 * ===========================================================
	 * 			*** GETTERS ***
	 * ===========================================================
	 */
	
	/**
	 * Recebe o conjunto do conte�do do conatiner.
	 * @return O pr�prio container.
	 */
	public List<T> getContainer()
	{
		return container;
	}
	
	
	/*
	 * ===========================================================
	 * 			*** M�TODOS P�BLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * <p>Insere um elemento ao container.</p>
	 * <p>Caso tenham elementos � frente da posi��o solicitada,
	 * todos eles ser�o empurrados para a direita antes da inser��o.</p>
	 * @param index �ndice onde o conte�do ser� inserido.
	 * @param e Elemento a ser inserido ao container.
	 * @return O pr�prio container, podendo encadear fun��es de inser��o e remo��o
	 * na sequ�ncia.
	 */
	public Container<T> insert(int index, T e)
	{
		container.add(index, e);
		return this;
	}
	
	
	/**
	 * <p>Insere um conjunto de elementos ao container.</p>
	 * <p>Caso tenham elementos � frente da posi��o solicitada,
	 * todos eles ser�o empurrados para a direita antes da inser��o.</p>
	 * @param index �ndice onde o conte�do ser� inserido.
	 * @param e Conjunto de elementos a ser inserido ao container.
	 * @return O pr�prio container, podendo encadear fun��es de inser��o e remo��o
	 * na sequ�ncia.
	 */
	public Container<T> insert(int index, List<T> e)
	{
		container.addAll(index, e);
		return this;
	}
	
	
	/**
	 * <p>Remove o elemento ao container.</p>
	 * <p>O sistema vai procurar se o elemento existe no container.
	 * Se o elemento n�o for encontrado, nada acontecer� e o container
	 * ter� sua estrutura permanecida.</p>
	 * @param e Elemento a ser removido ao container.
	 * @return O pr�prio container, podendo encadear fun��es de inser��o e remo��o
	 * na sequ�ncia.
	 */
	public Container<T> remove(T e)
	{
		container.remove(e);
		return this;
	}
	
	
	/**
	 * <p>Remove o elemento ao container.</p>
	 * @param index �ndice do elemento a ser removido ao container.
	 * @return O pr�prio container, podendo encadear fun��es de inser��o e remo��o
	 * na sequ�ncia.
	 */
	public Container<T> remove(int index)
	{
		container.remove(index);
		return this;
	}
	
	
	/**
	 * Insere um elemento no in�cio do container.
	 * @param e Elemento a ser inserido.
	 * @return O pr�prio container, podendo encadear fun��es de inser��o e remo��o
	 * na sequ�ncia.
	 */
	public Container<T> prepend(T e)
	{
		return insert(0, e);
	}
	
	
	/**
	 * Insere um conjunto de elementos no in�cio do container.
	 * @param e Conjunto de elementos a ser inserido.
	 * @return O pr�prio container, podendo encadear fun��es de inser��o e remo��o
	 * na sequ�ncia.
	 */
	public Container<T> prepend(List<T> e)
	{
		return insert(0, e);
	}
	
	
	/**
	 * Insere um elemento no final do container.
	 * @param e Elemento a ser inserido.
	 * @return O pr�prio container, podendo encadear fun��es de inser��o e remo��o
	 * na sequ�ncia.
	 */
	public Container<T> append(T e)
	{
		container.add(e);
		return this;
	}
	
	
	/**
	 * Insere um conjunto de elementos no final do container.
	 * @param e Conjunto de elementos a ser inserido.
	 * @return O pr�prio container, podendo encadear fun��es de inser��o e remo��o
	 * na sequ�ncia.
	 */
	public Container<T> append(List<T> e)
	{
		container.addAll(e);
		return this;
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
