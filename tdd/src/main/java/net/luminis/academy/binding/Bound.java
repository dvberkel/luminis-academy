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

	@Override
	public int hashCode()
	{
		final int prime = 37;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + ((variable == null) ? 0 : variable.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bound other = (Bound) obj;
		if (value == null)
		{
			if (other.value != null)
				return false;
		}
		else if (!value.equals(other.value))
			return false;
		if (variable == null)
		{
			if (other.variable != null)
				return false;
		}
		else if (!variable.equals(other.variable))
			return false;
		return true;
	}
}
