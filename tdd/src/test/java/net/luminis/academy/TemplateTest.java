package net.luminis.academy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TemplateTest
{
	@Test
	public void shouldExist()
	{
		assertNotNull(TemplatePress.class);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldFailWhenInstantiatedWithoutATemplate()
	{
		new TemplatePress();
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldFailWhenInstantiatedWithoutANull()
	{
		new TemplatePress(null);
	}

	@Test
	public void shouldReturnTemplateIfThereAreNoSubstitutions()
	{
		TemplatePress templatePress = new TemplatePress("Hello World!");

		assertEquals("Hello World!", templatePress.press());
	}

	@Test
	public void shouldReturnTemplateIfThereAreNoSubstitutionsForReal()
	{
		TemplatePress templatePress = new TemplatePress("Goodbye World!");

		assertEquals("Goodbye World!", templatePress.press());
	}
}
