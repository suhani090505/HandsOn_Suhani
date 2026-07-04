package logging;

class Logger {
    private static Logger instance;
    private Logger(){
        System.out.println("Logger instance created and constructor is set private");
    }
    public static Logger getInstance(){
        if(instance==null) {
            instance = new Logger();
        }
        return instance;
    }


}
