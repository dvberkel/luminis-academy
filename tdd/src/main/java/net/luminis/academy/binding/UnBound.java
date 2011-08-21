package net.luminis.academy.binding;

public class UnBound implements Binding
{

	private final String variable;

	public UnBound(String variable)
	{
		if (variable == null)
			throw new IllegalArgumentException();
		this.variable = variable;
	}

	@Override
	public Binding to(String value)
	{
		return new Bound(variable, value);
	}

	@Override
	public String apply(String template)
	{
		throw new IllegalStateException();
	}

}
