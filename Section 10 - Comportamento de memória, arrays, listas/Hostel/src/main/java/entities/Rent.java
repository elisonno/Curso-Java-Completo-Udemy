package entities;

public class Rent {
    Person[] people = new Person [10];

    public void rentRoom(int room, String name, String email){
        people[room] = new Person(name, email);
    }

    public void showRentedRooms(){
        System.out.println("Busy rooms");
        for (int room =0; room<people.length; room++){
            if(people[room] != null){
                System.out.println(room + ": " + people[room]);
            }
        }
    }
}
