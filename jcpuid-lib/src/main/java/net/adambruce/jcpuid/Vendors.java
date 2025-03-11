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
 * A list of supported vendor identifier strings.
 * These values are returned from all processors using leaf 0h.
 */
public final class Vendors {

    /** Vendor string for identifying Intel processors. */
    public static final String INTEL = "GenuineIntel";

    /** Vendor string for identifying AMD processors. */
    public static final String AMD = "AuthenticAMD";

    private Vendors() {

    }

}
