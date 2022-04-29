package com.myserieslist.serieslist.Exception;

public class SerieExistsInCategory extends RuntimeException{
    
    public SerieExistsInCategory(String message) {
        super(message);
    }
}
