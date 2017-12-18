import lab1.vector.ArrayVector;

class EnterPoint {
    public static void main(String[] s) {
        ArrayVector arr = new ArrayVector();
        arr.add(4.3);
        arr.add(1.2);
        arr.add(8.0);

        System.out.println("Вектор");
        for (int i = 0; i < arr.getSize(); i++) {
            System.out.print(arr.getElement(i));
            System.out.print(" ");
        }

        arr.sort();
        ArrayVector farr = ArrayVector.mult(arr,4.0);

        System.out.println(" ");

        System.out.println("Сортировка");
        for (int i = 0; i < arr.getSize(); i++) {
            System.out.print(arr.getElement(i));
            System.out.print(" ");
        }
        System.out.println(" ");

        System.out.println("Среднее арифметическое");
        System.out.println(arr.getAverage());

        System.out.println("Евклидова норма");
        System.out.println(arr.getNorm());

        System.out.println("Умножение вектора на число");
        for (int i = 0; i < farr.getSize(); i++) {
            System.out.print(farr.getElement(i));
            System.out.print(" ");
        }

        System.out.println("");

        farr.add(3.2);
        ArrayVector sarr = ArrayVector.sum(arr,farr);
        System.out.println("Сложение векторов");
        for (int i = 0; i < sarr.getSize(); i++) {
            System.out.print(sarr.getElement(i));
            System.out.print(" ");
        }

        System.out.println("");

        System.out.println("Скалярное произведение векторов");
        System.out.println(ArrayVector.scalarMult(farr,arr));

    }
}