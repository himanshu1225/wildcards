package example;

public class BoxGeneric<T> {
    T length;
    T height;

    public BoxGeneric(T length, T height) {
        this.length = length;
        this.height = height;
    }

    public T getLength() {
        return length;
    }

    public void setLength(T length) {
        this.length = length;
    }

    public T getHeight() {
        return height;
    }

    public void setHeight(T height) {
        this.height = height;
    }

    // generic method
    public <G> void printGeneric(G value){
        System.out.println("Printing value: "+ value);
    }
}
