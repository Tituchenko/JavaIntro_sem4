import java.util.*;

public class Main {
    /*
    1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
    2. Реализуйте очередь с помощью LinkedList со следующими методами:
        enqueue() - помещает элемент в конец очереди,
        dequeue() - возвращает первый элемент из очереди и удаляет его,
        first() - возвращает первый элемент из очереди, не удаляя.
    3. Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. Используйте итератор
     */
    public static void main(String[] args) {
        String menu="";
        Boolean runAgain=true;
        do {
            menu=showMenu();
            switch (menu){
                case "1":
                    ex1();
                    break;
                case "2":
                    ex2();
                    break;
                case "3":
                    ex3(getRandomLinkedList(5, 10));
                    break;

                case "0":
                    System.out.println("До новых встреч!");
                    runAgain=false;
                    break;
                default:
                    System.out.println("Ошибка ввода пункта!");
                    break;
            }

        } while (runAgain);


    }
    static String showMenu(){
        System.out.println("Выберите задачу:");
        System.out.println("1.Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет"
                +" \"перевернутый\" список.");
        System.out.println("2.Реализуйте очередь с помощью LinkedList со следующими методами:\n" +
                "        enqueue() - помещает элемент в конец очереди,\n" +
                "        dequeue() - возвращает первый элемент из очереди и удаляет его,\n" +
                "        first() - возвращает первый элемент из очереди, не удаляя.");
        System.out.println("3.Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. " +
                "Используйте итератор");
        System.out.println("0.Закончить");
        Scanner scanner = new Scanner(System.in);
        String p = scanner.nextLine();
        return p;
    }
    static void ex3 (LinkedList<Integer> list){
        System.out.println("Список:");
        System.out.println(list);
        int sum=0;
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()){
            Integer integer = iterator.next();
            sum += integer;
        }
        System.out.println("Сумма элементов:");
        System.out.println(sum);
    }
/*
    2. Реализуйте очередь с помощью LinkedList со следующими методами:
        enqueue() - помещает элемент в конец очереди,
        dequeue() - возвращает первый элемент из очереди и удаляет его,
        first() - возвращает первый элемент из очереди, не удаляя.
 */
    static void ex2 (){
        MyQueue myQueue = new MyQueue();
        // Создадим случаный список из 5 элементов
        LinkedList<Integer> list = new LinkedList<>();
        list=getRandomLinkedList(5, 100);
        System.out.println("Список \"загнанный\" в наш класс:");
        System.out.println(list);
        //Загоним его в наш элемент нашего класса
        for (Integer integer : list) {
            myQueue.enqueue(integer);
        }
        System.out.println("Тест функции first() - возвращает первый элемент из очереди, не удаляя");
        System.out.println(myQueue.first());
        System.out.println("Добавим 100 в конец очереди через enqueue()");
        myQueue.enqueue(100);
        System.out.println("Тест функции dequeue() - возвращает первый элемент из очереди и удаляет его");
        System.out.println(myQueue.dequeue());
        System.out.println("Тест функции first() - возвращает первый элемент из очереди, не удаляя");
        System.out.println(myQueue.first());
        System.out.println("Тест функции dequeue() - возвращает первый элемент из очереди и удаляет его");
        System.out.println(myQueue.dequeue());

        for (int i = 0; i < 4; i++) {
            System.out.println(i+".Тест функции dequeue() - возвращает первый элемент из очереди и удаляет его");
            System.out.println(myQueue.dequeue());
        }
    }
//1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
    static void ex1(){
        LinkedList<Integer> list = new LinkedList<>();
        list=getRandomLinkedList(20, 100);
        System.out.println("Изначаьный LinekList:");
        System.out.println(list);
        System.out.println("\"Перевернутый\" LinekList:");
        System.out.println(revertLinkedList(list));
    }
    static LinkedList<Integer> revertLinkedList(LinkedList<Integer> list){
        LinkedList<Integer> result = new LinkedList<>();
        for (Integer integer : list) {
            result.addFirst(integer);
        }
        return result;
    }
    //Создание случайного списка длиной n, максимальное число Max
    static LinkedList<Integer> getRandomLinkedList(int n, int max){
        LinkedList<Integer> list=new LinkedList<>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            list.add(rand.nextInt(max+1));
        }
        return list;
    }
}