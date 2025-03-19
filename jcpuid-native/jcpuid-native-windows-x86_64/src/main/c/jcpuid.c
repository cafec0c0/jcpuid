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

#include <intrin.h>

#include "net_adambruce_jcpuid_bridge_CpuidBridgeImpl.h"

JNIEXPORT jobject JNICALL Java_net_adambruce_jcpuid_bridge_CpuidBridgeImpl_executeCPUIDNative__I
  (JNIEnv *env, jobject jobj, jint leaf) {
    // Class of return object
    jclass clazz = (*env)->FindClass(env, "net/adambruce/jcpuid/type/CpuidResult");

    // Constructor ID
    jmethodID cid = (*env)->GetMethodID(env, clazz, "<init>", "(IIII)V");

    int registers[4];
    __cpuid(registers, leaf);

    // Create new CPUIDResult
    jobject newobj = (*env)->NewObject(env, clazz, cid, registers[0], registers[1], registers[2], registers[3]);
    return newobj;
}

JNIEXPORT jobject JNICALL Java_net_adambruce_jcpuid_bridge_CpuidBridgeImpl_executeCPUIDNative__II
  (JNIEnv *env, jobject jobj, jint leaf, jint subleaf) {
    // Class of return object
    jclass clazz = (*env)->FindClass(env, "net/adambruce/jcpuid/type/CpuidResult");

    // Constructor ID
    jmethodID cid = (*env)->GetMethodID(env, clazz, "<init>", "(IIII)V");

    int registers[4];
    __cpuidex(registers, leaf, subleaf);

    // Create new CPUIDResult
    jobject newobj = (*env)->NewObject(env, clazz, cid, registers[0], registers[1], registers[2], registers[3]);
    return newobj;
}