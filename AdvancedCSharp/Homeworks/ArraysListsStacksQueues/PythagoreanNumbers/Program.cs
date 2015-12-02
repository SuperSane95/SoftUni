using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PythagoreanNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            List<int> list = new List<int>();
            bool hasResult = false;
            for(int i = 0; i < n; i++)
            {
                list.Add(int.Parse(Console.ReadLine()));
            }
            for(int i = 0; i < list.Count - 1; i++)
            {
                for (int j = i+1; j<list.Count; j++)
                {
                    for(int k = 0; k<list.Count; k++)
                    {
                        int number1 = list.ElementAt(i);
                        int number2 = list.ElementAt(j);
                        int result = list.ElementAt(k);
                        if(number1 * number1 + number2 * number2 == result*result)
                        {
                            hasResult = true;
                            Console.WriteLine("{0}*{0} + {1}*{1} = {2}*{2}", number1, number2, result);
                        }
                    }
                }
            }
            if(!hasResult)
            {
                Console.WriteLine("No");
            }
        }
    }
}
