#include <sys/shm.h>
#include <stdio.h>
#include <string.h>

int main(int argc, char const *argv[])
{
    int key = ftok("./msg", 1);
    int shm_id = shmget(key, 4096, IPC_CREAT | 0666);
    char *buffer = (char*)shmat(shm_id, NULL, 0);
    strcpy(buffer, "I AM LengBo");
    printf("%p", buffer);
    shmdt(buffer);
    return 0;
}
