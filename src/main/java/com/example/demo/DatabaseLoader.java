package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final InstrumentoRepository repositoryI;
	private final MusicoRepository repositoryM;
	private final BandaRepository repositoryB;
	private final IntegranteRepository repositoryN;

	@Autowired
	public DatabaseLoader(
		InstrumentoRepository repositoryI, 
		MusicoRepository repositoryM,
		BandaRepository repositoryB,
		IntegranteRepository repositoryN
		) {
		this.repositoryI = repositoryI;
		this.repositoryM = repositoryM;
		this.repositoryB = repositoryB;
		this.repositoryN = repositoryN;
	}

	@Override
	public void run(String... strings) throws Exception {
		this.repositoryI.save(new Instrumento("Guitarra", "Cuerda", "de madera, con caja de resonancia, 6 cuerdas templadas"));
		this.repositoryI.save(new Instrumento("Ukelele","Cuerda","de madera, con caja de resonancia pequeña, 4 cuerdas templadas"));
		this.repositoryI.save(new Instrumento("Melódica","Viento","teclado pequeño de 2 octavas, sonorizado por soplido"));
		
		Instrumento ivoz = new Instrumento("Voz","Viento",".");
		this.repositoryI.save(ivoz);

		Instrumento guitarraE = new Instrumento("Guitarra Electrica","Electrica","de 6 cuerdas");
		this.repositoryI.save(guitarraE);

		this.repositoryI.save(new Instrumento("Bateria","Percusión","de buenos tambores para que retumbes"));
		
		this.repositoryM.save(new Musico("Daniel F"));
		this.repositoryM.save(new Musico("David S"));
		
		Musico freddy = new Musico("Freddy");
		this.repositoryM.save(freddy);
		Musico bryan = new Musico("Bryan");
		this.repositoryM.save(bryan);

		Banda bQueen = new Banda("Queen");
		this.repositoryB.save(bQueen);

		//this.repositoryN.save(new Integrante(bQueen,freddy, ivoz));
	}
}