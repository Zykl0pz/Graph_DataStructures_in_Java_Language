package data_structures.Extended;
import data_structures.Abstract.Node.AbstractNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ExtendedNode<E> extends AbstractNode<E> {

    // Node memory
    private Integer lastNumericIteratorChildNode;
    private ListIterator<ExtendedNode<E>> lastNativeIteratorChildNode;
    private ExtendedNode<E> lastVisitedChild;

    // Extended Methods

    @Override
    public void addChildNode(AbstractNode<E> childNode){
        childNodes.addLast((ExtendedNode<E>) childNode);
        refreshNativeIterator();
    }
    
    @Override
    public void removeChildNode(AbstractNode<E> childNode){
        childNodes.remove(childNode);
        refreshNativeIterator();
    }
    
    @Override
    public void removeChildNodes(){
        this.childNodes.clear();
        refreshNativeIterator();
    }


    public boolean isNode(){ return !(isRoot() && isLeaf()); }

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

    public void removeParentNode(){ this.parentNode = null;}

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
