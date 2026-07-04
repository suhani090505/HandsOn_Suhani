public class Computer {
    private String cpu;
    private int RAM;
    private int storage;
    private String gpu;

    private Computer(Builder builder){
        this.cpu=builder.cpu;
        this.RAM=builder.RAM;
        this.storage=builder.storage;
        this.gpu=builder.gpu;
    }
    void display(){
        System.out.println("Cpu: "+cpu);
        System.out.println("RAM: "+RAM);
        System.out.println("Storage: "+storage);
        System.out.println("gpu: "+gpu);
    }

    public static class Builder{
       private String cpu;
       private int RAM;
       private int storage;
       private String gpu;
        public Builder setCpu(String cpu){
            this.cpu=cpu;
            return this;
        }
        public Builder setRAM(int RAM){
            this.RAM=RAM;
            return this;
        }
        public Builder setStorage(int storage){
            this.storage=storage;
            return this;
        }
        public Builder setGpu(String gpu){
            this.gpu=cpu;
            return this;
        }
        public Computer build() {
            return new Computer(this);
        }
    }
}
