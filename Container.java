public class Container {
	
	static boolean aufgenommen;
	static boolean rechts;
	//static boolean links;

	static int posS;
	//public static String[][] terminal;
	
	public static void kranPosition(String[][] terminal) {
		for(int i = 0; i < terminal[0].length; i++) {
			if(terminal[0][i] == "^") {
				posS = i;
				return;
			}
		}
	}
	
	public static void aufnehmen(String[][] terminal) {
		kranPosition(terminal);
		
		for (int i = 0; i < terminal.length; i++) {
			if(terminal[i][posS] == "□") {
				terminal[i][posS] = " ";
				terminal[1][posS] = "□";
				aufgenommen = true;
				return;
			}
		}
		System.out.println("Kein Container da.");
	}
	

	public static void bewegen(String[][] terminal) {
		kranPosition(terminal);

		if(aufgenommen == true) {
			if(rechts == true) {
				//grenze rechts
				if(posS < terminal[0].length - 1) {
					terminal[0][posS + 1] = "^";
					terminal[1][posS + 1] = "□";
					
					terminal[0][posS] = " ";
					terminal[1][posS] = " ";
					rechts = false;
					return;
				} else {
					System.out.println("Grenze rechts");
					rechts = false;
					return;
				}
			
			} else {
				//grenze links
				if(posS > 0) {
					terminal[0][posS - 1] = "^";
					terminal[1][posS - 1] = "□";
					
					terminal[0][posS] = " ";
					terminal[1][posS] = " ";
					return;
				} else {
					System.out.println("Grenze links");
					return;
				}
			}
			
			//nicht aufgenommen
		} else {
			if(rechts == true) {
				//grenze rechts
				if(posS < terminal[0].length - 1) {
					terminal[0][posS + 1] = "^";
					
					terminal[0][posS] = " ";
					rechts = false;
					return;
				} else {
					System.out.println("Grenze rechts");
					rechts = false;
					return;
				}
			
			} else {
				//grenze links
				if(posS > 0) {
					terminal[0][posS - 1] = "^";
					
					terminal[0][posS] = " ";
					return;
				} else {
					System.out.println("Grenze links");
					return;
				}
			}
			
		}
	}
	
	
	public static void ablegen(String[][] terminal) {
		kranPosition(terminal);
		
		if(terminal[2][posS] == "□") {
			System.out.println("Kran kann nicht abladen.");
			return;
		} else if(terminal[1][posS] == "□") { //pseudo aufgenommen check *
			for(int i = terminal.length - 1; i > 1; i--) {
				if(terminal[i][posS] == " ") {
					terminal[i][posS] = "□";
					terminal[1][posS] = " ";
					aufgenommen = false;
					return;
				}
			}
		}
		
		
	}
	
    public static void ausgabeCT(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                 System.out.print(array[i][j] + " ");
            }
            // Neue Zeile nach jeder Zeile im Array
            System.out.println();
        }
    }
	
	
}