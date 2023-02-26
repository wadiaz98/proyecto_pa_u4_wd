package com.example.demo.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {

	private static final Logger LOG = LoggerFactory.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {

		// JAVA
		// 1. SUPPLIER
		LOG.info("1.JAVA SUPPLIER");

		Stream<String> lista = Stream.generate(() -> "Willan 2").limit(10);
		lista.forEach(cadena -> LOG.info(cadena));
		// 2.CONSUMER
		LOG.info("2.JAVA CONSUMER");

		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		listaNumeros.forEach(numero -> LOG.info("Valor: " + numero));

		for (Integer i : listaNumeros) {
			LOG.info("Valor: " + i);
		}
		// 3.PREDICATE
		LOG.info("3.JAVA PREDCIATE");

		Stream<Integer> listaFiltrada = listaNumeros.stream().filter(numero -> numero >= 3);
		listaFiltrada.forEach(numero -> LOG.info("Valor: " + numero));
		// 4.FUNCTION
		LOG.info("4.JAVA FUNCTION");
		Stream<String> listaCambiada = listaNumeros.stream().map(numeroLista -> {
			Integer valorFinal = numeroLista + 1;
			String cadena = "num: " + valorFinal.toString();
			return cadena;
		});
		
		listaCambiada.forEach(cadena -> LOG.info(cadena));
		// 5.UNARY OPERATOR
		LOG.info("5.JAVA UNARY OPERATOR");
		Stream<Integer> listaCambiada2 = listaNumeros.stream().map(numeroLista -> {
			Integer valorFinal = numeroLista + 1;
			return valorFinal;
		});
		
		listaCambiada2.forEach(numero -> LOG.info("Valor entero: " + numero));
	}
}
