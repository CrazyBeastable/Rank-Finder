import java.util.Scanner;
class Rank_Finder
{
   public int n,m;
   private int rank=0;
   Rank_Finder(int num1,int num2)
   {
       n=num1;
       m=num2;
   }
   private float[][] mat=new float[50][50];
   public void getmatrix()
   {
       Scanner o=new Scanner(System.in);
       for(int i=0;i<n;i++)
       for(int j=0;j<m;j++)
       mat[i][j]=o.nextFloat();
       o.close();
   }
   public void Operate()
   {
       float[] arr=new float[50];
       for(int j=0;j<m;j++)
       {
           if(mat[j][j]==0) continue;
           float fterm=mat[j][j];
           for(int col=j;col<m;col++)
           {
               mat[j][col]/=fterm;
               arr[col]=mat[j][col];
           }
           for(int row=j+1;row<n;row++)
           {
               fterm=mat[row][j];
               for(int col=j;col<m;col++)
               {
                   mat[row][col]-=fterm*arr[col];
               }
           }
           for(int col=j+1;col<m;col++)
           {
                fterm=mat[j][col];
                mat[j][col]-=fterm;
           }
       }
       for(int row=n-1;row>=0;row--) 
       {
           int t=zero_row_checker(row);
           if(t==1) rank++;
           else break;
       }
       rank=n-rank;
   }
   public int zero_row_checker(int row)
   {
       int cnt=0;
       for(int j=0;j<m;j++)
       {
           if(mat[row][j]==0.0) cnt++;
       }
       if(cnt==m) return 1;
       else return 0;
   }
   public void displayMatrix()
   {
       Scanner o=new Scanner(System.in);
       for(int i=0;i<n;i++,System.out.print("\n"))
       for(int j=0;j<m;j++)
       System.out.print(mat[i][j]+"\t");
       o.close();
   }
   public void displayRank()
   {
       System.out.println("The rank of the matrix = "+rank);
   }
}
public class R_M_Main {
    public static void main(String[] args)
    {
        Scanner o = new Scanner(System.in);
        Rank_Finder obj=new Rank_Finder(o.nextInt(),o.nextInt());
        obj.getmatrix();
        obj.Operate();
        obj.displayMatrix();
        obj.displayRank();
        o.close();
    }
}