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

#include <cpuid.h>

#include "net_adambruce_jcpuid_bridge_DefaultCPUIDBridge.h"

JNIEXPORT jobject JNICALL Java_net_adambruce_jcpuid_bridge_DefaultCPUIDBridge_getCPUIDNative
  (JNIEnv *env, jobject jobj, jint leaf) {
    // Class of return object
    jclass clazz = (*env)->FindClass(env, "net/adambruce/jcpuid/type/Result");

    // Constructor ID
    jmethodID cid = (*env)->GetMethodID(env, clazz, "<init>", "(IIIII)V");

    unsigned int status;
    unsigned int eax;
    unsigned int ebx;
    unsigned int ecx;
    unsigned int edx;
    status = __get_cpuid(leaf, &eax, &ebx, &ecx, &edx);

    // Create new CPUIDResult
    jobject newobj = (*env)->NewObject(env, clazz, cid, status, eax, ebx, ecx, edx);
    return newobj;
}