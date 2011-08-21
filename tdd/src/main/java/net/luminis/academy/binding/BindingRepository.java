package net.luminis.academy.binding;

public class BindingRepository
{

	private final String template;

	public BindingRepository(String template)
	{
		if (template == null)
			throw new IllegalArgumentException();

		this.template = template;
	}

	public Binding bind(String variable)
	{
		if (!template.contains(String.format("{{%s}}", variable)))
			throw new IllegalStateException();

		return new UnBound(variable);
	}
}
