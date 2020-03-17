public class PeopleProxy implements Shopping {

    private People people;

    PeopleProxy(People people){
        this.people = people;
    }

    @Override
    public void shopping() {
        System.out.println("收取手续费");
        people.shopping();
    }

}