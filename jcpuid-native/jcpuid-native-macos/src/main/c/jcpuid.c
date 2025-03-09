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