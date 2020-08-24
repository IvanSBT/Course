package Shop;

public class Buy implements Runnable {
    Shop shop;

    public Buy(Shop shop) {
        this.shop=shop;
    }

    @Override
    public void run() {
        int i=0;
        while (shop.getCnt()<20){
            shop.add("Товар_" + String.valueOf(i++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
