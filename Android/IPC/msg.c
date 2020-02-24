#include <stdlib.h>  
#include <stdio.h>  
#include <string.h>  
#include <errno.h>  
#include <sys/types.h>  
#include <sys/ipc.h>  
#include <sys/msg.h>  
#include <sys/stat.h>  
  
typedef struct{  
    long mtype;  
    char buf[256];  
}MSG;  
  
int main()  
{  
    MSG msg;  
    key_t key;  
    int msgid, ret;  
    pid_t cpid;  
  
    if((key = ftok("/tmp", 0)) == -1){  
        perror("ftok");  
        exit(1);  
    }  
    if((msgid = msgget(key, S_IRUSR|S_IWUSR|IPC_CREAT|IPC_EXCL)) == -1){  
        perror("msgget");  
        exit(1);  
    }  
    printf("\nmsgid = %d\n", msgid);  
    if((cpid = fork()) < 0)  
    {  
        perror("fork");  
    }  
    else if(cpid > 0)  
    {  
        msgrcv(msgid, &msg, sizeof(MSG), 1, 0);  
        fprintf(stderr, "receive parent: %s\n", msg.buf);  
        msg.mtype = 2;  
        msgsnd(msgid, &msg, sizeof(MSG), 0);  
  
        wait(NULL);  
        ret = msgctl(msgid, IPC_RMID, NULL);  
        if(ret < 0)  
        {  
            perror("msgctl");  
        }  
        exit(0);  
    }  
    else  
    {  
        msg.mtype = 1;  
        gets(msg.buf);  
        msgsnd(msgid, &msg, sizeof(MSG), 0);  
        msgrcv(msgid, &msg, sizeof(MSG), 2, 0);  
        fprintf(stderr, "receive child: %s\n", msg.buf);  
  
        exit(0);  
    }  
}  