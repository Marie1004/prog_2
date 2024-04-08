interface onChangeListener {
    void onChange(A a);
}
class Listener implements onChangeListener {
    @Override
    public void onChange(A a) {
        // Event
        System.out.println("Listener is informed!");
    }
}
class A {
    private int x;
    private onChangeListener onChangeListener = null;
    public A() {
        this.x = 0;
    }
    public void setOnChangeListener(onChangeListener onChangeListener) {
        this.onChangeListener = onChangeListener;
    }
    private void notifyOnChangeListener() {
        this.onChangeListener.onChange(this);
    }
    public void setX(int x) {
        this.x = x;
        notifyOnChangeListener();
    }
    public int getX() {
        return this.x;
    }
}
public class MyTest {
    public static void main(String[] args) {
        A a = new A();
        a.setOnChangeListener(new Listener());
        a.setX(3); // Changed: 3
        a.setX(4); // Changed: 4
        a.setX(5); // Changed: 5
    }
}
