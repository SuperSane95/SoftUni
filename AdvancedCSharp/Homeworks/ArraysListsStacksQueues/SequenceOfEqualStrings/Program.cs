using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SequenceOfEqualStrings
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split(' ');
            for(int i = 0; i<input.Length-1; i++)
            {
                int tempJ;
                string str1 = input[i];
                Console.Write(str1 + " ");
                for (int j = i+1; j<input.Length; j++)
                {
                    string str2 = input[j];
                    if (str1 == str2)
                    {
                        Console.Write(str2 + " ");
                        tempJ = j;
                    }
                    else
                    {
                        tempJ = j;
                        break;
                    }
                    i = tempJ;
                }
                Console.WriteLine();
            }
        }
    }
}
