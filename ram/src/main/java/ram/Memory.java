package ram;

public class Memory implements Commands{
	
	//Speicher der RAM
	int[] memory;
	//Accumulator (Zwischenspeicher)
	int accumulator = 0;
	//ProgrammCounter
	int programCounter;
	//Halt
	boolean halt = false;
	
	//Konstruktor
	Memory(int size){
		memory = new int[size];
	}

	@Override
	public void LDA(int x) {
		//Lade den AC mit dem dem Inhalt von Speicheradresse x
		accumulator = memory[x];
		programCounter++;
	}
	@Override
	public void LDI(int x) {
		//Lade den AC indirekt mit dem Inhalt von Adresse x
		accumulator = memory[memory[x]];
		programCounter++;
	}
	@Override
	public void STA(int x) {
		//Speichere den Inhalt des AC an Speicheradresse x
		memory[x] = accumulator;
		accumulator = 0;
		programCounter++;
	}
	@Override
	public void STI(int x) {
		//Speichere den Inhalt des AC indirekt an Adresse x 
		memory[memory[x]] = accumulator;
		programCounter++;
	}
	@Override
	public void ADD(int x) {
		//Addiere den Inhalb von Adresse x zum AC
		accumulator += memory[x];
		programCounter++;
	}
	@Override
	public void SUB(int x) {
		//Subtrahiere den Inhalt von Adresse x vom AC
		accumulator -= memory[x];
		programCounter++;
	}
	@Override
	public void JMP(int x) {
		//Sprung zur Instruktion an Stelle X
		programCounter = x;
		
	}
	@Override
	public void JMZ(int x) {
		//Sprung zur Instruktion an Stelle X
		if (accumulator == 0) {
			programCounter = x;
		}	
		else {
			programCounter++;
		}
	}
	@Override
	public void HLT() {
		//Ausführung anhalten
		halt = true;
	}
}

