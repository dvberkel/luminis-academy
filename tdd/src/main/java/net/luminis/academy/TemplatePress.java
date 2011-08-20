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
}
