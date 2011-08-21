package net.luminis.academy.binding;

import org.junit.Test;

public class BindingRepositoryTest
{
	@Test(expected = IllegalArgumentException.class)
	public void shouldFailWhenInstantiatedWithoutATemplate()
	{
		new BindingRepository(null);
	}
}
