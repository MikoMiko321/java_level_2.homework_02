package geekbrains.java_level_2.homework_02;

//1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4, при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
// должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
//3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException, и вывести результат расчета.

class MyArraySizeException extends Exception {
    public MyArraySizeException(String message){
        super(message);
    }
}
class MyArrayDataException extends Exception {
    public MyArrayDataException(String message, int i, int j){
        super(message + " ["+i+"]"+"["+j+"]");
    }
}
public class Main {

    public static int arrayProcess(String arr[][]) throws MyArraySizeException, MyArrayDataException{
        int summ=0;
        if (arr.length!=4 || arr[0].length!=4){
            throw new MyArraySizeException("Wrong array size! Must be [4][4]");
        }
        for (int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                try{
                    summ = summ + Integer.parseInt(arr[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("Wrong data in the array element",i,j);
                }
            }
        }
        System.out.println("Success!");
        return summ;
    }

    public static void main(String[] args) /*throws MyArraySizeException, MyArrayDataException*/ {
	String[][] myStringArray = new String[][]{
            {"12","13","135","1234"},
            {"432","34","534","32"},
            {"56","1","342","342"},
            {"32","453","3454","564"}
            //,{"654","324","324","423"}
    };
	try {
        System.out.println(arrayProcess(myStringArray));
    } catch (MyArraySizeException e){
	    System.out.println(e.getMessage());
    }catch (MyArrayDataException e){
        System.out.println(e.getMessage());
    }
    }
}
