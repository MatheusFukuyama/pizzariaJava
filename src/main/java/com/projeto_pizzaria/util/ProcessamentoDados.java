package com.projeto_pizzaria.util;

import java.util.Objects;

	public class ProcessamentoDados {
		public static final boolean FALSO = false;
		public static final boolean VERDADEIRO = true;
		
		public static boolean digitacaoCampo(String texto) {
			
			if (Objects.isNull(texto)) {
				return VERDADEIRO;
			}
			
			if("".equals(texto.trim())) {
				return VERDADEIRO;
			}
			
			return FALSO;
		}
}
