package ram;

public interface Commands {
	
	public void LDA(int x);
	public void LDI(int x);
	public void STA(int x);
	public void STI(int x);
	public void ADD(int x);
	public void SUB(int x);
	public void JMP(int x);
	public void JMZ(int x);
	public void HLT();
	
}
