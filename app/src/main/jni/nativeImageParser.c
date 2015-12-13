#include <nativeImageParser.h>
#include <stdio.h>
#include <android/log.h>
#include <stdlib.h>

#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,   "JNI_DEBUGGING", __VA_ARGS__)

JNIEXPORT void JNICALL Java_com_rotlogix_sprayandspray_services_FileParserService_parseFile

(JNIEnv *env, jobject obj, jstring string)
{

     int fileName(const char *name) {
       printf("[*] Filename : %s", name);
       return 0;
     }

     struct chunk {
        char *file_chunk[255];
     };


    struct chunk *chunk = malloc(sizeof(chunk));
     /**
     * Convert Java String into C String
     */
    const char *path = (*env)->GetStringUTFChars(env, string, 0);
    (*env)->ReleaseStringUTFChars(env, string, path);

    int(*printFilename)(const char *fileName) = malloc(sizeof(printFilename));
    printFilename = fileName;

    LOGD("SprayAndPray : %s", path);

    FILE *fp = fopen(path, "rb");
    fseek(fp, 0, SEEK_END);
    long fsize = ftell(fp);
    fseek(fp, 0, SEEK_SET);

    if(fp != NULL) {
        LOGD("SprayAndPray : Opened : %s", path);
        fread(chunk->file_chunk, fsize, 1, fp);
        printFilename(path);
        fclose(fp);
    }

}
