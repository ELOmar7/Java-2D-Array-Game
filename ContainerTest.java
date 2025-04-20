import java.util.Scanner;

public class ContainerTest {
	
	public static String[][] terminal = new String[][]{
		{" ", " ", " ", "^", " "},
		{" ", " ", " ", " ", " "},
		{" ", " ", " ", "□", " "},
		{" ", "□", " ", "□", "□"},
		{"□", "□", "□", "□", "□"},
	};
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Legende\r\n"
				+ "^: Kran\r\n"
				+ "□: Container\n");
		
		String command;
		do {
			
			System.out.println("Containerterminal");
			Container.ausgabeCT(terminal);
			
			System.out.println("\nMenü\nW: Aufnehmen\nA: Links\n"
					+ "S: Ablegen\nD: Rechts\nX: Beenden");
			
			command = sc.next();
			
			//aufnehmen
			if(command.equals("W")) {
				Container.aufnehmen(terminal);
				
				System.out.println("Befehl: W\n");
			}
			//links
			if(command.equals("A")) {
				Container.bewegen(terminal);
				
				System.out.println("Befehl: A\n");
			}
			//ablegen
			if(command.equals("S")) {
				Container.ablegen(terminal);
				
				System.out.println("Befehl: S\n");
			}
			//rechts
			if(command.equals("D")) {
				Container.rechts = true;
				Container.bewegen(terminal);
				
				System.out.println("Befehl: D\n");
			}
			//beenden
			if(command.equals("X")) {
				sc.close();
				
				System.out.println("Befehl: X");

			} else if (!command.equals("X") & !command.equals("D") & !command.equals("S") & !command.equals("A") & !command.equals("W")) {
				System.out.println("Bitte Eingabe vom Menü nehmen.");
				sc.close();

			}
			
		} while (!command.equals("X"));
	}
}

