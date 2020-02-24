import java.io.Serializable;

class A implements Serializable {
    static final long serialVersionUID = 42L;
    transient int index;

    A(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "index is " + this.index;
    }

    @Override
    public void fromB() {
        System.out.println("from B");
    }
}