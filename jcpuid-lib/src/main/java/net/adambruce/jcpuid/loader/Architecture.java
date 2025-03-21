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

package net.adambruce.jcpuid.loader;

/**
 * Architectures supported by JCPUID.
 */
public enum Architecture {

    /** 64-bit x86 Intel and AMD processors. */
    AMD64("x86_64"),

    /** 32-bit x86 Intel and AMD processors. */
    I386("x86");

    /** The name of the architecture (used for locating native library). */
    private final String name;

    Architecture(final String lookupName) {
        this.name = lookupName;
    }

    /**
     * Gets the name of the architecture for the purposes of locating the
     * native library on the class path.
     *
     * @return the name of the architecture
     */
    public String getLookupName() {
        return name;
    }
}
