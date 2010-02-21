package jgravatar;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JGravatarTest {

	private Gravatar gravatar;

	@Before
	public void setup() {
		gravatar = new Gravatar();
	}

	@Test
	public void testGetImageUrlDefaults() {
		assertEquals("http://www.gravatar.com/avatar/3b3be63a4c2a439b013787725dfce802.jpg?d=404", gravatar.getUrl("iHaveAn@email.com"));
		assertEquals("http://www.gravatar.com/avatar/fa8771dec9da9299afed9ffce70c2c18.jpg?d=404", gravatar.getUrl("info@ralfebert.de"));
	}

	@Test
	public void testGetImageUrlSize() {
		gravatar.setSize(100);
		assertEquals("http://www.gravatar.com/avatar/3b3be63a4c2a439b013787725dfce802.jpg?s=100&d=404", gravatar.getUrl("iHaveAn@email.com"));
	}

	@Test
	public void testGetImageUrlRating() {
		gravatar.setRating(GravatarRating.PARENTAL_GUIDANCE_SUGGESTED);
		assertEquals("http://www.gravatar.com/avatar/3b3be63a4c2a439b013787725dfce802.jpg?r=pg&d=404", gravatar.getUrl("iHaveAn@email.com"));
	}

	@Test
	public void testGetImageUrlDefaultImage() {
		gravatar.setDefaultImage(GravatarDefaultImage.IDENTICON);
		assertEquals("http://www.gravatar.com/avatar/3b3be63a4c2a439b013787725dfce802.jpg?d=identicon", gravatar.getUrl("iHaveAn@email.com"));
	}

	@Test
	public void testGetImageUrlCombined() {
		gravatar = new Gravatar();
		gravatar.setSize(123);
		gravatar.setDefaultImage(GravatarDefaultImage.IDENTICON);
		assertEquals("http://www.gravatar.com/avatar/3b3be63a4c2a439b013787725dfce802.jpg?s=123&d=identicon", gravatar.getUrl("iHaveAn@email.com"));
	}

	@Test
	public void testDownload() {
		Gravatar g = new Gravatar();
		byte[] bytes = g.download("info@ralfebert.de");
		assertTrue("content present", bytes.length>100);

		assertNull("null for no gravatar by default", g.download("doesntexist@example.com"));

		g.setDefaultImage(GravatarDefaultImage.IDENTICON);
		bytes = g.download("info@ralfebert.de");
		assertTrue("content present", bytes.length>100);
	}

}