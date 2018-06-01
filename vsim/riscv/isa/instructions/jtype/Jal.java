package vsim.riscv.isa.instructions.jtype;

import vsim.Globals;
import vsim.riscv.hardware.Register;


public final class Jal extends JType {

    public Jal() {
        super(
            "jal",
            "jal rd, imm",
            "set rd = pc + 4 and pc = pc + imm"
        );
    }

    @Override
    protected int compute(int imm) {
        Register pc = Globals.regfile.getProgramCounter();
        int oldPc = pc.getValue();
        pc.setValue(oldPc + imm);
        return oldPc + 4;
    }

}