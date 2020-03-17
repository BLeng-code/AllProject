#include <sys/socket.h>
#include <stdio.h>
#include <netinet/in.h>
#include <string.h>
#include <unistd.h>

#define SERVER_PORT 20000
#define LENGTH_OF_LISTEN_QUEUE 10
#define BUFFER_SIZE 1024

int main(int argc, char const *argv[])
{
    int server_fd = socket(AF_INET, SOCK_STREAM, 0);
    if (server_fd < 0)
    {
        printf("socket 失败");
        return 0;
    }

    struct sockaddr_in my_addr;

    bzero(&my_addr, sizeof(my_addr));

    my_addr.sin_family = AF_INET;
    my_addr.sin_port = htons(SERVER_PORT);
    my_addr.sin_addr.s_addr = htons(INADDR_ANY);

    if (bind(server_fd, (struct sockaddr *)&my_addr, sizeof(my_addr)) < 0)
    {
        printf("bind 失败");
        return 0;
    }

    if (listen(server_fd, LENGTH_OF_LISTEN_QUEUE) < 0)
    {
        printf("listen 失败");
        return 0;
    }

    struct sockaddr_in cliaddr;
    int i = 0;
    while (1)
    {
        i++;
        printf("%d", i);
        char buf[BUFFER_SIZE];
        long timestamp;
        socklen_t length = sizeof(cliaddr);
        int clifd = accept(server_fd, (struct sockaddr *)&cliaddr, &length);
        if (clifd < 0)
        {
            printf("accept 失败");
            break;
        }

        strcpy(buf, "Welcome");
        printf(" from client , ");

        send(clifd, buf, BUFFER_SIZE, 0);
        close(clifd);
    }

    close(server_fd);
    return 0;
}
