package model;

public interface Commands {


    int EXIT = 0;
    int ADD_POST = 1;
    int SARCH_POST = 2;
    int POSTS_BY_CATEGORY = 3;
    int PRINT_POST = 4;

    static void printCommands(){
        System.out.println("Please input " + EXIT + " ");
        System.out.println("Please input " + ADD_POST + " ");
        System.out.println("Please input " + SARCH_POST + " ");
        System.out.println("Please input " + POSTS_BY_CATEGORY + " ");
        System.out.println("Please input " +PRINT_POST+ "");
    }
}
