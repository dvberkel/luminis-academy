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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
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
		UnBound other = (UnBound) obj;
		if (variable == null)
		{
			if (other.variable != null)
				return false;
		}
		else if (!variable.equals(other.variable))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return String.format("{{%s}}", variable);
	}

}
