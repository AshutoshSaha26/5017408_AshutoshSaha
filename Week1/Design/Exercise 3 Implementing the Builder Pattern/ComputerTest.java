public class ComputerTest {
    public static void main(String[] args) {
        // Creating a high-end computer
        Computer highEndComputer = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("NVIDIA RTX 3080")
                .setPowerSupply("750W")
                .setMotherboard("ASUS ROG")
                .build();

        System.out.println("High-End Computer: " + highEndComputer);

        // Creating a mid-range computer
        Computer midRangeComputer = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setGPU("NVIDIA GTX 1660")
                .setPowerSupply("600W")
                .setMotherboard("MSI B450")
                .build();

        System.out.println("Mid-Range Computer: " + midRangeComputer);

        // Creating a budget computer
        Computer budgetComputer = new Computer.Builder()
                .setCPU("Intel i3")
                .setRAM("8GB")
                .setStorage("256GB SSD")
                .setGPU("Integrated")
                .setPowerSupply("500W")
                .setMotherboard("Gigabyte B360")
                .build();

        System.out.println("Budget Computer: " + budgetComputer);
    }
}
