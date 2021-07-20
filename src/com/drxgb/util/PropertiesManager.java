package com.drxgb.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Classe abstrata respons�vel por gerenciar a grava��o e o
 * carregamento de um arquivo de propriedades.
 * @author Dr.XGB
 * @version 1.6
 */
public abstract class PropertiesManager {

	/**
	 * Carrega as propriedades atrav�s de um arquivo {@code .properties}.
	 * @param path A localiza��o completa do arquivo.
	 * @return uma inst�ncia de {@code Properties} com todas as propriedades carregadas do arquivo.
	 */
	public static Properties load(File path) throws NullPointerException {			
		try (BufferedInputStream fs = new BufferedInputStream(new FileInputStream(path))) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (Exception e) {
			if (!create(path))
				return null;
			return load(path);
		}
	}
	
	
	/**
	 * Salva as propeiredades a um arquivo {@code .properties}.
	 * @param path A localiza��o completa do arquivo.
	 * @param props A inst�ncia de {@code Properties} a ser inserida no arquivo.
	 * @return O estado desta a��o. {@code true} se o arquivo foi gravado ccom sucesso
	 * e {@code false} se algo deu errado durante o processo.
	 */
	public static boolean save(File path, Properties props) {
		try (BufferedOutputStream fs = new BufferedOutputStream(new FileOutputStream(path))) {
			props.store(fs, null);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	/**
	 * Cria um arquivo para ler/escrever as propriedades.
	 * @param path A localiza��o completa do arquivo.
	 * @return O estado desta a��o. {@code true} se o arquivo foi criado ou {@code false} se
	 * n�o foi poss�vel criar o arquivo.
	 */
	private static boolean create(File path) {
		if (path == null)
			return false;
		
		try (BufferedOutputStream fs = new BufferedOutputStream(new FileOutputStream(path))) {
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
