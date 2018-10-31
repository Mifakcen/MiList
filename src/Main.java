import List.MiList;

public class Main {
    public static void main(String[] args) {

        MiList list = new MiList();

        list.push(4);
        list.push(5);
        list.push(6);
        list.push(7);
        //list.inputList();
        /*list.pop();
        list.pop();
        list.pop();*/
        /*list.push(4);
        list.push(5);
        list.push(6);
        list.push(7);*/
        /*list.remove(0);
        list.remove(3);*/

        //list.remove(1);
        list.inputList();
        System.out.println( "\n"+list.inpytElement(list.get(1))+"\n");


        list.add(55,2);
        //list.remove(3);
        list.inputList();
        System.out.println( "\n"+list.inpytElement(list.get(2)));
        //list.inputList();
      /*  list.shift(7);
        list.shift(6);
        list.shift(5);
        list.shift(4);
        list.shift(3);
        list.inputList();
        System.out.println("Количество элементов : " + list.getSize());
        list.unshift();
        list.unshift();
        list.unshift();
        list.shift(46);
        list.inputList();
        System.out.println("Количество элементов : " + list.getSize());*/


    }
}
