package simple.datastructures;

import java.util.Arrays;

public class ArrayExamples {

    //declare array with values
    static String[] carBrands = {"Audi", "Bmw", "Volvo", "Mercedes"};
    static int[] evenNumbers = {2, 4, 6, 8, 10};
    static double[] degrees = {0, 0.5, 1, 1.5, 2, 2.5};
    static int[] numbers = {10,2,1,8,7,3,4,5,9,7};


    //declare an empty array
    static String[] emptyArray = new String[5];
    static int[] emptyArrayInt = new int[5];
    static double[] emptyArrayDoubles = new double[5];

    //Declare two-dimensional array
    static String [][] carBrandsAndModels2D = {
            {"Audi", "Bmw", "Volvo", "Mercedes"},
            {"R7","X3","S60","CLK"}
    };

    public static void main(String[] args) {
        //getValueByIndex();
        //setValueByIndex();
        //outOfBoundsException();
        //iterateThroughAnArray();
        //getValueByIndexForTwoDimensionalArray();
        //setValueForTwoDimensionalArray();
        //loopOver2DArray();
        //loopOver3DArray();
        //sortAnArray();
    }

    public static void getValueByIndex(){
        System.out.println(carBrands[0]);
        System.out.println(evenNumbers[0]);
        System.out.println(degrees[5]);
    }

    public static void setValueByIndex(){
        System.out.println("Value for index 0 is: "+emptyArray[0]);
        emptyArray[0] = "new value";
        System.out.println("Value for index 0 is: "+emptyArray[0]);
    }

    public static void outOfBoundsException(){
        System.out.println("Size of the array is: "+ emptyArray.length);
        System.out.println(emptyArray[6]);
    }

    public static void iterateThroughAnArray(){
        for (int i = 0; i < carBrands.length; i++) {
            System.out.println("currentIndex is: "+i);
            System.out.println(carBrands[i]);
        }
    }
    //We are using two indexes. First one shows the row and second one the column.
    public static void getValueByIndexForTwoDimensionalArray(){
        System.out.println("Value in row 1/colum 1 is :"+ carBrandsAndModels2D[0][0]);
    }

    public static void setValueForTwoDimensionalArray(){
        System.out.println("Value in row 1/colum 1 is :"+ carBrandsAndModels2D[0][0]);
        carBrandsAndModels2D[0][0] = "Audi - changed";
        System.out.println("Value in row 1/colum 1 is :"+ carBrandsAndModels2D[0][0]);
    }

    public static void sortAnArray(){
        System.out.print("Order before the sorting: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]+" ");
        }

        System.out.println("");
        Arrays.sort(numbers);

        System.out.print("Order after the sorting: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]+" ");
        }
    }

    public static void loopOver2DArray(){
        for (int i = 0; i < carBrandsAndModels2D.length; i++){
            for (int j = 0; j < carBrandsAndModels2D[1].length; j++) {
                System.out.println("arr[" + i + "][" + j + "] = "
                        + carBrandsAndModels2D[i][j]);
            }
        }
    }

    public static void loopOver3DArray(){
        int[][][] array3D = { {{1, 2, 3, }, {3, 4}}, {{5, 6}, {7, 8}} };
        for(int i=0 ; i<array3D.length ; i++){
            for(int j=0 ; j<array3D[i].length ; j++){
                for(int k=0 ; k<array3D[i][j].length ; k++){
                    System.out.println("[" + i + "][" + j + "][" + k + "]:" + array3D[i][j][k]);
                }
            }
        }
    }
}