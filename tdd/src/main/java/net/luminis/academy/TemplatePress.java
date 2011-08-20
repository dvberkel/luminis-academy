package net.luminis.academy;

import net.luminis.academy.binding.Binding;

public class TemplatePress
{
	private final String template;

	public TemplatePress()
	{
		this(null);
	}

	public TemplatePress(String template)
	{
		if (template == null)
			throw new IllegalArgumentException();

		this.template = template;
	}

	public String press()
	{
		return template;
	}

	public Binding bind(String substitution)
	{
		return new BindingRepository().bind(substitution);
	}
}

class BindingRepository
{
	public BindingRepository()
	{

	}

	public Binding bind(String substitution)
	{
		return null;
	}
}
