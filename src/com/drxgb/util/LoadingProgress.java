package com.drxgb.util;

/**
 * Classe responsável por tratar as barras de carregamento de dados.
 * @author Dr.XGB
 * @version 1.0
 */
public class LoadingProgress 
{	
	/*
	 * ===========================================================
	 * 			*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	private Double min;
	private Double max;
	private Double progress;
	private String status;
	
	private static LoadingProgress self;	
	
	
	/*
	 * ===========================================================
	 * 			*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	private LoadingProgress(Double min, Double max, Double progress) 
	{
		this.min = min;
		this.max = max;
		this.status = "";
		this.setProgress(progress);
	}
	
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * A instância da barra de progresso
	 * @return A instância da barra de progresso.
	 */
	public static LoadingProgress instance()
	{
		return self;
	}
	
	
	/**
	 * Gera uma instância estática da barra de progresso.
	 * @param initialProgress Estado inicial da barra de progresso.
	 * @param min Valor mínimo da barra.
	 * @param max Valor máximo da barra.
	 * @return A nova instância da barra de progresso.
	 */
	public static LoadingProgress create(double initialProgress, double min, double max)
	{
		self = new LoadingProgress(min, max, initialProgress);
		return self;
	}
	
	/**
	 * Gera uma instância estática da barra de progresso, iniciando com o
	 * valor mínimo.
	 * @param min Valor mínimo da barra.
	 * @param max Valor máximo da barra.
	 * @return A nova instância da barra de progresso.
	 */
	public static LoadingProgress create(double min, double max)
	{
		return create(min, min, max);
	}
	
	/**
	 * Gera uma instância estática da barra de progresso, iniciando
	 * com o valor mínimo.
	 * @param max Valor máximo da barra.
	 * @return A nova instância da barra de progresso.
	 */
	public static LoadingProgress create(double max)
	{
		return create(0.0, 0.0, max);
	}
	
	
	/**
	 * Gera uma instância estática da barra de progresso, com o
	 * padrão cujo o valor do progresso deve ser de 0 até 100.
	 * @return A nova instância da barra de progresso.
	 */
	public static LoadingProgress create()
	{
		return create(0.0, 0.0, 100.0);
	}
	
	
	/**
	 * Incrementa o valor do progresso
	 * @param amount Quantidade a ser incrementada.
	 */
	public void increase(double amount)
	{
		setProgress(progress + amount);
	}
	
	/**
	 * Incrementa o valor do progresso a 1.
	 */
	public void increase()
	{
		increase(1.0);
	}
	
	
	/**
	 * Decrementa o valor do progresso.
	 * @param amount Quantidade a ser decrementada.
	 */
	public void decrease(double amount)
	{
		setProgress(progress - amount);
	}
	
	
	/**
	 * Decrementa o valor do progresso a 1.
	 */
	public void decrease()
	{
		decrease(1.0);
	}
	
	
	/**
	 * Limpa o estado do progresso.
	 */
	public void clear()
	{
		setProgress(min);
	}
	
	
	/**
	 * Completa o estado do progresso.
	 */
	public void fill()
	{
		setProgress(max);
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append((status.isEmpty()) ? "Progress" : status);
		sb.append(": ");
		sb.append(progress + " to " + max);
		return sb.toString();
	}


	/*
	 * ===========================================================
	 * 			*** GETTERS E SETTERS ***
	 * ===========================================================
	 */

	public Double getMin() {
		return min;
	}

	public void setMin(Double min) {
		this.min = min;
	}

	public Double getMax() {
		return max;
	}

	public void setMax(Double max) {
		this.max = max;
	}

	public Double getProgress() {
		return progress;
	}
	
	public void setProgress(Double progress) {
		this.progress = ValueHandler.clamp(progress, min, max);;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
}
