package net.luminis.academy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.luminis.academy.binding.Binding;
import net.luminis.academy.binding.BindingRepository;

public class TemplateEngine
{
	private final BindingRepository bindingRepository = new BindingRepository();

	private final String template;

	public TemplateEngine()
	{
		this(null);
	}

	public TemplateEngine(String template)
	{
		if (template == null)
			throw new IllegalArgumentException();

		this.template = template;
		initialize();
	}

	private void initialize()
	{
		Pattern pattern = Pattern.compile("\\{\\{([^}]+)\\}\\}");
		Matcher matcher = pattern.matcher(template);
		while (matcher.find())
		{
			bindingRepository.bind(matcher.group(1));
		}
	}

	public String apply()
	{
		return bindingRepository.applyTo(template);
	}

	public Binding bind(String substitution)
	{
		if (!template.contains(String.format("{{%s}}", substitution)))
			throw new IllegalStateException();

		return bindingRepository.bind(substitution);
	}
}