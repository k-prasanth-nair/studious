package com.dp.absfactory;

/**
 * Created by prasanth on 12/3/16.
 */
public class ComputerFactoryA implements ComputerFactory {
    @Override
    public CPU getCPU() {
        return new CPUA();
    }

    @Override
    public Memory getMemory() {
        return new MemoryA();
    }
}
