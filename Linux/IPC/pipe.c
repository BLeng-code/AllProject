#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <unistd.h>
/**
 * 利用fork函数创建子进程，pipe方法必须在fork之前，保证父子进程具有相同的管道文件描述符
 * 子进程利用fd[1]向管道写入数据，父进程通过fd[0]读取管道数据
*/
#define BUFFER_SIZE 1024
int main(int args, char **argc)
{
    int fd[2];                                    // 管道创建参数，fd[0]用于读取数据，fd[1]用于写入数据
    pipe(fd);                                     // 创建管道
    int pid = fork();
    if (pid == -1)
    {
        printf("fork error");
        return 0;
    }
    if (pid == 0)
    {
        printf("child");                          // 子进程
        close(fd[0]);
        int fds = open("test.txt", O_RDONLY);
        char buffer[BUFFER_SIZE];
        read(fds, &buffer, BUFFER_SIZE);
        write(fd[1], buffer, BUFFER_SIZE);        // 利用fd[1]向管道写入数据
        close(fd[1]);
    }
    else
    {
        printf("parent");                         // 父进程
        close(fd[1]);
        char buffer[BUFFER_SIZE];
        read(fd[0], &buffer, BUFFER_SIZE);        // 从fd[0]中读取数据
        printf("%s", buffer);
        close(fd[0]);
    }
}