#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdlib.h>

#define PIPE_NAME "abc"
#define BUFFER_SIZE 1024

int main(int argc, char **argv)
{
    FILE * fp = fopen(PIPE_NAME, "w");
    char buffer[BUFFER_SIZE] = "123456789";
    fputs(buffer, fp);
    fclose(fp);
}