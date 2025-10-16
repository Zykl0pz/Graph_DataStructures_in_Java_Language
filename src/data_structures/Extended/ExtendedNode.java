package data_structures.Extended;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ExtendedNode<E>{

    // Node body
    private ExtendedNode<E> parentNode;
    private E actualNodeValue;
    private LinkedList<ExtendedNode<E>> childNodes;

    // Node memory
    private Integer lastNumericIteratorChildNode;
    private ListIterator<ExtendedNode<E>> lastNativeIteratorChildNode;
    private ExtendedNode<E> lastVisitedChild;

    // Methods
    public boolean isRoot(){ return parentNode == null; }
    public boolean isNode(){ return !(isRoot() && isLeaf()); }
    public boolean isLeaf(){ return childNodes == null || childNodes.isEmpty(); }

    public void addChildNode(ExtendedNode<E> en){
        childNodes.addLast(en);
        refreshNativeIterator();
    }
    public void removeChildNode(E en){
        childNodes.remove(en);
        refreshNativeIterator();
    }
    public void removeChildNodes(){
        this.childNodes.clear();
        refreshNativeIterator();
    }

    public ExtendedNode<E> getFirstChildNode(){ return childNodes.getFirst(); }
    public ExtendedNode<E> getLastChildNode(){ return childNodes.getLast(); }

    private void resetNumericIterator(){ lastNumericIteratorChildNode = 0;}
    private void resetNativeIterator(){ lastNativeIteratorChildNode = childNodes.listIterator(); }
    public void resetIterators(){
        resetNumericIterator();
        resetNativeIterator();
    }
    private void refreshNativeIterator() {
        this.lastNativeIteratorChildNode = childNodes.listIterator(lastNumericIteratorChildNode);
    }

    public Integer getLastNumericIteratorChildNode() { return lastNumericIteratorChildNode; }
    public Iterator<ExtendedNode<E>> getLastNativeIteratorChildNode() { return lastNativeIteratorChildNode; }
    public ExtendedNode<E> getLastVisitedChild() { return lastVisitedChild; }

    public boolean hasNextChildNode(){ return lastNumericIteratorChildNode < childNodes.size() && lastNativeIteratorChildNode.hasNext(); }
    private ExtendedNode<E> getNextNumericIteratorChildNode(){ return hasNextChildNode() ? (childNodes.get(lastNumericIteratorChildNode++)) : (null); }
    private ExtendedNode<E> getNextNativeIteratorChildNode(){ return hasNextChildNode() ? (lastNativeIteratorChildNode.next()) : (null); }
    public ExtendedNode<E> nextChildNode(){
        if(hasNextChildNode()){
            lastVisitedChild = lastNativeIteratorChildNode.next();
            ++lastNumericIteratorChildNode;
        }
        return lastVisitedChild;
    }
    public ExtendedNode<E> getNextChildNode(){
        return hasNextChildNode() ? (childNodes.get(lastNumericIteratorChildNode)) : (null);
    }

    public Integer getActualNodeIndex(){ return parentNode.getLastNumericIteratorChildNode(); }
    public Integer getChildNodeIndex(){ return lastNumericIteratorChildNode; }

    public ExtendedNode<E> getParentNode() { return parentNode; }
    public void setParentNode(ExtendedNode<E> parentNode) { this.parentNode = parentNode; }
    public void removeParentNode(){ this.parentNode = null;}

    public E getActualNodeValue() { return actualNodeValue; }
    public void setActualNodeValue(E actualNodeValue) { this.actualNodeValue = actualNodeValue; }

    public LinkedList<ExtendedNode<E>> getChildNodes() { return childNodes; }
    public void setChildNodes(LinkedList<ExtendedNode<E>> childNodes) { this.childNodes = childNodes; }

    public Integer getChildNodesQuantity() { return childNodes.size(); }

    public ExtendedNode() {
        this.parentNode = null;
        this.actualNodeValue = null;

        this.childNodes = new LinkedList<>();
        this.lastNumericIteratorChildNode = 0;
        this.lastNativeIteratorChildNode = childNodes.listIterator();
    }
    public ExtendedNode(ExtendedNode<E> parentNode, E actualNodeValue, LinkedList<ExtendedNode<E>> childNodes, Integer lastChildNodeIterated) {
        this.parentNode = parentNode;
        this.actualNodeValue = actualNodeValue;
        this.childNodes = childNodes;
        this.lastNumericIteratorChildNode = lastChildNodeIterated;
    }

    // These methods are created for trace the ExtendedNode information and verify the node is working correctly
    public void debugIterators() {
        System.out.println("Node: " + actualNodeValue +
                ", numIterator: " + lastNumericIteratorChildNode +
                ", nativeHasNext: " + lastNativeIteratorChildNode.hasNext() +
                ", childCount: " + childNodes.size());
    }
    public void debugChildNodes() {
        System.out.println("Children of " + actualNodeValue + ":");
        for (int i = 0; i < childNodes.size(); i++) {
            System.out.println("  " + i + ": " + childNodes.get(i).getActualNodeValue());
        }
    }

}
