package Hospital_Abdallah;

import java.util.ArrayList;

public class Room {

    private int roomNumber;
    private int floorNumber;
    private String roomType;

    private static ArrayList<Room> roomList = new ArrayList<>();

    public Room(int roomNumber, int floorNumber) {
        if (floorNumber < 1 || floorNumber > 5) {
            throw new IllegalArgumentException("Floor number must be between 1 and 5.");
        }
        this.roomNumber = roomNumber;
        this.floorNumber = floorNumber;
        this.roomType = determineRoomType(floorNumber);
    }

    private String determineRoomType(int floorNumber) {
        switch (floorNumber) {
            case 1: return "Reception";
            case 2: return "Emergency";
            case 3: return "Outsider Clinics";
            case 4: return "Operations";
            case 5: return "Patient Rooms";
            default:
                throw new IllegalArgumentException("Invalid floor number for room type.");
        }
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        if (roomNumber <= 0) {
            throw new IllegalArgumentException("Room number must be a positive integer.");
        }
        this.roomNumber = roomNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        if (floorNumber < 1 || floorNumber > 5) {
            throw new IllegalArgumentException("Floor number must be between 1 and 5.");
        }
        this.floorNumber = floorNumber;
        this.roomType = determineRoomType(floorNumber);
    }

    public String getRoomType() {
        return roomType;
    }

    public static void addRoom(Room room) {
        roomList.add(room);
    }

    public static void removeRoom(Room room) {
        roomList.remove(room);
    }

    public static ArrayList<Room> getAllRooms() {
        return new ArrayList<>(roomList);
    }

    @Override
    public String toString() {
        return String.format("Room [roomNumber=%d, floorNumber=%d, roomType=%s]", roomNumber, floorNumber, roomType);
    }
}
