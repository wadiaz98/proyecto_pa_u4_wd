package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Ciudadano;
import com.example.demo.modelo.Estudiante;
import com.example.demo.repository.ICiudadanoRepo;

@Service
public class EstudianteImpl implements IEstudianteService {

	@Autowired
	private ICiudadanoRepo ciudadanoRepo;

	@Autowired
	private ICiudadanoService ciudadanoService;

	@Override
	public void procesarEstudianteParalelo() {
		// TODO Auto-generated method stub
		List<Ciudadano> ciudadanos = this.ciudadanoRepo.buscar();

		// Procesar cada estudiante
		long tiempoInicial = System.currentTimeMillis();

		List<Estudiante> estudiantes = ciudadanos.parallelStream()
				.map(ciudadano -> this.ciudadanoService.convertir(ciudadano)).collect(Collectors.toList());

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		estudiantes.forEach(cadena -> System.out.println(cadena));

		System.out.println("Tiempo transcurrido en segundos: " + tiempoTranscurrido);

	}

}
