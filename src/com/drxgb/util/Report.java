package com.drxgb.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Classe responsável por gerar relatórios, onde seus
 * registros ficarão gravados em arquivos de texto separado
 * por data.
 * @author Dr.XGB
 * @version 1.1
 */
public abstract class Report {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy - HH:mm:ss");
	
	/**
	 * Registra uma exceção lançada em um arquivo de texto.
	 * @param e A exceção lançada.
	 */
	public static void writeErrorLog(Exception e) {
		Calendar cal = Calendar.getInstance();
		final String logPath = "log/";
		String logName = "log";
		logName += String.valueOf(cal.get(Calendar.YEAR));
		logName += String.format("%2d", cal.get(Calendar.MONTH) + 1);
		logName += String.format("%2d", cal.get(Calendar.DAY_OF_MONTH));
		new File(logPath).mkdir();
		
		try(BufferedWriter file = new BufferedWriter(new FileWriter(logPath + logName + ".log", true))) {
			Date date = new Date();
			StringBuilder log = new StringBuilder();			
			log.append("[");
			log.append(sdf.format(date).toString());
			log.append("]\n");
			log.append("ERROR: ");
			log.append(e.getClass().getSimpleName());
			log.append(" -> ");
			log.append(e.getMessage());
			log.append("\n---\n");
			writeStackTrace(log, e);
			writeCauses(log, e);
			file.write(log.toString());
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
	}
	
	
	/**
	 * Escreve todos os detalhes do erro.
	 * @param log O texto onde está sendo escrito o conteúdo do err.
	 * @param e A exceção lançada.
	 */
	private static void writeStackTrace(StringBuilder log, Throwable e)
	{
		for(int i = 0; i < e.getStackTrace().length; i++) {
			for(int j = 0; j < i; j++) {
				log.append("    ");
			}
			log.append(e.getStackTrace()[i].toString() + "\n");
		}
		log.append("\n");
	}
	
	
	/**
	 * Escreve as outras exceções causadas para que a mesma
	 * seja lançada.
	 * @param log O texto onde está sendo escrito o conteúdo do err.
	 * @param e A exceção lançada.
	 */
	private static void writeCauses(StringBuilder log, Exception e)
	{
		Throwable t = e;
		while ((t = t.getCause()) != null)
		{
			log.append("Caused by: ");
			log.append(t.toString());
			log.append("\n");
			writeStackTrace(log, t);
		}
	}
	
}
