import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static Map<String, Integer> mapToInt = new HashMap<>();
    public static Map<Integer, String> mapToString = new HashMap<>();

    public static void main(String[] args) {
        String FilePath = "src/Test.txt";

        ArrayList<ArrayList<int[]>> ListaAdyacencia = new ArrayList<ArrayList<int[]>>();

        Queue<Integer> Q = new PriorityQueue<Integer>();

        ListaAdyacencia = LeerArchivo(FilePath);


        System.out.println("Hello world!");
    }



    private static ArrayList<ArrayList<int[]>> LeerArchivo(String FilePath) {

        ArrayList<int[]> ListaNodos = new ArrayList<>();

        int Nodo[];

        try (Scanner scanner = new Scanner(new File(FilePath))) {
            while (scanner.hasNext()){

                String[] inputText = scanner.nextLine().split(" ");
                if(inputText.length != 1){
                    Nodo = new int[2];

                    int count=0;
                    for (int i = 1; i < inputText.length; i++){
                        System.out.print(inputText[i].toString()+" ");

                        if (isParsable(inputText[i].toString())){
                            Nodo[1] = Integer.parseInt(inputText[i].toString());
                            ListaNodos.add(Nodo);
                            Nodo = new int[2];
                        } else {
                            if (mapToInt.containsKey(inputText[i].toString())){
                                Nodo[0] = Integer.parseInt(mapToString.get(mapToInt.get(inputText[i].toString())));
                            }else {
                                mapToInt.put(inputText[i].toString(),count);
                                mapToString.put(count,inputText[i].toString());
                                Nodo[0] = mapToInt.get(inputText[i].toString());
                                count++;
                            }
                        }


                    }
                    Object[] a = new Object[ListaNodos.size()];
                    a = ListaNodos.toArray();
                    System.out.println();
                    System.out.println(a.toString());

                }

            }

            return null;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }
}

