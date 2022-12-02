package ru.netology.domain;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String name ){
        super("Player with this name doesn't exist");
    }
}
