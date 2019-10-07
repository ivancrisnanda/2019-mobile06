package id.ac.polinema.idealbodyweight.util;

public class BodyMassIndex {
    private float mass;
    private float height;
    private float BMI;


    public BodyMassIndex(float mass, float height) {
        this.mass = mass;
        this.height = height;
        this.calculate();
    }

    public void calculate() {
        this.BMI = this.mass / (this.height * this.height);
    }



    public String BMIRange() {
        String res = "";
        if (this.BMI < 18.50) {
            res = "Underweight";
        } else if (this.BMI >= 18.50 && this.BMI <= 24.99) {
            res = "Healty Weight";
        } else if (this.BMI > 25) {
            res = "Overweight";
        }
        return res;
    }
}
