package net.luminis.academy.binding;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BindingRepositoryTest
{
	@Test
	public void shouldBeAbleToBeCreated()
	{
		assertNotNull(new BindingRepository());
	}

	@Test
	public void shouldBeAbleToBindAVariable()
	{
		BindingRepository repository = new BindingRepository();

		Binding binding = repository.bind("otherVariable");
		assertNotNull(binding);
	}

	@Test
	public void shouldBeAbleToBindVariableToAValue()
	{
		BindingRepository repository = new BindingRepository();

		@SuppressWarnings("unused")
		Binding binding = repository.bind("aVariable").to("aValue");
	}

	@Test
	public void shouldBeAbleApplyAllBindingsToATemplate()
	{
		BindingRepository repository = new BindingRepository();

		repository.bind("greeting").to("Hello");
		repository.bind("subject").to("World");

		assertEquals("Hello World", repository.applyTo("{{greeting}} {{subject}}"));
	}
}
