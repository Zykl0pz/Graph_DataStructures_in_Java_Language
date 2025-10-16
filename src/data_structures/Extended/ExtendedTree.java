package data_structures.Extended;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class ExtendedTree<E> {

    private ExtendedNode<E> rootNode;
    private ExtendedNode<E> actualNode;

    public ExtendedTree() {
        this.rootNode = new ExtendedNode<>();
        this.actualNode = rootNode;
    }
    public ExtendedTree(ExtendedNode<E> en) {
        this.rootNode = en;
        this.actualNode = rootNode;
    }

    // Experimental
    private ExtendedNode<E> nextNodePreOrder(){
        if (actualNode.hasNextChildNode()){
            actualNode = actualNode.nextChildNode();
        } else if (actualNode.isNode() || actualNode.isLeaf()){
            actualNode.resetIterators();
            actualNode = actualNode.getParentNode();
            actualNode = actualNode.nextChildNode();
        } else if (actualNode.isRoot()){
            actualNode = rootNode;
        }
        return actualNode;
    }
    public LinkedList<E> getValuesInPreOrder(){
        actualNode = rootNode;
        LinkedList<E> list = new LinkedList<>();
        boolean finished = false;
        int realizedVisits = 0;

        while (realizedVisits < rootNode.getChildNodesQuantity() && !finished){
            if(actualNode.isRoot()){ ++realizedVisits;}
            if(realizedVisits == rootNode.getChildNodesQuantity() + 1){ finished = true;}
            list.add(nextNodePreOrder().getActualNodeValue());
        }
        return list;
    }

    // TOO MUCH EXPERIMENTAL
    private ExtendedNode<E> nextNodePreOrderExperimental(){
        // Si el nodo actual tiene hijos, movemos al siguiente hijo
        if (actualNode.hasNextChildNode()){
            actualNode = actualNode.nextChildNode();
        }
        // Si no tiene más hijos, necesitamos retroceder en el árbol
        else {
            // Retrocedemos hasta encontrar un nodo con más hijos por visitar
            while (!actualNode.isRoot() && !actualNode.getParentNode().hasNextChildNode()) {
                actualNode = actualNode.getParentNode();
            }
            // Si llegamos a la raíz y no tiene más hijos, terminamos
            if (actualNode.isRoot() && !actualNode.hasNextChildNode()) {
                actualNode = null; // Indica que el recorrido ha terminado
            } else if (actualNode != null) {
                // Movemos al siguiente hermano
                actualNode = actualNode.getParentNode().nextChildNode();
            }
        }
        return actualNode;
    }
    public LinkedList<E> getValuesInPreOrderExperimental(){
        LinkedList<E> list = new LinkedList<>();
        actualNode = rootNode;
        list.add(actualNode.getActualNodeValue());
        resetAllIterators(rootNode);
        boolean finished = false;

        while(!finished){
            ExtendedNode<E> nextNode = nextNodePreOrderExperimental();
            if(nextNode != null){
                list.addLast(nextNode.getActualNodeValue());
            }
            else{
                finished = true;
            }
        }
        return list;
    }
    private void resetAllIterators(ExtendedNode<E> node) {
        if (node != null) {
            Deque<ExtendedNode<E>> stack = new ArrayDeque<>();
            stack.push(node);
            while (!stack.isEmpty()) {
                ExtendedNode<E> currentNode = stack.pop();
                currentNode.resetIterators();
                if (currentNode.getChildNodes() != null && !currentNode.getChildNodes().isEmpty()) {
                    for (int i = currentNode.getChildNodes().size() - 1; i >= 0; i--) {
                        stack.push(currentNode.getChildNodes().get(i));
                    }
                }
            }
        }
    }

    public E get(){ return actualNode.getActualNodeValue(); }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void addNode(int level){
    }
    public void addNode(){
    }

    public ExtendedNode<E> getRootNode() { return rootNode; }
    public void setRootNode(ExtendedNode<E> rootNode) { this.rootNode = rootNode; }

    public ExtendedNode getActualNode() { return actualNode; }

    //Not implemented add methods
    public void addNodePreOrder(){
    }
    public void addNodeInOrder(){
    }
    public void addNodePostOrder(){
    }
}
