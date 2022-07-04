#include <stdio.h>
#include <stdlib.h>

double cube(double num);

int main()
{
    int accountBalance = 1500;
    char accountName[] = "Nesta";
    char accountID[] = "100027";
    accountLoggedIn();
    // accountFunction(10.0, 100.0);
    cube(4.0);
    // accountBalance("Big");
    printf("\nPick a number to cube: ");
    double value;
    scanf("%lf", &value);
    printf("Your number is %f\n", cube(value));
    if(accountBalance > 2000) {
        printf("Rich boy");
    } else {
        printf("Broke af");
    }
    printf("\n");
    printf("Would you like to add funds to your account?\n");
    char response[20];
    scanf("%s", &response);
    if(!strcmp("yes", response)) {
        printf("You typed yes");
    } else {
        printf("You typed no");
    }

    return 0;
}

void accountLoggedIn() {
    printf("You have successfully logged into your account.");
}

int accountBalance(char accountID[]) {
    return 0;
}

double cube(double num) {
    double result = num * num * num;
    return result;
}

void testingSuite(char characterOne[], char characterTwo[], char characterThree[]) {
    if(characterOne) printf("Is good");
}
