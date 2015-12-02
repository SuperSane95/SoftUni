using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SortArrayOfNumbersUsingSelectionSort
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(' ');
            int[] numbers = new int[input.Length];
            for (int i = 0; i < input.Length; i++)
            {
                numbers[i] = int.Parse(input[i]);
            }
            
            for(int i = 0; i<numbers.Length; i++)
            {
                int min = numbers[i];
                int temp;
                for(int j = i+1; j<numbers.Length; j++)
                {
                    if(numbers[j] < min)
                    {
                        min = numbers[j];
                        temp = numbers[i];
                        numbers[i] = min;
                        numbers[j] = temp;
                    }
                }
            }
            foreach(var item in numbers)
            {
                Console.Write(item + " ");
            }
        }
    }
}
