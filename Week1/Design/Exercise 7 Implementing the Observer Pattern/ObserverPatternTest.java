public class ObserverPatternTest {
    public static void main(String[] args) {
        // Create the StockMarket (subject)
        StockMarket stockMarket = new StockMarket();
        
        // Create observers
        MobileApp mobileApp = new MobileApp();
        WebApp webApp = new WebApp();

        // Register observers
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Change stock price and notify observers
        stockMarket.setStockPrice(150.00);
        stockMarket.setStockPrice(155.50);

        // Deregister WebApp and change stock price
        stockMarket.deregisterObserver(webApp);
        stockMarket.setStockPrice(160.00);
    }
}
