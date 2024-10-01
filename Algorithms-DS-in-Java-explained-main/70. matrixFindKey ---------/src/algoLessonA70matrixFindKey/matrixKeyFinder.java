/*
SEARCH key IN A ROW AND COLUMN WISE (n*n)SORTED MATRIX  [ O(n) time complexity]

matrix is a 2d array: an array which stores data vertically and horizontally;

            0  1   2   ...x  
1d array: [10, 20, 30, ...data]


a 2d array is made of ROWS and COLS:		row == [i] pointer;       col == [j] pointer;

           colCurr:
                      0   1   2    3
2d array: [ rowCurr:     0   [10, 20, 30, 40],    // and it's sorted too on both axis/dimentions.
                 1   [11, 21, 31, 41],
                 2   [12, 22, 32, 43],
                 3   [15, 27, 38, 49]
]		

this 2d array is commonly referred to as MATRIX[][];
the SIZE of this matrix is 4: 4 rows * 4 columns;


I want to find a specific key x in this matrix: I need an algorithm.
the algorithm should be callable anytime I need, so I'll write it inside
a function.
// this algorithm works only for matrix sorted in both dimensions: vertical and horizontal;

- int matrix[i][j] = your current position in the matrix;    (i is the row and j is the col)
- at the beginning of the algorithm, is very important to set properly the correct starting partition position:
where you want to start to search from.
the row partition should be set at 0: you want to search from top to bottom, and as i increase
inside the while loop, you go down in the matrix;
so: i(or row of the matrix) = 0;

- the other pointer is j, we use it for the columns of the matrix, and we set j to size -1.
(why - 1? because matrix is zero-indexed just like arrays )
why j starts at 3 and not at 0?
because this matrix is sorted: otherwise the algorithm could be cumbersome an lengthy.
It may be counterintuitive, so I think it's worth explaining this in further details.
- suppose you have the same matrix as above, same size, same data in same partitions.
you look for a specific key inside the matrix:		
int key = 31;
if you set [i] pointer to 0, but [j] pointer to [size-1] as starting position,
matrix[i][j] is  40, so, matrix[i][j] is greater than key. 
IF this is true (and in our case IS true), decrease j by one, so that [j] pointer is the previous position.
now, the current partition matrix[i][j] is 30.
30 is less than 31: 31 HAS to be in this column. this matrix is sorted, so on your right, only values greater than 30,
but your previous position was 40, so it cannot be.
so the algorithm moves down, to the next row, but same column.
now, matrix[i][j] is 31. key is 31. so key is found.

- now suppos that starting position is 0 for both pointers: matrix[i][j] is 10.
10 is lower than 31, so you move to the next column. now [j] is 1.
matrix[i][j] is 20, which is lower than 30, so move to the next column. now [j] is 2.
matrix[i][j] is 30, which is lower than 31. BUT next column is 40, which is greater than 31.
so this algorithm should also check wether the next partition in column satisfies our search criteria.
it's just more lengthy.	

- "what if the key is not in the matrix? is there an infinite loop?"
infinite loop is avoided. while loop is based on AND condition: [i] and [j] both must point to valid partitions within the matrix.
if the current matrix partition is greater than the key, you keep moving in the same row to next left column.
otherwise, if previous condition is false and matrix partition is lower than the key, stay in the column but move one row below.
the latter condition is set as else statement so there are no limit and eventually [i] you will end to nullPointer partition.
so the while loop condition will be set to false the the loop is closed.

- simplified: if the partition is greater than the key, move left in the matrix. otherwise go below;




// this algorithm works in matrix which have same number of rows and cols;


public void searchKeyInMatrix(int[][] matrix, int sizeMatrix, int keyData) {
int rowCurr = size - size;		      // 
int colCurr = size - 1;           // matrix, just as common array, is 0-indexed;

while (rowCurr < size && colCurr >= size - size) {
	if (matrix[rowCurr][colCurr] == keyData) {
		System.out.println("found keyData " + keyData + " inside matrix.");
		return;
	}
	else {
		if (matrix[rowCurr][colCurr] > keyData) {
			colCurr = colCurr - 1;
		}
		else {
			rowCurr = rowCurr + 1;
		}
	}
}
System.out.println(keyData + " key not found.");
}

 */
package algoLessonA70matrixFindKey;

public class matrixKeyFinder {

	public void findKeyInMatrix(int inputMatrix[][], int sizeMatrix, int key){
		int i = 0;		 // matrix row pointer;
		int j = sizeMatrix-1;    // matrix column pointer;

		while (i < sizeMatrix && j >= 0) {
			if(inputMatrix[i][j] == key) { System.out.println("key with value " + key + " found in matrix at: row " + i + ", column " + j + "." );		return;}
			if(inputMatrix[i][j] > key) { j--; }
			else { i++; }
		}
		System.out.println("Key Not Found.");
	}

	public static void main(String[] args) {
		matrixKeyFinder mkf = new matrixKeyFinder();

		int matrix[][] = {
				{10, 22, 32, 70},
				{12, 26, 39, 88},
				{14, 28, 50, 100},
				{16, 30, 55, 10000},
		};

		mkf.findKeyInMatrix(matrix, 4, 100);
		mkf.findKeyInMatrix(matrix, 4, 30);
		mkf.findKeyInMatrix(matrix, 4, 543453);
	}
}
