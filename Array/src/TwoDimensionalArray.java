class TwoDimensionalArray
{
public static void main(String arg[])
 {
 int i,j;
 int a[][]=new int[10][10];
 for(i=1;i<=10;i++)
 { for(j=1;j<=10;j++)
 { a[i-1][j-1]=i*j;
 System.out.print(a[i-1][j-1]+"\t");
 }
 System.out.print("\n");
 }
 }
}
