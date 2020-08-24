package Shop;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Shop {
    private ArrayList <String> list = new ArrayList <String>();

    private int cnt=0;

    public synchronized void  setCnt() {
        this.cnt++;
    }
    public synchronized int  getCnt() {
        return cnt;
    }


    Lock lock;
    Condition cond;

    public Shop(){
        lock = new ReentrantLock();
        cond = lock.newCondition();
    }

    public void add (String str){
        lock.lock();
        while (list.size()==5) {
            try {
                cond.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        list.add(str);
        System.out.println("Поставлено: " + str + ". Ассортимент: " + list);
        System.out.println();

        cond.signalAll();
        lock.unlock();
    }


    public void remove (){
        lock.lock();
        while (list.size()==0) {
            try {
                cond.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Товар для продажи: " +list.get(list.size()-1));
        list.remove(list.size()-1);
        this.setCnt();
        System.out.println("Продано товаров:" + this.getCnt() + ". Ассортимент:" + list);
        System.out.println();

        cond.signalAll();
        lock.unlock();
    }
}
