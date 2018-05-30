package vsim.riscv.hardware;

import vsim.utils.Colorize;


public final class Register {

    private int number;
    private int value;
    private int resetValue;
    private boolean editable;

    public Register(int number, int value, boolean editable) {
        this.number = number;
        this.value = value;
        this.resetValue = value;
        this.editable = editable;
    }

    public int getNumber() {
        return this.number;
    }

    public int getValue() {
        return this.value;
    }

    public int getResetValue() {
        return this.resetValue;
    }

    public boolean isEditable() {
        return this.editable;
    }

    public void setValue(int value) {
        if (this.editable)
            this.value = value;
    }

    public void setResetValue(int resetValue) {
        if (this.editable)
            this.resetValue = resetValue;
    }

    public void reset() {
        this.value = this.resetValue;
    }

    @Override
    public String toString() {
        return String.format(
            "%s [%s]",
            Colorize.green(String.format("X%d", this.number)),
            Colorize.red(String.format("0x%08x", this.value))
        );
    }

}