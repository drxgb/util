package com.drxgb.util;

/**
 * Classe que realiza tratativas diversas com valores num�ricos.
 * @author Dr.XGB
 * @version 1.0
 */
public abstract class ValueHandler {
	
	/*
	 * ===========================================================
	 * 				*** M�TODOS P�BLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Delimita um valor m�nimo e m�ximo para o valor de entrada.
	 * @param value Valor a ser tratado.
	 * @param min Valor m�nimo da tratativa.
	 * @param max Valor m�ximo da tratativa.
	 * @return Valor tratado dentro do m�todo, deixando sempre entre
	 * o valor m�nimo e o m�ximo.
	 */
	public static double clamp(double value, double min, double max) {
		value = (value < min) ? min : value;
		value = (value > max) ? max : value;
		return value;
	}
	
	/**
	 * Delimita um valor m�nimo e m�ximo para o valor de entrada.
	 * @param value Valor a ser tratado.
	 * @param min Valor m�nimo da tratativa.
	 * @param max Valor m�ximo da tratativa.
	 * @return Valor tratado dentro do m�todo, deixando sempre entre
	 * o valor m�nimo e o m�ximo.
	 */
	public static int clamp(int value, int min, int max) {
		return (int) clamp((double) value, (double) min, (double) max);
	}
	
	/**
	 * Delimita um valor m�nimo e m�ximo para o valor de entrada.
	 * @param value Valor a ser tratado.
	 * @param min Valor m�nimo da tratativa.
	 * @param max Valor m�ximo da tratativa.
	 * @return Valor tratado dentro do m�todo, deixando sempre entre
	 * o valor m�nimo e o m�ximo.
	 */
	public static float clamp(float value, float min, float max) {
		return (float) clamp((double) value, (double) min, (double) max);
	}
	
	/**
	 * Delimita um valor m�nimo e m�ximo para o valor de entrada.
	 * @param value Valor a ser tratado.
	 * @param min Valor m�nimo da tratativa.
	 * @param max Valor m�ximo da tratativa.
	 * @return Valor tratado dentro do m�todo, deixando sempre entre
	 * o valor m�nimo e o m�ximo.
	 */
	public static long clamp(long value, long min, long max) {
		return (long) clamp((double) value, (double) min, (double) max);
	}
	
	/**
	 * Delimita um valor m�nimo e m�ximo para o valor de entrada.
	 * @param value Valor a ser tratado.
	 * @param min Valor m�nimo da tratativa.
	 * @param max Valor m�ximo da tratativa.
	 * @return Valor tratado dentro do m�todo, deixando sempre entre
	 * o valor m�nimo e o m�ximo.
	 */
	public static short clamp(short value, short min, short max) {
		return (short) clamp((double) value, (double) min, (double) max);
	}
	
	/**
	 * Delimita um valor m�nimo e m�ximo para o valor de entrada.
	 * @param value Valor a ser tratado.
	 * @param min Valor m�nimo da tratativa.
	 * @param max Valor m�ximo da tratativa.
	 * @return Valor tratado dentro do m�todo, deixando sempre entre
	 * o valor m�nimo e o m�ximo.
	 */
	public static byte clamp(byte value, byte min, byte max) {
		return (byte) clamp((double) value, (double) min, (double) max);
	}
	
}
