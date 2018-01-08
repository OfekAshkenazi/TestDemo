package demo.ofek.com.demos.Entities;

import java.util.ArrayList;

/**
 * Created by Android on 1/8/2018.
 */

public class User {
    private long id;
    private String name;
    private int age;
    private static ArrayList<User> mockList=new ArrayList<>();
    public User(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name=" + name  +
                ", age=" + age;
    }

    public static ArrayList<User> getMockUsersList(){
        if (mockList.isEmpty()){
            mockList.add(new User(1231,"Omri",15));
            mockList.add(new User(12144,"Rinat",60));
            mockList.add(new User(54547,"Itzhak",56));
            mockList.add(new User(7474,"Avi",80));
            mockList.add(new User(8878,"Eden",22));
        }
        return mockList;
    }
}
