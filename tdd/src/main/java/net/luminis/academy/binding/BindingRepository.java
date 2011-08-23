package net.luminis.academy.binding;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BindingRepository
{

	private final String template;

	private final Map<String, Binding> bindings = new HashMap<String, Binding>();

	public BindingRepository(String template)
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
			String variable = matcher.group(1);
			bindings.put(variable, new BindingWrapper(new UnBound(variable)));
		}

	}

	public Binding bind(String variable)
	{
		if (!bindings.containsKey(variable))
			bindings.put(variable, new BindingWrapper(new UnBound(variable)));
		return bindings.get(variable);
	}

	public String apply()
	{
		String result = template;
		for (Binding binding : bindings.values())
		{
			result = binding.apply(result);
		}
		return result;
	}
}

class BindingWrapper implements Binding
{
	private Binding binding;

	public BindingWrapper(Binding binding)
	{
		if (binding == null)
			throw new IllegalArgumentException();
		this.binding = binding;
	}

	@Override
	public Binding to(String value)
	{
		this.binding = this.binding.to(value);
		return this.binding;
	}

	@Override
	public String apply(String template)
	{
		return this.binding.apply(template);
	}
}
