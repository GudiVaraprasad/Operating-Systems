#include<stdio.h>

#include<stdlib.h>

#include<fcntl.h>

#include<sys/types.h>

#include<unistd.h>

#include<sys/stat.h>

#include<sys/wait.h>

int main() {

  int pipefds[2];
  // 0 -> read;
  // 1 -> write;

  if (pipe(pipefds) < 0) {
    printf("pipe creation error\n");
    exit(1);
  }

  if (fork()) {

    char x;

    close(1);
    close(pipefds[0]);

    while (read(0, & x, 1) > 0) {
      write(pipefds[1], & x, 1);
    }

    close(0);
    close(pipefds[1]);

    int status;
    while (wait( & status) > 0); // waiting for the child to terminate.

  } else {

    close(0);
    close(pipefds[1]);

    char x;
    // take input from user , write into pipe , read from pipe.
    // read represents reading from pipe not read from user.
    while (read(pipefds[0], & x, 1) > 0) // -> read return type number of bytes read. , max number of bytes to read at a time.
    // &x represents the address of the variable to store
    {
      write(1, & x, 1);
    }

    close(pipefds[0]);
    close(1);

  }
  return 0;
}
