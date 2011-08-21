package net.luminis.academy.binding;

public interface Binding
{

	Binding to(String value);

	String apply(String template);

}
