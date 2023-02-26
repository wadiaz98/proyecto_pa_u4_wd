package com.example.demo.funcional;

public class PersonaSupplier2Impl implements IPersonaSupplier<Persona>{

	@Override
	public Persona getNombre() {
		// TODO Auto-generated method stub
		Persona per = new Persona();
		per.setApellido("Diaz 1");
		per.setNombre("Willan 1");
		return per;
	}

}
