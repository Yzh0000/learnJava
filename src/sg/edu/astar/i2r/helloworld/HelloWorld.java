package sg.edu.astar.i2r.helloworld;



public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		for (int i = 0; i< args.length; i++) {
			System.out.println("args[" + i + "] is: " + args[i]);
	    }

    }
}
