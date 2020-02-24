#include <stdlib.h>  
#include <stdio.h>  
#include <string.h>  
#include <errno.h>  
#include <sys/types.h>  
#include <sys/ipc.h>  
#include <sys/msg.h>  
#include <sys/stat.h>  
#include <sys/shm.h>  
#include <unistd.h>  
  
int main()  
{  
    int shmid;  
    key_t key;  
    pid_t pid;  
    char *mem;  
  
  
    key = ftok("/home", '0');  
    fprintf(stderr, "key is : %d\n", key);  
    shmid = shmget(key, 4096, S_IRUSR|S_IWUSR|IPC_CREAT|IPC_EXCL);  
    if(shmid < 0)  
    {  
        perror("shmget");  
        exit(1);  
    }  
    else  
    {  
        fprintf(stderr, "shmid is : %d\n", shmid);  
    }  
    if((pid = fork()) < 0)  
    {  
        perror("fork");  
        exit(1);  
    }  
    else if(pid > 0)  
    {  
        mem = shmat(shmid, NULL, 0);  
        wait(NULL);  
        printf("shm text is : %s\n", mem);  
        shmdt(mem);  
        shmctl(shmid, IPC_RMID, NULL);  
        exit(0);  
    }  
    else  
    {  
        mem = shmat(shmid, NULL, 0);  
        gets(mem);  
        shmdt(mem);  
        exit(0);  
    }  
  
}  