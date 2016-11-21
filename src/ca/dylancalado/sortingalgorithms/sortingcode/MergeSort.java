package ca.dylancalado.sortingalgorithms.sortingcode;

import java.util.Arrays;

/**
 * Logic for performing a merge sort.
 * 
 * @author Dylan
 */
public class MergeSort implements SortFacade
{
    public static void sort(SortParameters p)
    {
        int[] left = Arrays.copyOfRange(p.getArray(), 0, (p.getArray().length/2)-1);
        p.setLeftArray(left);
        int[] right = Arrays.copyOfRange(p.getArray(), (p.getArray().length/2), p.getArray().length-1);
        p.setRightArray(right);
   
        if(left.length > 1)
        {
            p.setArray(left);
            MergeSort.sort(p);//Sort left array segment.
        }
        if(right.length > 1)
        {
            p.setArray(right);
            MergeSort.sort(p);//Sort right array segment.
        }
        
        merge(p.getOriginalArray(), p.getLeftArray(), p.getRightArray());
    }
    
    public static void merge(int[] array, int[] leftArray, int[] rightArray)
    {
        int l = 0;
        int r = 0;
        
        for(int i = 0; i < array.length-1; ++i)
        {
            if(leftArray[l] < rightArray[r])
            {
                array[++i] = leftArray[++l];
            }
            else if(leftArray[l] > rightArray[r])
            {
                array[++i] = rightArray[++r];
            }
            else
            {
                array[++i] = leftArray[++l];
                array[++i] = rightArray[++r];
            }
        }
    }
}