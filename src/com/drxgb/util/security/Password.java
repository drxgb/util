package com.drxgb.util.security;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 * Responsável por criptografar uma mensagem, onde somente o sistema deve
 * decriptar esta mensagem, a fim de proteger uma informação sensível.
 * @author Dr.XGB
 * @version 1.10.0
 */
public class Password
{
	
	/*
	 * ===========================================================
	 * 			*** ATRIBUTOS ***
	 * ===========================================================
	 */
	
	private KeyPairGenerator generator;
	private KeyPair pair;
	private Cipher cipher;
	private byte[] message;
	
	
	/*
	 * ===========================================================
	 * 			*** CONSTRUTORES ***
	 * ===========================================================
	 */
	
	public Password(String message, String algorithm, int size)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
				IllegalBlockSizeException, BadPaddingException, InvalidKeyException
	{
		generator = KeyPairGenerator.getInstance(algorithm.split("/")[0]);
		generator.initialize(size);
		pair = generator.generateKeyPair();
		cipher = Cipher.getInstance(algorithm);
		this.message = encrypt(message.getBytes());
	}
	
	public Password(String message, String algorithm)
			throws InvalidKeyException, NoSuchAlgorithmException,
				NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
	{
		this(message, algorithm, 2048);
	}
	
	public Password(String message)
			throws InvalidKeyException, NoSuchAlgorithmException,
				NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException
	{
		this(message, "RSA/ECB/PKCS1Padding");
	}
	
	
	/*
	 * ===========================================================
	 * 			*** GETTERS ***
	 * ===========================================================
	 */
	
	/**
	 * Recebe a mensagem criptografada.
	 * @return A mensagem criptografada.
	 */
	public String getMessage()
	{
		return new String(message);
	}
	
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PÚBLICOS ***
	 * ===========================================================
	 */
	
	/**
	 * Recebe a mensagem decriptada.
	 * @param encode Tipo de encoding do texto.
	 * @return A mensagem decriptada.
	 * @throws InvalidKeyException Caso haja uma falha na geração da chave.
	 * @throws IllegalBlockSizeException Caso ocorra uma falha na alocação de dados da chave.
	 * @throws BadPaddingException Caso ocorra uma falha no padding no método de encriptação.
	 * @throws UnsupportedEncodingException Caso o encoding do texto seja inválido.
	 */
	public String getDecryptedMessage(String encode)
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException
	{
		cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
		return new String(cipher.doFinal(message), encode);
	}
	
	/**
	 * Recebe a mensagem decriptada no formato UTF-8.
	 * @return A mensagem decriptada.
	 * @throws InvalidKeyException Caso haja uma falha na geração da chave.
	 * @throws IllegalBlockSizeException Caso ocorra uma falha na alocação de dados da chave.
	 * @throws BadPaddingException Caso ocorra uma falha no padding no método de encriptação.
	 * @throws UnsupportedEncodingException Caso o encoding do texto seja inválido.
	 */
	public String getDecryptedMessage()
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException
	{
		return getDecryptedMessage("UTF8");
	}
	
	
	/*
	 * ===========================================================
	 * 			*** MÉTODOS PRIVADOS ***
	 * ===========================================================
	 */
	
	/**
	 * Encripta a mensagem recebida imediatamente.
	 * @param msg A mensagem a ser encriptada.
	 * @return A mensagem encriptada.
	 * @throws InvalidKeyException Caso haja uma falha na geração da chave.
	 * @throws IllegalBlockSizeException Caso ocorra uma falha na alocação de dados da chave.
	 * @throws BadPaddingException Caso ocorra uma falha no padding no método de encriptação.
	 */
	private	byte[] encrypt(byte[] msg)
			throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException
	{
		cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
		cipher.update(msg);
		return cipher.doFinal();
	}	
	
}
