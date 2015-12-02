using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SortArrayOfNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(' ');
            int[] numbers = new int[input.Length];
            for(int i = 0; i<input.Length; i++)
            {
                numbers[i] = int.Parse(input[i]);
            }
            var result = numbers.OrderBy(a => a);
            foreach(var item in result)
            {
                Console.WriteLine(item);
            }
        }
    }
}
