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
 * Operating systems supported by JCPUID.
 */
public enum OperatingSystem {

    /** The Linux operating system. */
    LINUX("linux"),

    /** The Windows operating system. */
    MACOS("macos"),

    /** The MacOS operating system. */
    WINDOWS("windows");

    /** The name of the operating system (used for locating native library). */
    private final String name;

    OperatingSystem(final String lookupName) {
        this.name = lookupName;
    }

    /**
     * Gets the name of the operating system for the purposes of locating the
     * native library on the class path.
     *
     * @return the name of the operating system
     */
    public String getLookupName() {
        return name;
    }
}
