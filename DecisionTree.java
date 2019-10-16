package TreePackage;
public class DecisionTree<T> extends BinaryTree<T> implements DecisionTreeInterface<T>
{
    BinaryNode<T> currentNode;
    public DecisionTree(T data)
    {
        this(data, null, null);
    }

    public DecisionTree(T data, DecisionTree<T> left, DecisionTree<T> right)
    {
        setTree(data, left, right);
    }

    @Override
    public T getCurrentData()
    {
        if (currentNode!= null)
        {
            return currentNode.getData();
        }
        return null;
    }

    @Override
    public void setCurrentData(T newData)
    {
        currentNode.setData(newData);
    }

    @Override
    public void setResponses(T responseForNo, T responseForYes)
    {
        currentNode.setLeftChild(new BinaryNode<>(responseForYes));
        currentNode.setRightChild(new BinaryNode<>(responseForNo));
    }

    @Override
    public boolean isAnswer()
    {
        return (!currentNode.hasLeftChild() && !currentNode.hasRightChild());
    }

    @Override
    public void advanceToNo()
    {
        if(currentNode.hasRightChild()) {
            currentNode = currentNode.getLeftChild();
        }
    }

    @Override
    public void advanceToYes()
    {
        if (currentNode.hasLeftChild()) {
            currentNode = currentNode.getRightChild();
        }
    }

    @Override
    public void resetCurrentNode()
    {
        currentNode = root;
    }

    @Override
    public void setTree(T rootData)
    {
        super.setTree(rootData);
        currentNode = root;
    }

    @Override
    public void setTree(T rootData, BinaryTreeInterface<T> leftTree, BinaryTreeInterface<T> rightTree)
    {
        super.setTree(rootData, leftTree, rightTree);
        currentNode = root;
    }
}
