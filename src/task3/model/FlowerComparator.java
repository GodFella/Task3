/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task3.model;

import task3.model.Flower;
import java.text.Collator;
import java.util.Comparator;

/**
 * Compares objects of class Flower
 * 
 * @author Gleb
 */
public class FlowerComparator implements Comparator {

    /* 
     * Compares objects of class Flower by comparing
     * fields 1) name 2) origin
     */
    @Override
    public int compare(Object f1, Object f2) {
        int result = Collator.getInstance().compare(
                ((Flower)f1).getName(), ((Flower)f2).getName());
        if (result == 0) {
            return Collator.getInstance().compare(
                ((Flower)f1).getOrigin(), ((Flower)f2).getOrigin());
        }
        return result;
    }
}
