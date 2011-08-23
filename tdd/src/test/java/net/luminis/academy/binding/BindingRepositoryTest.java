package net.luminis.academy.binding;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BindingRepositoryTest
{
	@Test(expected = IllegalArgumentException.class)
	public void shouldFailWhenInstantiatedWithoutATemplate()
	{
		new BindingRepository(null);
	}

	@Test
	public void shouldBeCreatedWithATemplate()
	{
		assertNotNull(new BindingRepository("Hello World"));
	}

	@Test
	public void shouldBeAbleToBindASubstitutionWhichIsNotPresentInTemplate()
	{
		BindingRepository repository = new BindingRepository("{{aVariable}}");

		Binding binding = repository.bind("otherVariable");
	}

	@Test
	public void shouldBeAbleToBindVariableToAValue()
	{
		BindingRepository repository = new BindingRepository("{{aVariable}}");

		@SuppressWarnings("unused")
		Binding binding = repository.bind("aVariable").to("aValue");
	}

	@Test
	public void shouldBeAbleApplyAllBindingsToTheTemplate()
	{
		BindingRepository repository = new BindingRepository("{{greeting}} {{subject}}");

		repository.bind("greeting").to("Hello");
		repository.bind("subject").to("World");

		assertEquals("Hello World", repository.apply());
	}
}
