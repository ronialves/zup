package com.tlf.oss.resourceinventory.osp.core.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.TimeZone;

public class UsernameTokenUtils {

	public static synchronized String getTime() {
		Calendar c = new GregorianCalendar();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		//TELEARIE-17091 - Devido atualizacao no OSP para o WildFly 8 foi necessario enviar o horario no formato UTC e GMT 0
		s.setTimeZone(TimeZone.getTimeZone("UTC"));
		return s.format(c.getTime());
	}

	public static synchronized String getNonce() {
		Random generator = new Random();
		String nonceString = String.valueOf(generator.nextInt(999999999));
		return nonceString;
	}

	public static synchronized String encrypt(String plaintext) {
		
		MessageDigest md = null;
		
		try {
			md = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
		try {
			md.update(plaintext.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			return null;
		}
		
		byte raw[] = md.digest();
		byte[] hashByte = Base64.getEncoder().encode(raw);
		String hash = new String(hashByte);
		return hash;
		
	}
}