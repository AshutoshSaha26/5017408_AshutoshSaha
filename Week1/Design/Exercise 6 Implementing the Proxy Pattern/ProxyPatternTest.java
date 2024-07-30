public class ProxyPatternTest {
    public static void main(String[] args) {
        // Create proxy images
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Display image1 (will load from server and then display)
        image1.display();
        
        // Display image2 (will load from server and then display)
        image2.display();

        // Display image1 again (will not load from server, just display)
        image1.display();
    }
}
