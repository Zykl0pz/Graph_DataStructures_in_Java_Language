import data_structures._ActaullyStable.ExtendedNode;
import data_structures._ActaullyStable.ExtendedTree;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== TESTING ORIGINAL IMPLEMENTATION ===");

        // Crear árbol y nodos
        ExtendedTree<Integer> tree = new ExtendedTree<>();
        ExtendedNode<Integer> root = tree.getRootNode();
        root.setActualNodeValue(1);

        // Construir árbol de ejemplo:
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6

        // Crear nodos hijos
        ExtendedNode<Integer> node2 = new ExtendedNode<>();
        node2.setActualNodeValue(2);

        ExtendedNode<Integer> node3 = new ExtendedNode<>();
        node3.setActualNodeValue(3);

        ExtendedNode<Integer> node4 = new ExtendedNode<>();
        node4.setActualNodeValue(4);

        ExtendedNode<Integer> node5 = new ExtendedNode<>();
        node5.setActualNodeValue(5);

        ExtendedNode<Integer> node6 = new ExtendedNode<>();
        node6.setActualNodeValue(6);

        // Construir estructura del árbol
        root.addChildNode(node2);
        root.addChildNode(node3);

        node2.addChildNode(node4);
        node2.addChildNode(node5);

        node3.addChildNode(node6);

        // Establecer relaciones de parentesco
        node2.setParentNode(root);
        node3.setParentNode(root);
        node4.setParentNode(node2);
        node5.setParentNode(node2);
        node6.setParentNode(node3);

        // Test 1: Recorrido PreOrden con implementación original
        System.out.println("\n--- Test 1: Recorrido PreOrden Original ---");
        try {
            LinkedList<Integer> preOrderResult = tree.getValuesInPreOrderExperimental();
            System.out.println("Resultado PreOrden: " + preOrderResult);
            System.out.println("Tamaño del resultado: " + preOrderResult.size());
            System.out.println("Resultado esperado: [1, 2, 4, 5, 3, 6]");
        } catch (Exception e) {
            System.out.println("Error durante recorrido: " + e.getMessage());
            e.printStackTrace();
        }

        // Test 2: Verificar estructura del árbol
        System.out.println("\n--- Test 2: Estructura del Árbol ---");
        System.out.println("Raíz: " + root.getActualNodeValue());
        System.out.println("Hijos de raíz: " + root.getChildNodes().size());
        System.out.println("Hijos del nodo 2: " + node2.getChildNodes().size());
        System.out.println("Hijos del nodo 3: " + node3.getChildNodes().size());

        // Test 3: Verificar métodos de navegación
        System.out.println("\n--- Test 3: Navegación entre Nodos ---");
        System.out.println("¿Raíz es root? " + root.isRoot());
        System.out.println("¿Nodo 2 es root? " + node2.isRoot());
        System.out.println("¿Nodo 4 es leaf? " + node4.isLeaf());
        System.out.println("¿Nodo 3 es leaf? " + node3.isLeaf());

        // Test 4: Verificar iteradores
        System.out.println("\n--- Test 4: Estado de Iteradores ---");
        root.resetIterators();
        System.out.println("Iterador numérico raíz: " + root.getLastNumericIteratorChildNode());
        System.out.println("¿Raíz tiene siguiente hijo? " + root.hasNextChildNode());

        if (root.hasNextChildNode()) {
            ExtendedNode<Integer> firstChild = root.nextChildNode();
            System.out.println("Primer hijo: " + (firstChild != null ? firstChild.getActualNodeValue() : "null"));
        }

        // Debug: verificar estado antes del recorrido
        System.out.println("=== DEBUG PRE-RECORRIDO ===");
        root.debugIterators();
        root.debugChildNodes();
        node2.debugIterators();
        node3.debugIterators();

        // Test 5: Recorrido manual para comparar
        System.out.println("\n--- Test 5: Recorrido Manual ---");
        System.out.print("Recorrido manual esperado: [");
        System.out.print(root.getActualNodeValue() + ", ");
        System.out.print(root.getChildNodes().getFirst().getActualNodeValue() + ", ");
        System.out.print(root.getChildNodes().get(0).getChildNodes().get(0).getActualNodeValue() + ", ");
        System.out.print(root.getChildNodes().get(0).getChildNodes().get(1).getActualNodeValue() + ", ");
        System.out.print(root.getChildNodes().get(1).getActualNodeValue() + ", ");
        System.out.print(root.getChildNodes().get(1).getChildNodes().getFirst().getActualNodeValue() + "]");
        System.out.println();

        // Test 6: Probar el método getNextChildNode()
        System.out.println("\n--- Test 6: Método getNextChildNode() ---");
        root.resetIterators();
        System.out.println("Usando getNextChildNode():");
        ExtendedNode<Integer> nextChild;
        int count = 0;
        while (root.hasNextChildNode() && count < 10) { // límite para evitar loop infinito
            nextChild = root.getNextChildNode();
            if (nextChild != null) {
                System.out.println("Hijo " + count + ": " + nextChild.getActualNodeValue());
            } else {
                System.out.println("Hijo " + count + ": null");
            }
            count++;
        }

    }
}