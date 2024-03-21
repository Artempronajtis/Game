package ru.netology.javaqa.Game.services;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super("Игрок" + name + " не найден");

    }

}
