package fr.pizzeria.utils;


import java.lang.reflect.Field;


public class StringUtils {
	public static String getAnnotation(Object o){
		Class<?> cp = o.getClass();
		Field[] attribut = cp.getDeclaredFields();
		String chaine = "";
		try
		{
			for(Field  attr : attribut)
			{
				attr.setAccessible(true);
				if(attr.isAnnotationPresent(ToString.class))
				{										
					
					
					ToString annotation = attr.getAnnotation(ToString.class);
					
					boolean uppercase = annotation.upperCase();
					String separateur = annotation.separateur();

					

					Object value = attr.get(o);
					
					
					if(uppercase == true)
					{
						chaine += value.toString().toUpperCase()+ separateur;
					}
					else
					{
						chaine += value.toString().toLowerCase()+ separateur;
					}
				}
			}
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return chaine;
	}

}
