package collections.scjp.collections;

import java.util.ArrayList;
import java.util.List;

public class AdderGeneric {
	void insert(List<? extends Animal> l){
		//l.add(new Animal()); Error
	}
public static void main(String[] args) {
	List<? extends Animal> l = new ArrayList<Animal>();
	l.add(null);
	List<Dog> d = new ArrayList<Dog>();
	l = d;
	List<Object> o = new ArrayList<Object>();
	//l = o; error!!!
	List w = new ArrayList();
	l = w;
	List<? extends Animal> ld = new ArrayList<Dog>();
	ld = l;
}
	

private static class Animal{}
private static class Dog extends Animal{}
private static class Cat extends Animal{}
}