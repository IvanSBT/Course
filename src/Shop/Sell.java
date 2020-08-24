package Shop;


public class Sell implements Runnable {

    Shop shop;

    public Sell(Shop shop) {
        this.shop=shop;
    }

    @Override
    public void run() {
        while (shop.getCnt()<20){

            shop.remove();

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
