package logging;

public class TestLogger {
    public static void main(String[] args){
        Logger logger1=Logger.getInstance();
        Logger logger2=Logger.getInstance();


        if(logger1==logger2){
            System.out.println("single instance of Logger created");
        }
        else{
            System.out.println("Multiple instances created");
        }
    }
}
