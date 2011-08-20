package net.luminis.academy.binding;

public interface Binding
{

	Binding to(String string);

	String apply(String template);

}
