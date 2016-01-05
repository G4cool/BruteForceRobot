/* A simple server in the internet domain using TCP
 The port number is passed as an argument
 This version runs forever, forking off a separate
 process for each connection
 */
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <string.h>
#include <stdint.h>
#include <ApplicationServices/ApplicationServices.h>


void dostuff(int); /* function prototype */

//extern "C" {
void error(const char *msg)
{
    perror(msg);
    exit(1);
}
//}

//extern "C" {
int main(int argc, char *argv[])
{
    int sockfd, newsockfd, portno, pid;
    socklen_t clilen;
    struct sockaddr_in serv_addr, cli_addr;
    int count = 0;
    //int m;
    //char buffer2[256];
    //char str1[] = "exit";
    
    if (argc < 2) {
        fprintf(stderr,"ERROR, no port provided\n");
        exit(1);
    }
    sockfd = socket(AF_INET, SOCK_STREAM, 0);
    if (sockfd < 0)
        error("ERROR opening socket");
    bzero((char *) &serv_addr, sizeof(serv_addr));
    portno = atoi(argv[1]);
    serv_addr.sin_family = AF_INET;
    serv_addr.sin_addr.s_addr = INADDR_ANY;
    serv_addr.sin_port = htons(portno);
    if (bind(sockfd, (struct sockaddr *) &serv_addr,
             sizeof(serv_addr)) < 0)
        error("ERROR on binding");
    listen(sockfd,5);
    clilen = sizeof(cli_addr);
    ///*
    newsockfd = accept(sockfd,
                       (struct sockaddr *) &cli_addr, &clilen);
    if (newsockfd < 0)
        error("ERROR on accept");
    //*/
    while (1) {
        /*
        if (count == 0) {
            newsockfd = accept(sockfd,
                               (struct sockaddr *) &cli_addr, &clilen);
            if (newsockfd < 0)
                error("ERROR on accept");
        }
        */
        pid = fork();
        if (pid < 0)
            error("ERROR on fork");
        if (pid == 0)  {
            close(sockfd);
            dostuff(newsockfd);
            
            /*
            bzero(buffer2,256);
            m = read(newsockfd,buffer2,255);
            if (m < 0) error("ERROR reading from socket");
            if (strcmp(buffer2,str1) == 0) {
                //exit(0);
                break;
            }
            */
            //exit(0);
        }
        //else close(newsockfd);
        //printf("cmon");
        //count++;
        //printf("count: %d\n",count);
    } /* end of while */
    close(sockfd);
    return 0; /* we never get here */
}
//}

/******** DOSTUFF() *********************
 There is a separate instance of this function
 for each connection.  It handles all communication
 once a connnection has been established.
 *****************************************/
//extern "C" {
void dostuff (int sock)
{
    int n;
    char buffer[256];
    char str1[] = "exit";
    //std::string actualString = "exitThis";
    
    bzero(buffer,256);
    n = read(sock,buffer,255);
    if (n < 0) error("ERROR reading from socket");
    printf("Here is the message: %s\n",buffer);
    //wat
    //extern "C++" {
    /*
    extern "C++" std::string bufferString(buffer);
    
    extern "C++" if (bufferString == "exitThis") {
        //extern "C" {
        extern "C" printf("exited");
        extern "C" exit(0);
        //}
    }
    //}
     */
        
    if (strcmp(buffer,"exit\n") == 0) {
        printf("The program has exited.\n");
        exit(0);
        //break;
    }
    system(buffer);
    n = write(sock,"I got your message",18);
    if (n < 0) error("ERROR writing to socket");
}
//}



