import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Graph {
    private static HashMap<String, List<String>> neighbourList = new HashMap<>(); // Хеш-таблица которая хранит в себе ключи и значения. Каждому узлу (ключу) соответствует список соседей (значений).


    public static void addNode(String node) { // Метод который добавляет новые узлы.

        // Условие которое проверяет наличие узла, если его нет выводит сообщение и добавляет его в новый список.
        if(neighbourList.containsKey(node)) {
            System.out.println("Такой объект уже существует");
        } else {
            neighbourList.put(node, new ArrayList<>());
        }   
    }

    public static void addEdge(String node1, String node2) { // Метод который добавляет ребра. Связывает между собой узлы.

        //Проверяет, существуют ли оба узла в графе, и если да, добавляет их в списки соседей друг друга.
        if(neighbourList.containsKey(node1) && (neighbourList.containsKey(node2)) ) {
            neighbourList.get(node1).add(node2);
            neighbourList.get(node2).add(node1);
        } 
    }

    public static void printGraph() { // Метод который выводит на экран граф.

        // Цикл который проходится по всей хеш-таблице, и выводит на экран весь граф
        for(Map.Entry<String, List<String>> entry : neighbourList.entrySet()) {

            System.out.println(entry.getKey() + " -> " + entry.getValue()); // entry.getKey() берёт узел, entry.getValue() берёт его соседей.
        }
    }
        
    
    public static void main(String[] args) { // Точка входа в программу. Здесь создаются узлы, устанавливаются связи между ними и вызывается метод для вывода графа.
        
        // Узлы
        Graph.addNode("Broxy");
        Graph.addNode("Artorias");
        Graph.addNode("Manus");
        Graph.addNode("Lotrik");

        // Связываем их (добавляем ребра)
        Graph.addEdge("Broxy", "Artorias"); 
        Graph.addEdge("Artorias", "Manus");
        Graph.addEdge("Manus", "Lotrik");
        Graph.addEdge("Lotrik", "Artorias");

        Graph.printGraph(); // Вывод графа на экран
    }
} 