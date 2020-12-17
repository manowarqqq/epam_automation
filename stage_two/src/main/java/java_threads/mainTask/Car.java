package java_threads.mainTask;


public class Car {
    private Model name;
    private Color color;


    Car() {
        this.name = Model.randomModel();
        this.color = Color.randomColor();

    }


    @Override
    public String toString() {
        return "Car{" +
                "name=" + name +
                ", color=" + color +
                '}';
    }


}
