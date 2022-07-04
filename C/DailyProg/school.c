#include <stdio.h>
#include <stdlib.h>

struct Student{
    char name[50];
    char major[50];
    int age;
    double gpa;
};

struct Professor{
    char name[50];
    char department[50];
};

struct Course{
    char courseName[50];
    char semester[50];
    int creditValue;
    int maxStudents;
    struct Student students[10];
};

int main()
{
    FILE *fpointer = fopen("employees.txt", "w");
    fprintf(fpointer, "Printing data into this file pogchamp");

    fclose(fpointer);

    struct Student student1;
    student1.age = 19;
    student1.gpa = 4.1;
    strcpy(student1.name, "Nesta");
    strcpy(student1.major, "Computer Science");
    printf("%s, %s\n", student1.name, student1.major);

    struct Student student2;
    student2.age = 29;
    student2.gpa = 4.0;
    strcpy(student2.name, "Caleb");
    strcpy(student2.major, "Electrical Engineering");
    printf("%s, %s\n", student2.name, student2.major);

    compareGPA(student1, student2);
    compareAge(student1, student2);

    struct Course course1;
    strcpy(course1.courseName, "Computer Science");
    strcpy(course1.semester, "Spring");
    course1.creditValue = 4;
    course1.maxStudents = 25;
    course1.students[0] = student1;
    printf("%s", course1.students[0].name);

    for(int i = 0; i < 10; i++) {
        printf("\n%d", i);
    }

    int nums[2][2] = {{1, 2}, {3, 4}};
    for(int i = 0; i < 2; i++) {
        for(int j = 0; j < 2; j++) {
            printf("\n%d", nums[i][j]);
        }
    }

    int notPointer = 25;
    int *isPointer = &notPointer;
    printf("\n%p is also %p\n", *&notPointer, *&isPointer);
    printf("%p is also", *&notPointer);

    return 0;
}

void compareGPA(struct Student student, struct Student student2) {
    if(student.gpa > student2.gpa) {
        printf("%s has the higher GPA", student.name);
    } else {
        printf("%s has the higher GPA", student2.name);
    }
}

void compareAge(struct Student student1, struct Student student2){
    if(student1.age > student2.age) {
        printf("\n%s is older than %s", student1.name, student2.name);
    } else if(student1.age == student2.age) {
        printf("\nThey're the same age!");
    } else {
        printf("\n%s is older than %s", student2.name, student1.name);
    }
}
