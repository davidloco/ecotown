package com.slack.ecotown.util;

import java.util.ResourceBundle;

/**
 * @author David Andres Betancourth Botero
 * 
 */
public class Constantes {

	public static final ResourceBundle bundle = ResourceBundle.getBundle("com.slack.ecotown.util.bundle");

	public static final String RUTA_CARPETA_TEMPORAL_SRV = System.getProperty("java.io.tmpdir");
	public static final String SEPARADOR_CARPETAS_SRV = System.getProperty("file.separator");

	public static final String PATH_DOCUMENTS = bundle.getString("rutaDoc");
	public static final String TMP = bundle.getString("rutaTmp");
	public static final String SLASH = bundle.getString("rutaSlash");

	public static final String VACIO = " ";
	public static final String ESPACIO = " ";

	public static final int FOTO = 1;
	public static final int DOCUMENTO = 2;
	public static final int UNO = 1;
	public static final int DOS = 2;
	public static final int TRES = 3;

}
