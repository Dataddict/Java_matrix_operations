public class AdjacencyMatrix {
    
private double [][] matrix;

    public AdjacencyMatrix(int row, int columns) {
        matrix = new double [row][columns];
    }
    
    public AdjacencyMatrix(int size) {
        matrix = new double [size][size];
    }

    public AdjacencyMatrix(double[][] matrix) {
        this.matrix = matrix;
    }
    
    public void RandomlyInitialyse() {
        
        for(int i=0;i<this.matrix.length;i++)
        {
            for(int j=0;j<this.matrix[0].length;j++)
            {
                matrix[i][j]=Math.round(Math.random());    
            }
        }
    }
    
    void display()
    {
        System.out.println("");
        System.out.println("********MATRIX**********");
         
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(j!=matrix[0].length-1)System.out.print((int)(matrix[i][j])+" ");
                else System.out.print((int)(matrix[i][j]));
            }
         System.out.println();
        }
        System.out.println("**********************");
    }
    
    /**
        Get number of rows
        @return number of rows
    */
    public int getRowSize()
    {
        return this.matrix.length;
    }
    
    public int getColumnSize()
    {
        if(matrix[0]!=null)return this.matrix[0].length;
        else return 0;
    }
    
      /**
        Set up the ith line and jth column of the matrix  
        @param row the line of the matrix.
        @param column the column of the matrix.
        @param value the value to set up.
    */
    public void setValueatPosition(int row,int column,double value)
    {
        if(this.getRowSize()>row && this.getColumnSize()>column)
            this.matrix[row][column]=value;
        else
        {
            System.out.println("out of bounds");
        }
    }
    
    public double getValueatPosition(int row,int column)
    {
        if(this.getRowSize()>row && this.getColumnSize()>column)
            return this.matrix[row][column];
        return Double.NaN;
    }
    
    
    AdjacencyMatrix getTransposeMatrix()
    {
    
    AdjacencyMatrix transposematrix = new AdjacencyMatrix(matrix[0].length,matrix.length);
        
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                transposematrix.setValueatPosition(j,i,this.getValueatPosition(i,j));
            }
        }
        return transposematrix;
    }
    
    AdjacencyMatrix MultiplyMatrices(AdjacencyMatrix mymatrix)
    {
        
        AdjacencyMatrix product = new AdjacencyMatrix(this.getRowSize(),mymatrix.getColumnSize());
       
        for(int raw=0;raw<matrix.length;raw++)
        {
            
            for(int col=0;col<mymatrix.getColumnSize();col++)
            {    
                int sum=0;
                
                for(int i=0;i<matrix[0].length;i++)
                {
                        sum+=this.getValueatPosition(raw,i)*mymatrix.getValueatPosition(i,col);
                }    
                product.setValueatPosition(raw, col, sum);  
            }
        }
        return product;
    }  
}