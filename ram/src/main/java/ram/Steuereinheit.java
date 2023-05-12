package ram;

import java.util.Arrays;

public class Steuereinheit implements Commands{
	//ProgramCounter als Instanzvariable
//	private int programCounter;

	//Konstruktor
	Memory memory = new Memory(10);
	
	Steuereinheit() {
		// TODO Auto-generated constructor stub
	}

	//Method um Array in Speicher zu laden
	public void load(int[] program) {
		for (int i = 0; i<program.length;i++) {
			memory.memory[i] = program[i];
		}
	}
	

	//Methode zum Ausführen
	public void execute(String[] cmd) {
		for(int i = 1; i < cmd.length; i++) {
			String[] parts = cmd[i].split(" ");
			String opcode = parts[0];

			if(opcode != "HLT") {
				int index = Integer.parseInt(parts[1]);
				switch (opcode) {
				case "LDA":
					memory.LDA(index);
					outputMEM(memory.memory);
					break;
				case "STA":
					memory.STA(index);
					outputMEM(memory.memory);
					break;
				case "ADD":
					memory.ADD(index);
					outputMEM(memory.memory);
					break;
				case "SUB":
					memory.SUB(index);
					outputMEM(memory.memory);
					break;
				case "JMP":
					memory.JMP(index);
					i = memory.programCounter - 1;
					outputMEM(memory.memory);
					break;
				case "JMZ":
					memory.JMZ(index);
					i = memory.programCounter - 1;
					outputMEM(memory.memory);
					break;
				default:
					System.out.println("Ungültig " + cmd[i]);
				}
			}
			else {
				switch(opcode) {
				case "HLT":
					memory.HLT();
					return;
				default:
					System.out.println("Ungültig " + cmd[i]);
				}
			}	
		}
	}
	
	//Methode zur Auswertung welches Programm ausgeführt werden soll
	public void checkExec() {

	}
	
	private void outputCMD(String[] program) {
		System.out.println("+-----------------------+");
		System.out.println("|\tController\t|");
		System.out.println("+-----------------------+");
		System.out.println("|   Index   |   Value   |");
		System.out.println("+-----------------------+");
		for(int i = 0; i < program.length; i ++) {
			System.out.println("|\t" + i + "\t" + program[i] + "\t|");
		}
		System.out.println("+-----------------------+");
	}
	
	
	private void outputMEM(int[] input) {
		System.out.println("+-----------------------+");
		System.out.println("|\t  Memory   \t|");
		System.out.println("+-----------------------+");
		System.out.println("|\tAccumulator\t|");
		System.out.println("|\t    " + memory.accumulator + "   \t|");
		System.out.println("+-----------------------+");
		System.out.println("|   Index   |   Value   |");
		System.out.println("+-----------------------+");
		for(int i = 0; i < input.length; i ++) {
			System.out.println("|\t" + i + "\t" + input[i] + "\t|");
		}
		System.out.println("+-----------------------+");
	}
	
	public static void main(String[] args) {
		//Neues Controller Objekt
		Steuereinheit controller = new Steuereinheit();
		
		//Array mit Befehlen
		String [] multiplikation = {"HLT","LDA 3","ADD 1","STA 3","LDA 0","SUB 2","JMZ 0","STA 0","JMP 1"};
		String [] addition = {"HLT","LDA 0","ADD 1","STA 2","JMZ 0"};
		String [] subtraktion = {"HLT","LDA 0","SUB 1", "STA 2","JMZ 0"};
		String [] division = {"HLT","LDA 0","SUB 1","STA 0","LDA 3","SUB 2","JMZ 0","STA 3","JMP 1"};
		
		//Array für Memory Speicher
		int[] speicher = { 10, 2, 1, 5, 0, 0, 0, 0, 0, 0 };
		controller.load(speicher);
		controller.execute(division); //funktioniert nicht richtig .. JMP und JMP sind die auslöser
		
//		controller.outputCMD(multiplikation);

		
	
	
	}


@Override
public void LDA(int x) {
	// TODO Auto-generated method stub
	
}
@Override
public void LDI(int x) {
	// TODO Auto-generated method stub
	
}
@Override
public void STA(int x) {
	// TODO Auto-generated method stub
	
}
@Override
public void STI(int x) {
	// TODO Auto-generated method stub
	
}
@Override
public void ADD(int x) {
	// TODO Auto-generated method stub
	
}
@Override
public void SUB(int x) {
	// TODO Auto-generated method stub
	
}
@Override
public void JMP(int x) {
	// TODO Auto-generated method stub
	
}
@Override
public void JMZ(int x) {
	// TODO Auto-generated method stub
	
}
@Override
public void HLT() {
	// TODO Auto-generated method stub
	
}


}