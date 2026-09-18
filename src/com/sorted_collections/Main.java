package com.sorted_collections;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.06, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("cup", 13.50, 5);
        stockList.addStock(temp);

        temp = new StockItem("cup", 10.50, 1);
        stockList.addStock(temp);

        temp = new StockItem("chair", 5.10, 30);
        stockList.addStock(temp);

        temp = new StockItem("door", 60, 23);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 300);
        stockList.addStock(temp);

        temp = new StockItem("headphone", 30.5, 70);
        stockList.addStock(temp);

        temp = new StockItem("towel", 1.10, 7);
        stockList.addStock(temp);

        System.out.println(stockList);

        for(String s: stockList.Item().keySet()) {
            System.out.println(s);
        }

        Basket timsBasket = new Basket("Tim");
//        timsBasket.addBasket()
        System.out.println("Testing out baskets");
        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        sellItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        sellItem(timsBasket, "car", 1);
        if(sellItem(timsBasket, "car", 1) != 1) {
            System.out.println("We don't have enough car of that item");
        }
        sellItem(timsBasket, "spanner", 5);
        System.out.println(timsBasket);

        sellItem(timsBasket, "juice", 4);
        sellItem(timsBasket, "cup", 12);
        System.out.println(timsBasket);

        System.out.println(stockList);
        System.out.println("Printing out baskets");

//        temp = new StockItem("Pen", 1.12);
//        stockList.Item().put(temp.getName(), temp);
        stockList.Item().get("car").adjustStock(2000);
        stockList.Item().get("car").adjustStock(-1000);
        System.out.println(stockList);
        for (Map.Entry<String, Double> price: stockList.PriceList().entrySet()) {
            System.out.println(price.getKey() + " cost " + price.getValue());
        }
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        // retrieve item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.reserveStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }
        return 0;
    }

    public static int removeItem(Basket basket, String item, int quantity) {
        // retrieve item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreserveStock(item, quantity);
        }
        return 0;
    }

    public static void checkOut(Basket basket) {
        for (Map.Entry<StockItem, Integer> item: basket.Item().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }
}
