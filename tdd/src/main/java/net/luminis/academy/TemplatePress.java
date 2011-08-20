package net.luminis.academy;

public class TemplatePress
{
	public TemplatePress()
	{
		this(null);
	}

	public TemplatePress(String template)
	{
		if (template == null)
			throw new IllegalArgumentException();
	}

	public String press()
	{
		return "Hello World!";
	}
}
