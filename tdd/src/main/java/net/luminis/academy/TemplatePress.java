package net.luminis.academy;

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
		return new Binding();
	}

	class Binding
	{

		public void to(String value)
		{

		}

	}
}
