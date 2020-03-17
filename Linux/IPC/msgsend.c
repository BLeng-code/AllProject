#include <sys/msg.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include "msg.h"


int main(int argc, char const *argv[])
{
    int qid;
    key_t msgkey = ftok("./msg", '6');
    printf("%x", msgkey);
    int msgid = msgget(msgkey, IPC_CREAT | 0666);
    if (msgid < 0)
    {
        printf("msgget failed");
        return 0;
    }
    Msg msg;
    puts("请输入type name age:");
    scanf("%ld%s%d", &msg.type, msg.name, &msg.age);
    msgsnd(msgid, &msg, sizeof(msg) - sizeof(msg.type), 0);
    return 0;
}
