package ru.netology.movieManager;
public class MoviePostersManager {
    private String[] items = new String[0];


    private int limit;

    public MoviePostersManager(){
        this.limit = 5;
    }

    public MoviePostersManager(int Limit){
        this.limit = limit;
    }
    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void saveMovie(String item) {
        String[] tmp = new String[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public String[] findAll() {
        return items;
    }

    public String[] findLast() {
        int boxVolume;
        if (items.length < limit) {
            boxVolume = items.length;
        } else {
            boxVolume = limit;
        }
        String[] tmp = new String[boxVolume];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = items[items.length - (i + 1)];
        }
        return tmp;
    }
}
