package main.sorting;

/******************************************************************************
 * Instances of class MergeSort are ...
 *
 *
 * @author Krystof Saml
 * @version 1.00.0000
 */

public class MergeSort implements ISorting {

    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int left, int right) {
        if (left >= right) return;

        int middle = (left + right) / 2;
        sort(array, left, middle);
        sort(array, middle + 1, right);
        int[] bitonic = makeBitonic(array, left, middle, right);
        merge(array, bitonic, left);

    }

    private void merge(int[] array, int[] bitonic, int index) {
        int left = 0;
        int right = bitonic.length - 1;
        for (int i = 0; i < bitonic.length; i++) {
            array[i + index] = bitonic[left] < bitonic[right] ? bitonic[left++] : bitonic[right--];
        }
    }

    private int[] makeBitonic(int[] array, int start, int middle, int end) {
        int[] bitonic = new int[end - start + 1];

        for (int i = start; i <= middle; i++) {
            bitonic[i - start] = array[i];
        }
        for (int i = middle + 1; i <= end; i++) {
            bitonic[end - start + middle + 1 - i] = array[i];
        }

        return bitonic;
    }
    //== CONSTANT CLASS ATTRIBUTES =============================================
    //== VARIABLE CLASS ATTRIBUTES =============================================
    //== STATIC INITIALIZER BLOCK ==============================================
    //== CONSTANT INSTANCE ATTRIBUTES ==========================================
    //== VARIABLE INSTANCE ATTRIBUTES ==========================================
    //==========================================================================
    //== CONSTRUCTORS AND FACTORY METHODS ======================================
    //==========================================================================
    //== PUBLIC CLASS METHODS ==================================================
    //== PRIVATE CLASS METHODS =================================================
    //== ACCESS METHODS OF INSTANCES ===========================================
    //== PUBLIC METHODS OF INSTANCES ===========================================
    //== PRIVATE METHODS OF INSTANCES ==========================================
}
