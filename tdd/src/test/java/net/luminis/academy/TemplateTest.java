package net.luminis.academy;

import org.junit.Test;

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
}
