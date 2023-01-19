public class HolaMundo{
	public static void main(String args []){
		System.out.println("Hola Mundo");
		
		if(args.length == 0)
			System.out.println("Programa sin argumentos...");
		else
			for( int i = 0; i < args.length; i++)
				System.out.println("args["+ i + "]:" + args[i]);
	}
}