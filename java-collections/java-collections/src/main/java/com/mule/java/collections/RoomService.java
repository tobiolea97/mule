package com.mule.java.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class RoomService {

    private Collection<Room> inventory;

    public RoomService() {
        this.inventory = new LinkedHashSet<>();
    }

    public void applyDiscount(final double discount) {

        //Reduces the rate of each room by the provided discount
        inventory.stream()
                .forEach(r -> r.setRate(r.getRate() * (1-discount)));

    }

    public Collection<Room> getRoomsByCapacity(final int requiredCapacity) {

        //Returns a new collection of rooms that meet or exceed the provided capacity
        Collection<Room> roomsWithEnoughCapacity = inventory.stream()
                .filter(r -> r.getCapacity() >= requiredCapacity)
                .collect(Collectors.toList());

        return roomsWithEnoughCapacity;

    }

    public Collection<Room> getRoomByRateAndType(final double rate, final String type){

        //Returns a new collection of rooms with a rate below the provided rate and that match the provided type
        Collection<Room> matches = inventory.stream()
                .filter(r -> r.getType().equals(type))
                .filter(r -> r.getRate() < rate)
                .collect(Collectors.toList());

        return matches;

    }

    public boolean hasRoom(Room room) {

        return this.inventory.contains(room);
    }

    public Room[] asArray() {

        return this.inventory.toArray(new Room[0]);
    }

    public Collection<Room> getByType(String type){

        Collection<Room> copy = new HashSet<>(this.inventory);
        copy.removeIf(r -> !r.getType().equals(type));
        return copy;

    }

    public Collection<Room> getInventory() {
        return new HashSet<>(this.inventory);
    }

    public void createRoom(String name, String type, int capacity, double price) {
        this.inventory.add(new Room(name, type, capacity, price));
    }

    public void createRooms(Room[] rooms) {
        this.inventory.addAll(Arrays.asList(rooms));
    }

    public void removeRoom(Room room) {
        this.inventory.remove(room);
    }

}

