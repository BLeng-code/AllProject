#include <sys/msg.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

typedef struct
{
    long type;
    char name[20];
    int age;
} Msg;

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
    long type;
    puts("请输入type:");
    scanf("%ld", &type);
    msgrcv(msgid, &msg, sizeof(msg) - sizeof(type), type, 0);
    printf("收到消息 %s， %d", msg.name, msg.age);
    return 0;
}



