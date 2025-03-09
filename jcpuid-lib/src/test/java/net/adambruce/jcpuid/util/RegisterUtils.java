/*
 * Copyright 2025 Adam Bruce
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
