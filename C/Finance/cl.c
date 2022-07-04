#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Welcome to your bank account, please use this menu to operate the program.\n");
    int endProgram = 0;
    int accountBalance = 0;

    while(endProgram == 0) {
        printMenu();
        char response[20];
        scanf("%s", &response);

        if(!strcmp("exit", response)) {
            printf("\nThanks for using this program, have a nice day.");
            endProgram = 1;
        }
        if(!strcmp("analyze", response)) {
            analyzeFunds(accountBalance);
        }
        if(!strcmp("remove", response)) {
            accountBalance = removeFunds(accountBalance);
        }
        if(!strcmp("add", response)) {
            accountBalance = addFunds(accountBalance);
        }
        if(!strcmp("balance", response)) {
            getBalance(accountBalance);
        }
    }

    return 0;
}

void printMenu() {
    printf("\n|          Menu          |\n");
    printf("Get balance  --> 'balance'\n");
    printf("Add funds    --> 'add'\n");
    printf("Remove funds --> 'remove'\n");
    printf("Analysis     --> 'analyze'\n");
    printf("Exit program --> 'exit'\n");
}

void getBalance(int balance) {
    printf("\nBalance: %d\n", balance);
}

int addFunds(int balance) {
    balance += 500;
    printf("\nAdd: %d\n", balance);
    return balance;
}

int removeFunds(int balance) {
    balance -= 500;
    printf("\nRemove: %d\n", balance);
    return balance;
}

void analyzeFunds(int balance) {
    printf("\nSalary estimation: %d", balance);
    printf("\nAnalyze: %d\n", balance);
}

void closeMenu() {

}
