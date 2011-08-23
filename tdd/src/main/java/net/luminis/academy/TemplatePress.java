package net.luminis.academy;

import net.luminis.academy.binding.Binding;
import net.luminis.academy.binding.BindingRepository;

public class TemplatePress
{
	private final BindingRepository bindingRepository;

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
		this.bindingRepository = new BindingRepository(template);
	}

	public String press()
	{
		return bindingRepository.apply();
	}

	public Binding bind(String substitution)
	{
		if (!template.contains(String.format("{{%s}}", substitution)))
			throw new IllegalStateException();

		return bindingRepository.bind(substitution);
	}
}