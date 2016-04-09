package com.dp.absfactory;

/**
 * Created by prasanth on 12/3/16.
 */
public class ComputerFactoryB implements ComputerFactory {
    @Override
    public CPU getCPU() {
        return new CPUB();
    }

    @Override
    public Memory getMemory() {
        return new MemoryB();
    }
}
