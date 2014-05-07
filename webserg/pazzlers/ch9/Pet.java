package webserg.pazzlers.ch9;

public class Pet {
	public final String name;
	public final String food;
	public final String sound;
	public Pet(String name, String food, String sound) {
		super();
		this.name = name;
		this.food = food;
		this.sound = sound;
	}
	public void eat(){
		System.out.println(name + ":Mmmmm, " + food);
	}
	public void play(){
		System.out.println(name + ": " + sound + " " + sound);		
	}
	public void sleep(){
		System.out.println(name + ": Zzzzzz");
	}
	public void live(){
		new Thread(new Runnable(){
			public void run() {
				while(true){
					eat();
					play();
					Pet.this.sleep();
				}
			}
		}).start();
	}
	public static void main(String[] args) {
		new Pet("Fido","beef","Woof").live();
	}
}
