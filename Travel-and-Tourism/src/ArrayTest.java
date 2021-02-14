public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// creting and assigning array 
		double[] array = {1.1,2.2,3.3,4.4,5.5};
		double Total = 0 ;
		double max = array[0];
		// accessing array elements 
		for(int i=0;i<array.length;i++)
		{
			if(max < array[i]) { max = array[i];}
			System.out.println("array["+i+"] = " + array[i]);
			Total += array[i];
		}
		System.out.println("Total of array is " + Total);
		System.out.println("Maximum of array " + max);
		
		for(double elt : array) {
			System.out.println(elt);
		}
	}
}
