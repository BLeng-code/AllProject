#include <sys/sem.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

// union semun
// {
//     int val;
//     struct semid_ds *buf;
//     unsigned short *array;
// };

int sem_p(int semid);
int sem_v(int semid);
int sem_set(int semid);
void sem_del(int semid);

static int sem_id;
int main(int argc, char const *argv[])
{
    sem_id = semget((key_t)1234, 1, 0666 | IPC_CREAT);
    char op_char = 'o';
    if (argc > 1)
    {
        if (!sem_set(sem_id))
        {
            printf("创建信号失败");
            exit(EXIT_FAILURE);
        }
        op_char = 'x';
        sleep(5);
    }
    for (int i = 0; i < 10; i++)
    {
        if (!sem_p(sem_id))
        {
            printf("申请进入临界区失败");
            exit(EXIT_FAILURE);
        }
        printf("%c", op_char);
        fflush(stdout);
        sleep(2);
        printf("%c", op_char);
        fflush(stdout);
        if (!sem_v(sem_id))
        {
            printf("离开临界区失败");
            exit(EXIT_FAILURE);
        }
        sleep(2);
    }
    if (argc > 1)
    {
        sleep(5);
        sem_del(sem_id);
    }

    return 0;
}

int sem_p(int semid)
{
    // P元语，如果sv=0，则进程进入等待，如果sv>0，则进程进入临界区，sv减去1
    struct sembuf sem_b;
    sem_b.sem_num = 0;
    sem_b.sem_op = -1;
    sem_b.sem_flg = SEM_UNDO;
    if (semop(semid, &sem_b, 0) == -1)
    {
        printf("P 操作失败");
        return 0;
    }
    return 1;
}

int sem_v(int semid)
{
    // V元语，唤醒正在等待sv的进程，如果没有则sv加1
    struct sembuf sem_b;
    sem_b.sem_num = 0;
    sem_b.sem_op = +1;
    sem_b.sem_flg = SEM_UNDO;
    if (semop(semid, &sem_b, 0) == -1)
    {
        printf("V 操作失败");
        return 0;
    }
    return 1;
}

int sem_set(int semid)
{
    union semun sem_union;
    sem_union.val = 1;
    if (semctl(semid, 0, SETVAL, sem_union))
    {
        return 0;
    }
    return 1;
}

void sem_del(int semid)
{
    union semun sem_union;
    if (semctl(semid, 0, IPC_RMID, sem_union))
    {
        printf("删除成功");
        return;
    }
    printf("删除失败");
}
