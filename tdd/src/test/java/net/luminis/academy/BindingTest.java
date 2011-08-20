package net.luminis.academy;

import net.luminis.academy.binding.Binding;
import net.luminis.academy.binding.Bound;

import org.junit.Test;

public class BindingTest
{
	@Test(expected = IllegalArgumentException.class)
	public void shouldFailWithoutAVariable()
	{
		Binding binding = new Bound(null, "values");
	}
}
