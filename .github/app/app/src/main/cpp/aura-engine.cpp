#include <jni.h>
#include <cmath>

extern "C"
JNIEXPORT jfloat JNICALL
Java_com_aura_zenith_NativeLib_processSample(JNIEnv *env, jobject thiz, jfloat sample, jfloat drive) {
    // 1. Calidez de Bulbos
    float x = sample * drive;
    float processed = (x > 0) ? tanhf(x) : x / (1.0f - x);
    
    // 2. Limitador de Seguridad
    if (processed > 0.95f) processed = 0.95f;
    if (processed < -0.95f) processed = -0.95f;
    
    return processed;
}
