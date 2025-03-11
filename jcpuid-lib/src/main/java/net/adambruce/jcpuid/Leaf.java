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

package net.adambruce.jcpuid;

/**
 * CPUID leaf constants.
 */
public final class Leaf {

    /** Leaf 0h (Basic CPUID function information). */
    public static final int LEAF_0H = 0x0;

    /** Leaf 01h (Basic CPUID information). */
    public static final int LEAF_01H = 0x1;

    /** Leaf 80000000h (Extended CPUID function information). */
    public static final int LEAF_80000000H = 0x80000000;

    private Leaf() {

    }

}
