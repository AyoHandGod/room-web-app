package dev.ayohandgod.roomwebapp.services;

import dev.ayohandgod.roomwebapp.data.RoomRepository;
import dev.ayohandgod.roomwebapp.models.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    private final RoomRepository repository;

    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    public List<Room> getAllRooms() {
        return repository.findAll();
    }

    public Room getById(long id) { return repository.findById(id).get(); }
}
