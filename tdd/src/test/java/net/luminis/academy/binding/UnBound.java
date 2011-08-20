package net.luminis.academy.binding;

public class UnBound implements Binding
{

	public UnBound(String variable)
	{
		if (variable == null)
			throw new IllegalArgumentException();
	}

	@Override
	public Binding to(String string)
	{
		return null;
	}

	@Override
	public String apply(String template)
	{
		throw new IllegalStateException();
	}

}
