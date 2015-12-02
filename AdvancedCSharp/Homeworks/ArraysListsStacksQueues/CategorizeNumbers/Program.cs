using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CategorizeNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] numbers = Console.ReadLine().Split(' ');
            List<double> floatingNumbers = new List<double>();
            List<int> integerNumbers = new List<int>();
            foreach(string number in numbers)
            {
                if (number.Contains("."))
                {
                    double number2 = double.Parse(number);
                    
                    if (number2 % 1 == 0)
                    {
                        integerNumbers.Add(Convert.ToInt32(number2));
                    }
                    else
                    {
                        floatingNumbers.Add(number2);
                    }
                }
                else
                {
                    integerNumbers.Add(int.Parse(number));
                }
            }
            string output = string.Join(", ", floatingNumbers);
            Console.WriteLine("{0} -> min: {1:f2}, max: {2:f2}, sum: {3:f2}, avg: {4:f2}", output, floatingNumbers.Min(), floatingNumbers.Max(),
                floatingNumbers.Sum(), floatingNumbers.Average());
            output = string.Join(", ", integerNumbers);
            Console.WriteLine("{0} -> min: {1}, max: {2}, sum: {3}, avg: {4:f2}", output, integerNumbers.Min(), integerNumbers.Max(),
                integerNumbers.Sum(), integerNumbers.Average());

        }
    }
}
