package com.drxgb.util;

import java.util.LinkedList;
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
	
	protected List<T> container = new LinkedList<>();	
	
	
	/*
	 * ===========================================================
	 * 			*** GETTERS ***
	 * ===========================================================
	 */
	
	/**
	 * Recebe o conjunto do conteúdo do conatiner.
	 * @return O próprio container.
	 */
	public List<T> getContainer()
	{
		return container;
	}
	
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * <p>Insere um elemento ao container.</p>
	 * <p>Caso tenham elementos à frente da posição solicitada,
	 * todos eles serão empurrados para a direita antes da inserção.</p>
	 * @param index Índice onde o conteúdo será inserido.
	 * @param e Elemento a ser inserido ao container.
	 * @return O próprio container, podendo encadear funções de inserção e remoção
	 * na sequência.
	 */
	public Container<T> insert(int index, T e)
	{
		container.add(index, e);
		return this;
	}
	
	
	/**
	 * <p>Insere um conjunto de elementos ao container.</p>
	 * <p>Caso tenham elementos à frente da posição solicitada,
	 * todos eles serão empurrados para a direita antes da inserção.</p>
	 * @param index Índice onde o conteúdo será inserido.
	 * @param e Conjunto de elementos a ser inserido ao container.
	 * @return O próprio container, podendo encadear funções de inserção e remoção
	 * na sequência.
	 */
	public Container<T> insert(int index, List<T> e)
	{
		container.addAll(index, e);
		return this;
	}
	
	
	/**
	 * <p>Remove o elemento ao container.</p>
	 * <p>O sistema vai procurar se o elemento existe no container.
	 * Se o elemento não for encontrado, nada acontecerá e o container
	 * terá sua estrutura permanecida.</p>
	 * @param e Elemento a ser removido ao container.
	 * @return O próprio container, podendo encadear funções de inserção e remoção
	 * na sequência.
	 */
	public Container<T> remove(T e)
	{
		container.remove(e);
		return this;
	}
	
	
	/**
	 * <p>Remove o elemento ao container.</p>
	 * @param index Índice do elemento a ser removido ao container.
	 * @return O próprio container, podendo encadear funções de inserção e remoção
	 * na sequência.
	 */
	public Container<T> remove(int index)
	{
		container.remove(index);
		return this;
	}
	
	
	/**
	 * Insere um elemento no início do container.
	 * @param e Elemento a ser inserido.
	 * @return O próprio container, podendo encadear funções de inserção e remoção
	 * na sequência.
	 */
	public Container<T> prepend(T e)
	{
		return insert(0, e);
	}
	
	
	/**
	 * Insere um conjunto de elementos no início do container.
	 * @param e Conjunto de elementos a ser inserido.
	 * @return O próprio container, podendo encadear funções de inserção e remoção
	 * na sequência.
	 */
	public Container<T> prepend(List<T> e)
	{
		return insert(0, e);
	}
	
	
	/**
	 * Insere um elemento no final do container.
	 * @param e Elemento a ser inserido.
	 * @return O próprio container, podendo encadear funções de inserção e remoção
	 * na sequência.
	 */
	public Container<T> append(T e)
	{
		container.add(e);
		return this;
	}
	
	
	/**
	 * Insere um conjunto de elementos no final do container.
	 * @param e Conjunto de elementos a ser inserido.
	 * @return O próprio container, podendo encadear funções de inserção e remoção
	 * na sequência.
	 */
	public Container<T> append(List<T> e)
	{
		container.addAll(e);
		return this;
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
