#include <jni.h>
#include <string>
#include "stdio.h"
#include <android/log.h>
#include "sys/stat.h"
#include "unistd.h"
#include "string.h"

#define LOG_TAG "LengBo_JNI"
#define PRINT(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__);
extern "C" JNIEXPORT jstring JNICALL
Java_com_lengbo_ndk_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    char buffer[1024] = "I am LengBo";
    printf("%s", "测试");
    int fd[2];
    pipe(fd);

    int pid = fork();
    if (pid == -1) {
        PRINT("fork失败")
    } else {
        if (pid == 0) {
            PRINT("child")
            while (1) {
                strcpy(buffer, "child write");
                write(fd[1], buffer, sizeof(buffer));
            }
        } else {
            PRINT("parent")
            strcpy(buffer, "parent write");
//            write(fd[1], buffer, sizeof(buffer));
//            while (1) {
//                read(fd[0], &buffer, 1024);
//                PRINT("%s", buffer)
//            }
        }
    }
    return env->NewStringUTF(buffer);
}
