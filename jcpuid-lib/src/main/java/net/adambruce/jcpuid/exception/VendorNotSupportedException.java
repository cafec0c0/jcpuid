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

package net.adambruce.jcpuid.exception;

/**
 * Exception for when the platform CPUID has been requested, but we do not
 * have an appropriate CPUID instance for the system's processor vendor.
 */
public class VendorNotSupportedException extends Exception {

    /**
     * Create a new checked exception to capture exceptions that may get thrown
     * due to the library missing support for the system's processor vendor.
     *
     * @param message the detail message
     */
    public VendorNotSupportedException(final String message) {
        super(message);
    }
}
