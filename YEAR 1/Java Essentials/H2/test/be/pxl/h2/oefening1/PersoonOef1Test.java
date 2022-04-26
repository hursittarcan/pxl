package be.pxl.h2.oefening1;


import be.pxl.h2.oefening1.Persoon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersoonOef1Test {
	private Persoon persoon;

	@Before
	public void init() {
		persoon = new Persoon("Aers", "Jef");
	}

	@Test
	public void testConstructorZonderParameters() {
		Persoon persoon = new Persoon();
		assertEquals("onbekend", persoon.getNaam());
		assertEquals("onbekend", persoon.getVoornaam());
	}

	@Test
	public void testConstructorMetParameters() {
		assertEquals("Aers", persoon.getNaam());
		assertEquals("Jef", persoon.getVoornaam());
	}

	@Test
	public void testCopyConstructor() {
		persoon.setLengte(200);
		persoon.setGewicht(50);
		persoon.setGeboortejaar(1997);
		Persoon persoon2 = new Persoon(persoon);
		assertEquals(persoon.getNaam(), persoon2.getNaam());
		assertEquals(persoon.getVoornaam(), persoon2.getVoornaam());
		assertEquals(persoon.getGeboortejaar(), persoon2.getGeboortejaar());
		assertEquals(persoon.getLengte(), persoon2.getLengte(), 0);
		assertEquals(persoon.getGewicht(), persoon2.getGewicht(), 0);

	}

	@Test
	public void testSetNaam() {
		persoon.setNaam("xxxx");
		assertEquals("xxxx", persoon.getNaam());
	}

	@Test
	public void testSetVoornaam() {
		persoon.setVoornaam("AAAA");
		assertEquals("AAAA", persoon.getVoornaam());
	}

	@Test
	public void testSetLengteMinderdan240cm() {
		persoon.setLengte(2.3);
		assertEquals(2.3, persoon.getLengte(), 0);
	}

	@Test
	public void testSetLengteMeerdan240cm() {
		persoon.setLengte(2.5);
		//assertEquals(2.4, persoon.getLengte(), 0);
	}

	@Test
	public void testSetGewicht() {
		persoon.setGewicht(25);
		assertEquals(25, persoon.getGewicht(), 0);
	}

	@Test
	public void testSetGeboortejaar() {
		persoon.setGeboortejaar(1995);
		assertEquals(1995, persoon.getGeboortejaar(), 0);
	}

	@Test
	public void testVoegVoornamenToe() {
		String [] voornamen = {"Sofie", "Robbe", "Hans"};
		persoon.voegVoornamenToe(voornamen);
		assertEquals("Jef Sofie Robbe Hans", persoon.getVoornaam());
	}

	@Test
	public void testToString() {
		persoon.setLengte(200);
		persoon.setGewicht(50);
		persoon.setGeboortejaar(1997);
		StringBuilder tekst = new StringBuilder(
				"Deze persoon is " + persoon.getVoornaam() + " " + persoon.getNaam() + "\n");
		tekst.append(String.format("%-15s : %.2f%n", "gewicht", persoon.getGewicht()));
		tekst.append(String.format("%-15s : %.2f%n", "lengte", persoon.getLengte()));
		tekst.append(String.format("%-15s : %d%n", "geboortejaar", persoon.getGeboortejaar()));
		assertEquals(tekst.toString(), persoon.toString());
	}

	@Test
	public void testBerekenBmi() {
		persoon.setLengte(1.5);
		persoon.setGewicht(50);
		assertEquals(50 / (1.5 * 1.5), persoon.berekenBMI(), 0);
	}

	@Test
	public void testGeefOmschrijvingBmiKleinerDan18() {
		persoon.setGewicht(17);
		persoon.setLengte(1);
		assertEquals("ondergewicht", persoon.geefOmschrijving());
	}

	@Test
	public void testGeefOmschrijvingBmi18() {
		persoon.setGewicht(18);
		persoon.setLengte(1);
		assertEquals("normaal", persoon.geefOmschrijving());
	}

	@Test
	public void testGeefOmschrijvingBmiTussen18en25() {
		persoon.setGewicht(19);
		persoon.setLengte(1);
		assertEquals("normaal", persoon.geefOmschrijving());
	}

	@Test
	public void testGeefOmschrijvingBmi25() {
		persoon.setGewicht(25);
		persoon.setLengte(1);
		assertEquals("overgewicht", persoon.geefOmschrijving());
	}

	@Test
	public void testGeefOmschrijvingBmiTussen25en30() {
		persoon.setGewicht(26);
		persoon.setLengte(1);
		assertEquals("overgewicht", persoon.geefOmschrijving());
	}

	@Test
	public void testGeefOmschrijvingBmi30() {
		persoon.setGewicht(30);
		persoon.setLengte(1);
		assertEquals("obesitas", persoon.geefOmschrijving());
	}

	@Test
	public void testGeefOmschrijvingBmiTussen30en40() {
		persoon.setGewicht(35);
		persoon.setLengte(1);
		assertEquals("obesitas", persoon.geefOmschrijving());
	}

	@Test
	public void testGeefOmschrijvingBmi40() {
		persoon.setGewicht(40);
		persoon.setLengte(1);
		assertEquals("morbide obesitas", persoon.geefOmschrijving());
	}

	@Test
	public void testGetVoornaam() {
		assertEquals("Jef", persoon.getVoornaam());
	}

	@Test
	public void testGetNaam() {
		assertEquals("Aers", persoon.getNaam());
	}

	@Test
	public void testLengte() {
		assertEquals(0, persoon.getLengte(), 0);
	}

	@Test
	public void testGetGewicht() {
		assertEquals(0, persoon.getGewicht(), 0);
	}

	@Test
	public void testGetGeboorteJaar() {
		assertEquals(0, persoon.getGeboortejaar());
	}

	@Test
	public void testGetLeeftijd() {
		persoon.setGeboortejaar(2000);
		assertEquals(17, persoon.getLeeftijd());
	}

	@Test
	public void testGroeiZonderArgumentenonder240cm() {
		persoon.groei();
		assertEquals(0.01, persoon.getLengte(), 0);
	}

	@Test
	public void testGroeiZonderArgumentenboven240cm() {
		persoon.setLengte(2.40);
		persoon.groei();
		assertEquals(2.4, persoon.getLengte(), 0);
	}

	@Test
	public void testGroeiMetArgumentenonder240cm() {
		persoon.groei(5);
		assertEquals(0.05, persoon.getLengte(), 0);
	}

	@Test
	public void testGroeiMetArgumentenboven240cm() {
		persoon.setLengte(2.40);
		persoon.groei(5);
		assertEquals(2.4, persoon.getLengte(), 0);
	}


}
