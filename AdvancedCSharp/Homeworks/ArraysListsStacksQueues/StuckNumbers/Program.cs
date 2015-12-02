using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StuckNumbers
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = int.Parse(Console.ReadLine());
            List<string> list = new List<string>();
            bool hasStuck = false;
            list.AddRange(Console.ReadLine().Split(' ').ToList());
            for (int i = 0; i < list.Count; i++)
            {
                for (int j = 0; j < list.Count; j++)
                {
                    for (int m = 0; m < list.Count; m++)
                    {
                        for (int n = 0; n < list.Count; n++)
                        {
                            string number1 = list.ElementAt(i);
                            string number2 = list.ElementAt(j);
                            string number3 = list.ElementAt(m);
                            string number4 = list.ElementAt(n);
                            if (areDistinct(number1, number2, number3, number4))
                                {
                                if ((number1 + number2 == number3 + number4))
                                {
                                    hasStuck = true;
                                    Console.WriteLine("{0}|{1} == {2}|{3}", number1, number2, number3, number4);
                                }
                            }
                        }
                    }
                }
            }
        }
        static bool areDistinct(string i, string j, string m, string n)
        {
            if (i != j && i != m && i != n)
            {
                if (j != m && j != n)
                {
                    if (m != n)
                    {
                        return true;
                    }
                    else return false;
                }
                else return false;
            }
            else return false;
        }
    }
}
