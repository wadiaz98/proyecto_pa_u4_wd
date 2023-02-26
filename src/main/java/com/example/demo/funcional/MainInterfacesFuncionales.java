package com.example.demo.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfacesFuncionales {

	private static final Logger LOG = LoggerFactory.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {

		// 1.SUPPLIER
		LOG.info("1.SUPPLIER");
		// Clases

		IPersonaSupplier<String> supplier1 = new PersonaSupplierImpl();
		LOG.info("Supplier Clase: " + supplier1.getNombre());

		// Lamdas
		IPersonaSupplier<String> supplier2 = () -> "Willan 2";
		LOG.info("Supplier Lambda: " + supplier2.getNombre());

		IPersonaSupplier<Integer> supplier3 = () -> Integer.valueOf(5);
		LOG.info("Supplier Lambda: " + supplier3.getNombre());

		IPersonaSupplier<Persona> supplier4 = () -> {
			Persona per = new Persona();
			per.setApellido("Diaz");
			per.setNombre("Willan");
			return per;
		};
		LOG.info("Supplier Lambda: " + supplier4.getNombre());

		IPersonaSupplier<Persona> supplier5 = new PersonaSupplier2Impl();
		LOG.info("Supplier Clase: " + supplier5.getNombre());

		// 2.Consumer
		LOG.info("2.CONSUMER");

		// Clase
		IPersonaConsumer<String, Integer> consumer1 = new PersonaConsumerImpl();
		consumer1.accept("Procesa este dato", Integer.valueOf(10));
		// Lambda

		IPersonaConsumer<String, Integer> consumer2 = (cadena, numero) -> {
			LOG.info("mensaje a: " + cadena);
			LOG.info("mensaje b: " + cadena);
			LOG.info("mensaje c: " + numero);
		};
		consumer2.accept("procesa este dato 2", Integer.valueOf(15));

		IPersonaConsumer<Integer, Integer> consumer3 = (valor1, valor2) -> {
			Integer valor3 = valor1.intValue() + valor2.intValue();
			LOG.info("Valor 3 = " + valor3);
		};
		consumer3.accept(Integer.valueOf(5), Integer.valueOf(10));

		// 3.Predicate
		LOG.info("3.PREDICATE");

		IPersonaPredicate<String> predicate1 = cadena -> cadena.contains("z");
		LOG.info("Predicate: " + predicate1.evaluar("Willanz"));

		IPersonaPredicate<Integer> predicate2 = numero -> {
			if (numero.intValue() > 10) {
				return true;

			} else {
				return false;
			}
		};
		LOG.info("Predicate2: " + predicate2.evaluar(Integer.valueOf(11)));

		// 4.Function
		LOG.info("4.FUNCTION");

		IPersonaFunction<String, Integer> function1 = numero -> "Valor: " + numero.toString();
		LOG.info(function1.aplicar(Integer.valueOf(10)));

		IPersonaFunction<Ciudadano, Persona> function2 = persona -> {
			Ciudadano ciudadano = new Ciudadano();
			ciudadano.setNombreCompleto(persona.getNombre() + " " + persona.getApellido());
			ciudadano.setCiudad("Quito");

			return ciudadano;
		};
		Persona persona = new Persona();
		persona.setApellido("Diaz");
		persona.setNombre("Willan");
		Ciudadano ciudadanoConvertido = function2.aplicar(persona);
		LOG.info("Ciudadano convertido: " + ciudadanoConvertido);
		
		// 5.UnaryOperator
		LOG.info("5.UNARY OPERATOR");
		IPersonaUnaryOperator<String> unaryOperator = cadena -> {
			String cadenaFinal = cadena.concat("-sufijo");
			return cadenaFinal;
		};
		LOG.info("Unary Operator: " + unaryOperator.aplicar("Willan"));
	}
}
