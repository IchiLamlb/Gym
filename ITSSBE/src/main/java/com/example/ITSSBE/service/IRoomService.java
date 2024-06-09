package com.example.ITSSBE.service;

import com.example.ITSSBE.entity.Room;

import java.util.List;

public interface IRoomService {
    Room addRoom(Room room);
    List<Room> getAllRooms();
    Room getRoom(int id);
    Room changeRoom(int id, Room room);
    Room deleteRoom(int id);
}
