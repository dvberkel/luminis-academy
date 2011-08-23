package net.luminis.academy;

import net.luminis.academy.binding.Binding;
import net.luminis.academy.binding.BindingRepository;

public class TemplateEngine
{
	private final BindingRepository bindingRepository;

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
		this.bindingRepository = new BindingRepository();
	}

	public String press()
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