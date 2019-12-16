class SingleInstanceTest {
    private static SingleInstanceTest instance;

    static {
        instance = new SingleInstanceTest();
    }

    public SingleInstanceTest getInstance() {
        return instance;
    }
}
