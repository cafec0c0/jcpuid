package net.adambruce.jcpuid.util;

import net.adambruce.jcpuid.type.Register;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RegisterUtils {

    public static Register intRegister(int value) {
        Register register = mock(Register.class);
        when(register.getIntValue()).thenReturn(value);
        return register;
    }

    public static Register stringRegister(String value) {
        Register register = mock(Register.class);
        when(register.getStringValue()).thenReturn(value);
        return register;
    }

}
