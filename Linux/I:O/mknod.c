#include <stdio.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

#define PIPE_NAME "abc"
#define BUFFER_SIZE 1024

int main(int argc, char **argv)
{
    umask(0);
    int ret = mknod(PIPE_NAME, S_IFIFO | 0666, 0);
    if (ret == -1)
    {
        printf("mknod failed");
        return 0;
    }
    else
    {
        printf("mknod success");
    }

    while (1)
    {
        printf("waitting");
        FILE *fp = fopen(PIPE_NAME, "r");
        char buffer[BUFFER_SIZE];
        fgets(buffer, BUFFER_SIZE, fp);
        printf("%s", buffer);
        fclose(fp);
    }
}