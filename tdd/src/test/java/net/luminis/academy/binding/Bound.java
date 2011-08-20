package net.luminis.academy.binding;

public class Bound implements Binding
{

	private final String variable;

	private final String value;

	public Bound(String variable, String value)
	{
		if (variable == null || value == null)
			throw new IllegalArgumentException();
		this.variable = variable;
		this.value = value;
	}

	@Override
	public Binding to(String string)
	{
		return null;
	}

	@Override
	public String apply(String template)
	{
		return template.replaceAll(String.format("\\{\\{%s\\}\\}", variable), this.value);
	}
}
