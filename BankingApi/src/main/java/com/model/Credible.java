package com.model;


import com.model.Credible;

/*
 * Interfaces are by default public and abstract. Not only that, but
 * methods on interfaces are also assumed to be public and abstract.
 * 
 * You cannot create an instance of an interface!
 * 
 * The first concrete class to inherit abstract methods will need to
 * implement them.
 */


public interface Credible {
	/*
	 * Interfaces can have fields, but they must be public, static, and
	 * final.
	 */
	
	public static final int num = 8;

	//This method is assumed to public and abstract
	void beFactual();
	
	void beCredible();
	
	/*
	 * If you want a method on an interface to have an implementation,
	 * you can do one of two things:
	 * 
	 * 1) Make the method static
	 * 2) Use the "default" keyword to provide a default implementation
	 */
	public static void concreteMethod() {
		
	}
	
	public default void concreteMethod2() {
		
	}


}
interface Accredible extends Credible{
	
	//You can redeclare an inherited concrete method as abstract.
	void concreteMethod();
}

