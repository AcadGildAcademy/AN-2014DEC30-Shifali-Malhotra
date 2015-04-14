import java.io.DataInputStream;
import java.io.IOException;

class MultiDimensionalArray {
	public static void main(String arg[]) {
		int a[][][] = new int[3][3][3];
		int i, j, k;
		DataInputStream ins = new DataInputStream(System.in);
		for (i = 0; i < 3; i++) {
			System.out.println("Enter details of student " + (i + 1));
			for (j = 0; j < 3; j++) {
				System.out.println("\tFor semester " + (j + 1));
				for (k = 0; k < 3; k++) {
					try {
						System.out.print("\t\tEnter marks for subject "
								+ (k + 1) + " :");
						a[i][j][k] = Integer.parseInt(ins.readLine());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			System.out.println("\n");
		}
		System.out.print("\n");
		for (i = 0; i < 3; i++) {
			System.out.println("DETAILS OF STUDENT " + (i + 1));
			for (j = 0; j < 3; j++) {
				System.out.println("\tFor semester " + (j + 1));
				for (k = 0; k < 3; k++)
					System.out.println("\t\tMarks in Subject " + (k + 1) + ": "
							+ a[i][j][k]);
			}
			System.out.println("\n");
		}
	}
}
