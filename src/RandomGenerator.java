import java.util.ArrayList;
import java.util.Random;

class RandomGenerator {
    public static int randInt(int a, int b) {
        Random r = new Random();
        return (int) (a + r.nextFloat() * (b - a));
    }

    public static float rand() {
        Random r = new Random();
        return r.nextFloat();
    }

    public static int randIndex(ArrayList arr) {
        return RandomGenerator.randInt(0, arr.size() - 1);
    }

    public float rand(float a, float b) {
        Random r = new Random();
        return (a + r.nextFloat() * (b - a));
    }

}
