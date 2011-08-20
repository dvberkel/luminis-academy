package net.luminis.academy;

import net.luminis.academy.binding.Binding;
import net.luminis.academy.binding.Bound;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BindingTest
{
	@Test(expected = IllegalArgumentException.class)
	public void shouldFailWithoutAVariable()
	{
		Binding binding = new Bound(null, "values");
	}

	@Test(expected = IllegalArgumentException.class)
	public void boundShouldFailWithoutAVariable()
	{
		Binding binding = new Bound("variable", null);
	}

	@Test
	public void boundShouldBeCreatedWithAVariableAndAValue()
	{
		Binding binding = new Bound("variable", "value");

		assertNotNull(binding);
	}

	@Test
	public void boundShouldSubstituteValueForVariableInTemplate()
	{
		Binding binding = new Bound("species", "earthling");

		assertEquals("earthling", binding.apply("{{species}}"));
	}
}
