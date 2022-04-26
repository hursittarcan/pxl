package be.pxl.h5.oefening1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GemeenteTest {
	private Gemeente gemeente;

	@Before
	public void init() {
		gemeente = new Gemeente(3500, "Hasselt");
	}

	@Test
	public void testConstructorMetAlleEigenschappen() {
		assertEquals("Fout bij de postcode", 3500, gemeente.getPostcode());
		assertEquals("Fout bij de gemeente", "Hasselt", gemeente.getGemeenteNaam());

	}

	@Test
	public void testGetPostcode() {
		assertEquals("Fout bij de gemeente", 3500, gemeente.getPostcode());
	}

	@Test
	public void testGetGemeente() {
		assertEquals("Fout bij de gemeente", "Hasselt", gemeente.getGemeenteNaam());
	}

	@Test
	public void testSetPostcode4karakters() {
		gemeente.setPostcode(3020);
		assertEquals(3020, gemeente.getPostcode());
	}

	@Test
	public void testSetPostcodeMeerdan4karakters() {
		gemeente.setPostcode(3020523);
		assertEquals(3020, gemeente.getPostcode());
	}

	@Test
	public void testSetPostcodeMinderdan4karakters() {
		gemeente.setPostcode(30);
		assertEquals(3000, gemeente.getPostcode());
	}

	@Test
	public void testSetGemeenteZonderSpatieZonderCijfer() {
		gemeente.setGemeenteNaam("tonGeren");
		assertEquals("Tongeren", gemeente.getGemeenteNaam());
	}

	@Test
	public void testSetGemeenteMetSpatieZonderCijfer() {
		gemeente.setGemeenteNaam("HERK-DE Stad");
		assertEquals("Herk-De Stad", gemeente.getGemeenteNaam());
	}

	@Test
	public void testSetGemeenteZonderSpatieMetCijfer() {
		gemeente.setGemeenteNaam("Has45se5l't");
		assertEquals("Hassel't", gemeente.getGemeenteNaam());
	}

}
