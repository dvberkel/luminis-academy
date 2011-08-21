package net.luminis.academy.binding;

public class BindingRepository
{

	public BindingRepository(String template)
	{
		if (template == null)
			throw new IllegalArgumentException();
	}

	public Binding bind(String variable)
	{
		throw new IllegalStateException();
	}
}
