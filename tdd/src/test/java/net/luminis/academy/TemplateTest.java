package net.luminis.academy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TemplateTest
{
	@Test
	public void shouldExist()
	{
		assertNotNull(TemplateEngine.class);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldFailWhenInstantiatedWithoutATemplate()
	{
		new TemplateEngine();
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldFailWhenInstantiatedWithoutANull()
	{
		new TemplateEngine(null);
	}

	@Test
	public void shouldReturnTemplateIfThereAreNoSubstitutions()
	{
		TemplateEngine templatePress = new TemplateEngine("Hello World!");

		assertEquals("Hello World!", templatePress.press());
	}

	@Test
	public void shouldReturnTemplateIfThereAreNoSubstitutionsForReal()
	{
		TemplateEngine templatePress = new TemplateEngine("Goodbye World!");

		assertEquals("Goodbye World!", templatePress.press());
	}

	@Test
	public void shouldBeAbleToBindSubstutitutions()
	{
		TemplateEngine templatePress = new TemplateEngine("Greetings {{species}}");
		templatePress.bind("species").to("Earthlings");

		assertEquals("Greetings Earthlings", templatePress.press());
	}

	@Test(expected = IllegalStateException.class)
	public void shouldNotBeAbleToBindVariableNotInTemplate()
	{
		TemplateEngine templatePress = new TemplateEngine("{{aVariable}}");

		templatePress.bind("otherVariable");
	}
}
