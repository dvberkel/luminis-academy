package net.luminis.academy;

import net.luminis.academy.binding.Binding;
import net.luminis.academy.binding.Bound;
import net.luminis.academy.binding.UnBound;

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

	@Test(expected = IllegalArgumentException.class)
	public void unBoundShouldFailWithoutAVariable()
	{
		Binding binding = new UnBound(null);
	}

	@Test
	public void unBoundShouldBeCreatedWithAVariable()
	{
		Binding binding = new UnBound("variable");

		assertNotNull(binding);
	}

	@Test(expected = IllegalStateException.class)
	public void unBoundFailsWhenItAppliesItself()
	{
		Binding binding = new UnBound("variable");

		binding.apply("template");
	}

	@Test
	public void unBoundCanCreateBoundToAValue()
	{
		Binding binding = new UnBound("variable");

		assertEquals(new Bound("variable", "value"), binding.to("value"));
	}
}
