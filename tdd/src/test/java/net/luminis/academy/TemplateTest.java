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

		assertEquals("Hello World!", templatePress.apply());
	}

	@Test
	public void shouldReturnTemplateIfThereAreNoSubstitutionsForReal()
	{
		TemplateEngine templatePress = new TemplateEngine("Goodbye World!");

		assertEquals("Goodbye World!", templatePress.apply());
	}

	@Test
	public void shouldBeAbleToBindSubstutitutions()
	{
		TemplateEngine templatePress = new TemplateEngine("Greetings {{species}}");
		templatePress.bind("species").to("Earthlings");

		assertEquals("Greetings Earthlings", templatePress.apply());
	}

	@Test(expected = IllegalStateException.class)
	public void shouldNotBeAbleToBindVariableNotInTemplate()
	{
		TemplateEngine templatePress = new TemplateEngine("{{aVariable}}");

		templatePress.bind("otherVariable");
	}

	@Test(expected = IllegalStateException.class)
	public void shouldFailIfNotAllVariablesAreBound()
	{
		TemplateEngine templateEngine = new TemplateEngine("{{aVariable}} {{otherVariabel}}");
		templateEngine.bind("aVariable").to("aValue");

		templateEngine.apply();
	}
}
