package br.com.smarttec.helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptHelper {
	public static String encryptToSHA1(String input) {
		try {
			// Obt�m uma inst�ncia do algoritmo de hash SHA-1
			MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
			
			// Converte a entrada em bytes
			byte[] inputBytes = input.getBytes();
			
			// Atualiza o algoritmo de hash com os bytes da entrada
			sha1.update(inputBytes);
			
			// Calcula o hash SHA-1
			byte[] hashBytes = sha1.digest();
			
			// Converte o hash em uma representa��o hexadecimal
			StringBuilder hexString = new StringBuilder();
			for (byte hashByte : hashBytes) {
				
				// Formata cada byte como dois d�gitos hexadecimais
				String hex = Integer.toHexString(0xff & hashByte);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			
			// Retorna o hash SHA-1 como uma string hexadecimal
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			
			// Trate qualquer exce��o de algoritmo n�o encontrado
			e.printStackTrace();
			return null;
		}
	}
}
