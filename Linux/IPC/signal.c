#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

void signal_handler(int signo)
{
    switch (signo)
    {
    case SIGINT:
        printf("收到Ctrl+C信号  %d", signo);
        break;
    case SIGTERM:
        printf("收到kill信号  %d", signo);
        break;
    default:
        printf("收到未知信号  %d", signo);
        break;
    }
    exit(EXIT_SUCCESS);
}

int main(int argc, char const *argv[])
{
    // 处理用户产生中断的信号，ctrl+c
    if (signal(SIGINT, signal_handler) == SIG_ERR)
    {
        printf("不能处理信号");
    }

    // kill()发出的终止信号
    if (signal(SIGTERM, signal_handler) == SIG_ERR)
    {
        printf("不能处理信号");
    }
    while (1)
    {
        pause();
    }
    return 0;
}
