#include <sys/shm.h>
#include <stdio.h>

int main(int argc, char const *argv[])
{
    int key = ftok("./msg", 1);
    int shm_id = shmget(key, 4096, IPC_CREAT | 0666);
    char* buffer = (char*)shmat(shm_id, NULL, 0);
    printf("%s", buffer);
    shmdt(buffer);
    return 0;
}
