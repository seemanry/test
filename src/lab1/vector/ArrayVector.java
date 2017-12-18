package lab1.vector;

public class ArrayVector {
    private double[] newArray;
    private int length;

    public ArrayVector() {
        newArray = new double[0];
        length = 0;
    }

    public ArrayVector(int length) {
        this.length = length;
        newArray = new double[length];
        for (int i = 0; i < length; i++)
            newArray[i] = 0;
    }

    public void add(double value) {
        length++;
        if (newArray.length - length == -1) {
            double[] tmp = newArray;
            newArray = new double[length*2];
            for (int i = 0; i < length - 1; i++)
                newArray[i] = tmp[i];
        }
        newArray[length-1] = value;
    }

    public double getElement(int index) {
        return newArray[index];
    }

    public void setElement(int index,double value) {
        newArray[index] = value;
    }


    public int getSize() {
        return length;
    }


    public double getMin() {
        double min = newArray[0];
        for (int i = 1; i < length; i++) {
            if (newArray[i] < min)
                min = newArray[i];
        }
        return min;
    }

    public double getMax() {
        double max = newArray[0];
        for (int i = 1; i < length; i++) {
            if (newArray[i] > max)
                max = newArray[i];
        }
        return max;
    }

    public int find(double value) {
        int i = 0;
        while ((i < length) && (newArray[i] != value))
            i++;
        if (i < length)
            return i;
        else
            return -1;
    }

    public double getAverage() {
        double summ = 0;
        for (int i = 0; i < length; i++)
            summ += newArray[i];
        if (length != 0)
            return summ / length;
        else
            return 0;
    }

    public double getNorm() {
        double norm = 0;
        for (int i = 0; i < length; i++)
            norm += newArray[i]*newArray[i];
        norm = Math.sqrt(norm);
        return norm;
    }

    public void sort() {
        boolean sorted = false;
        double tmp = 0;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < length - 1; i++)
                if (newArray[i] < newArray[i+1]) {
                    sorted = false;
                    tmp = newArray[i];
                    newArray[i] = newArray[i+1];
                    newArray[i+1] = tmp;
                }
        }
    }

    public static ArrayVector mult(ArrayVector vector, double value) {
        ArrayVector res = new ArrayVector();
        for (int i = 0; i < vector.length; i++)
            res.add(value*vector.newArray[i]);
        return res;
    }

    public static ArrayVector sum(ArrayVector one,ArrayVector two) {
        int len = one.length;
        if (one.length < two.length)
            len = two.length;
        ArrayVector res = new ArrayVector(len);
        for (int i = 0; i < one.length; i++)
            res.newArray[i] = one.newArray[i];
        for (int i = 0; i < two.length; i++)
            res.newArray[i] += two.newArray[i];
        return res;
    }

    public static double scalarMult(ArrayVector one,ArrayVector two) {
        double res = 0;
        if (one.length == two.length) {
            for (int i = 0; i < one.length; i++) {
                res += one.newArray[i] * two.newArray[i] ;
            }
        }
        return res;
    }
}