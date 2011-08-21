package net.luminis.academy;

import net.luminis.academy.binding.Binding;
import net.luminis.academy.binding.BindingRepository;

public class TemplatePress
{
	private final BindingRepository bindingRepository;

	public TemplatePress()
	{
		this(null);
	}

	public TemplatePress(String template)
	{
		if (template == null)
			throw new IllegalArgumentException();

		this.bindingRepository = new BindingRepository(template);
	}

	public String press()
	{
		return bindingRepository.apply();
	}

	public Binding bind(String substitution)
	{
		return bindingRepository.bind(substitution);
	}
}