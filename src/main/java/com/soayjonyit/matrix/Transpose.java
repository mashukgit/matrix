package com.soayjonyit.matrix;

import java.util.LinkedList;
import java.util.List;

public class Transpose {
    public <T> List<List<T>> transpose(List<List<T>> matrix) {
        int rowCount = matrix.size();
        int colCount = matrix.get(0).size();
        if (rowCount != colCount) {
            rowCount = colCount;
            colCount = matrix.size();
        }

        List<List<T>> transposeMatrix = new LinkedList<>();

        for (int i = 0; i < rowCount; i++) {
            List<T> row = new LinkedList<>();
            for (int j = 0; j < colCount; j++) {
                row.add(matrix.get(j).get(i));
            }
            transposeMatrix.add(row);
        }

        return transposeMatrix;
    }
}
