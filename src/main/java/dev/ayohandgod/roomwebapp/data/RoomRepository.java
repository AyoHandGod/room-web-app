package dev.ayohandgod.roomwebapp.data;

import dev.ayohandgod.roomwebapp.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
