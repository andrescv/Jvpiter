package vsim.riscv.instructions.rtype;

import vsim.Globals;
import vsim.utils.Colorize;
import vsim.riscv.instructions.MachineCode;
import vsim.riscv.instructions.Instruction;
import vsim.riscv.instructions.InstructionField;


public final class Fcvtwus extends Instruction {

  public Fcvtwus() {
    super(
      Instruction.Format.R,
      "fcvt.wu.s",
      "fcvt.wu.s rd, frs1",
      "set rd = (int)(unsigned(frs1))"
    );
  }

  @Override
  public int getOpCode() {
    return 0b1010011;
  }

  @Override
  public int getFunct3() {
    return 0b111;
  }

  @Override
  public int getFunct5() {
    return 0b11000;
  }

  @Override
  public void execute(MachineCode code) {
    float value = Globals.fregfile.getRegister(code.get(InstructionField.RS1));
    int result;
    if (value < Integer.MIN_VALUE)
      result = 0;
    else if (value > Integer.MAX_VALUE || Float.isNaN(value))
      result = Integer.MAX_VALUE;
    else
      result = Math.round(value);
    Globals.regfile.setRegister(
      code.get(InstructionField.RD),
      result
    );
    Globals.regfile.incProgramCounter();
  }

  @Override
  public String disassemble(MachineCode code) {
    String op = this.getMnemonic();
    int rd = code.get(InstructionField.RD);
    int rs1 = code.get(InstructionField.RS1);
    return Colorize.cyan(String.format("%s x%d, f%d", op, rd, rs1));
  }

}
