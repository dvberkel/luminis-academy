package net.luminis.academy.binding;

import org.junit.Test;

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

	@Test(expected = IllegalStateException.class)
	public void shouldFailWhenAskedForASubstitutionWhichIsNotPresentInTemplate()
	{
		BindingRepository repository = new BindingRepository("{{aVariable}}");

		Binding binding = repository.bind("otherVariable");
	}
}
