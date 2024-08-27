package funwithjava8defaultmethods;

public interface Car {
    void setUpAWD(String awdDetails);

    default void log (String logMessage){
        System.out.println(logMessage);
    }

    static void print (String str){
        System.out.println(str);
    };
}
