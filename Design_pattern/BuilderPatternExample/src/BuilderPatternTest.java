public class BuilderPatternTest {

    public static void main(String[] args) {

        Computer gamingPC =
                new Computer.Builder()
                        .setCpu("Intel i9")
                        .setRAM(32)
                        .setStorage(1000)
                        .setGpu("RTX 4090")
                        .build();

        gamingPC.display();
    }
}