package RedBlackTrees.utils;


import RedBlackTrees.Node;
import RedBlackTrees.RedBlackTree;
import RedBlackTrees.services.MapInterface;

import java.lang.reflect.Field;

public class AdvancedGetters {

    public static int getNumOfElems(MapInterface<?, ?> tree) {
        String fieldNumOfElems = "nElems";
        try {
            Field field = tree.getClass().getDeclaredField(fieldNumOfElems);
            field.setAccessible(true);

            int numOfElems = field.getInt(tree);

            return numOfElems;

        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getNumOfElemsTree(RedBlackTree<?, ?> tree) {
        String fieldNumOfElems = "nElems";
        try {
            Field field = tree.getClass().getDeclaredField(fieldNumOfElems);
            field.setAccessible(true);

            int numOfElems = field.getInt(tree);

            return numOfElems;

        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isRed(Node node) {
        return node.isRed();
    }

    public static boolean isBlackRedTree(Node node) {
        if(node.getRight() == null) {
            return true;
        }
        if(node.getRight().isRed()) {
            return false;
        }
        return isBlackRedTree(node.getLeft()) && isBlackRedTree(node.getRight());
    }
    public static boolean isBlackRedTreeTwoRedLeft(Node node) {
        if(node.getLeft().getLeft() == null) {
            return true;
        }
        if(node.getLeft().isRed() && node.getLeft().getLeft().isRed()) {
            return false;
        }
        return isBlackRedTreeTwoRedLeft(node.getLeft()) && isBlackRedTreeTwoRedLeft(node.getRight());
    }


}
