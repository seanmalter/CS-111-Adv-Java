public class QuickSort
{
  public static void main(String[] args)
  {
    double[] d = {91,98,38,3,99,5,88,70,8,95,26,11,45,34,96,23,80,56,1,62,75,
    35,86,37,6,69,12,21,44,58,7,29,89,78,55,90,54,85,61,31,74,100,49,67,93,52,
    72,50,22,41,16,53,82,48,60,92,46,64,17,97,59,87,94,10,42,40,20,57,65,77,63,
    9,18,25,4,47,84,51,24,68,2,28,32,36,79,76,19,13,71,33,15,43,81,83,73,14,30,
    39,27,66};
    sort(d, 0, d.length-1);
    for(int i =0; i < d.length; i++)
    {
      System.out.print(d[i] + ", ");
    }
    System.out.println();
  }
  public static void sort(double[] a, int begin, int end)
  {

    if((end - begin) == 1)
    {
      if(a[end] < a[begin])
      {
        double temp = a[begin];
        a[begin] = a[end];
        a[end] = temp;
      }
    }
    else if((end - begin) >= 2)
    {
      int splitPoint = split(a, begin, end);
      sort(a, begin, splitPoint);
      sort(a, splitPoint + 1, end);
    }
  }

  public static int split(double[] a, int begin, int end)
  {
    double[] temp;
    int size = (end - begin + 1);
    temp = new double [size];
    double splitValue = (a[begin] + a[end])/2;
    int up = 0;
    int down = size - 1;

    for (int i = begin; i <= end; i++)
    {
      if(a[i] <= splitValue)
      {
        temp[up] = a[i];
        up++;
      }
      else
      {
        temp[down] = a[i];
        down--;
      }
    }
    //0 <= up = down < size
    //temp[up] = a[begin]; //positions the split value
    // temp[i] <= splitValue for i < up
    //temp[up] = splitValue
    // temp[i] > splitValue for i > ip
    for(int i = 0; i < size; i++)
    {
      a[begin + i] = temp[i];
    }
    return (begin + up-1);
  }
}
