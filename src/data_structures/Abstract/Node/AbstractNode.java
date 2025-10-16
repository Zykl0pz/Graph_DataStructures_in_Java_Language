package data_structures.Abstract.Node;

import data_structures.DataStructure;
import data_structures.Extended.ExtendedNode;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractNode<E> extends DataStructure implements AbstractNodeCapabilities {

    // Node body
    protected ExtendedNode<E> parentNode;
    protected E actualNodeValue;
    protected List<AbstractNode<E>> childNodes;

    public boolean isRoot(){ return parentNode == null; }
    public boolean isLeaf(){ return childNodes == null || childNodes.isEmpty(); }

    public boolean isInternalNode() { return !isRoot() && !isLeaf(); }

    public void addChildNode(AbstractNode<E> child) {
        if (this.childNodes == null) {
            this.childNodes = new LinkedList<>();
        }
        this.childNodes.addLast((ExtendedNode<E>) child);
        child.setParentNode((ExtendedNode<E>) this);
    }
    public void removeChildNode(AbstractNode<E> child) {
        if (this.childNodes != null) {
            this.childNodes.remove(child);
            child.setParentNode(null);
        }
    }
    public void removeChildNodes() {
        if (this.childNodes != null) {
            for (AbstractNode<E> child : this.childNodes) {
                child.setParentNode(null);
            }
            this.childNodes.clear();
        }
    }

    /**
     * // Pending for implementation
     public ExtendedNode<E> getFirstChildNode(){ return childNodes.getFirst(); }
     public ExtendedNode<E> getLastChildNode(){ return childNodes.getLast(); }
     */

    public AbstractNode() {
        this.parentNode = null;
        this.actualNodeValue = null;
        this.childNodes = new LinkedList<>();
    }

    public ExtendedNode<E> getParentNode() {
        return parentNode;
    }
    public void setParentNode(ExtendedNode<E> parentNode) {
        this.parentNode = parentNode;
    }

    public E getActualNodeValue() {
        return actualNodeValue;
    }
    public void setActualNodeValue(E actualNodeValue) {
        this.actualNodeValue = actualNodeValue;
    }

    public LinkedList<AbstractNode<E>> getChildNodes() {
        return childNodes;
    }
    public void setChildNodes(List<AbstractNode<E>> childNodes) {
        this.childNodes = childNodes;
    }
}
