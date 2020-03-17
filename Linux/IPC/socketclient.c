#include <stdio.h>
#include <netinet/in.h>
#include <string.h>
#include <unistd.h>

#define SERVER_PORT 20000
#define CLIENT_PORT 20001
#define LENGTH_OF_LISTEN_QUEUE 10
#define BUFFER_SIZE 1024

int main(int argc, char const *argv[])
{
    struct sockaddr_in servaddr, cliaddr;
    socklen_t socklen = sizeof(servaddr);
    char buf[BUFFER_SIZE];

    int clifd = socket(AF_INET, SOCK_STREAM, 0);
    if (clifd < 0)
    {
        printf(" socket 失败");
        return 0;
    }

    bzero(&cliaddr, sizeof(cliaddr));

    cliaddr.sin_family = AF_INET;
    cliaddr.sin_port = htons(CLIENT_PORT);
    cliaddr.sin_addr.s_addr = htons(INADDR_ANY);

    bzero(&servaddr, sizeof(servaddr));

    servaddr.sin_family = AF_INET;
    servaddr.sin_port = htons(SERVER_PORT);

    if (bind(clifd, (struct sockaddr *)&cliaddr, sizeof(cliaddr)) < 0)
    {
        printf("bind 失败");
        return 0;
    }
    if (connect(clifd, (struct sockaddr *)&servaddr, socklen) < 0)
    {
        printf("connect 失败");
        return 0;
    }
    while (1)
    {
        int length = recv(clifd, buf, BUFFER_SIZE, 0);
        if (length < 0)
        {
            printf("recv 失败");
            return 0;
        }
        printf("%s\n", buf);
        sleep(5);
    }

    return 0;
}
