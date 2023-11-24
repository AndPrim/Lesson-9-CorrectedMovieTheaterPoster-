package ru.netology.movieManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoviePostersManagerTest {
    MoviePostersManager manager = new MoviePostersManager();

    @Test
    public void emptyPoster(){

        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addOneMovie(){

        manager.saveMovie("Film1");

        String[] expected = {"Film1"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addFiveMovie(){

        manager.saveMovie("Film1");
        manager.saveMovie("Film2");
        manager.saveMovie("Film3");
        manager.saveMovie("Film4");
        manager.saveMovie("Film5");

        String[] expected = {"Film1", "Film2", "Film3", "Film4", "Film5"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void lastFiveMovie(){

        manager.saveMovie("Film1");
        manager.saveMovie("Film2");
        manager.saveMovie("Film3");
        manager.saveMovie("Film4");
        manager.saveMovie("Film5");

        String[] expected = {"Film5", "Film4", "Film3", "Film2", "Film1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void lastOneMovie(){

        manager.saveMovie("Film1");
        manager.setLimit(1);

        String[] expected = {"Film1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addFiveMovielastThreeMovie(){

        manager.saveMovie("Film1");
        manager.saveMovie("Film2");
        manager.saveMovie("Film3");
        manager.saveMovie("Film4");
        manager.saveMovie("Film5");
        manager.setLimit(3);

        String[] expected = {"Film5", "Film4", "Film3"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addFiveMovielastZeroMovie(){

        manager.saveMovie("Film1");
        manager.saveMovie("Film2");
        manager.saveMovie("Film3");
        manager.saveMovie("Film4");
        manager.saveMovie("Film5");
        manager.setLimit(0);

        String[] expected = {};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addZeroMovielastFiveMovie(){


        manager.setLimit(5);

        String[] expected = {};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}