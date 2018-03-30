package fr.pizzeria.utils;

import java.lang.reflect.Field;

import fr.pizzeria.exception.UpdatePizzaException;

public class Validator {
	public static void check(Object o) {
		Class<?> cp = o.getClass();
		Field[] attribut = cp.getDeclaredFields();
		try
		{
			for(Field  attr : attribut)
			{
				attr.setAccessible(true);
				if(attr.isAnnotationPresent(Rule.class))
				{										
					
					
					Rule annotation = attr.getAnnotation(Rule.class);
					
					double min = annotation.min();
					
					
					if(min >= attr.getDouble(o))
					{
						throw new UpdatePizzaException("Prix inférieur à la marge benéficiaire");
					}
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
