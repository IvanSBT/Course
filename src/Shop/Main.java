package Shop;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Старт");
        Shop shop=new Shop();

        Thread buyThread = new Thread(new Buy(shop));
        Thread sellThread = new Thread(new Sell(shop));

        sellThread.start();
        buyThread.start();

    }
}
