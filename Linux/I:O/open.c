#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <unistd.h>
/**
 * 利用fork函数创建子进程，pipe方法必须在fork之前，保证父子进程具有相同的管道文件描述符
 * 子进程利用fd[1]向管道写入数据，父进程通过fd[0]读取管道数据
 * 
*/
#define BUFFER_SIZE 1024
int main(int args, char **argc)
{
    int fd[2];
    pipe(fd);
    int pid = fork();
    if (pid == -1)
    {
        printf("fork error");
        return 0;
    }
    if (pid == 0)
    {
        printf("child");
        close(fd[0]);
        int fds = open("test.txt", O_RDONLY);
        char buffer[BUFFER_SIZE];
        read(fds, &buffer, BUFFER_SIZE);
        write(fd[1], buffer, BUFFER_SIZE);
        close(fd[1]);
    }
    else
    {
        printf("parent");
        close(fd[1]);
        char buffer[BUFFER_SIZE];
        read(fd[0], &buffer, BUFFER_SIZE);
        printf("%s", buffer);
        close(fd[0]);
    }
}