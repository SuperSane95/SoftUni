using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LongestInreasingSequence
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] numbers = Console.ReadLine().Split(' ');
            List<int> list = new List<int>();
            List<int> longest = new List<int>();
            List<int> temp = new List<int>();
            foreach(string number in numbers)
            {
                list.Add(int.Parse(number));
            }
            for(int i = 0; i<list.Count; i++)
            {
                int number1, number2;
                if(i == list.Count-1)
                {
                    number1 = list.ElementAt(i-1);
                    number2 = list.ElementAt(i);
                    if(!temp.Contains(number2))
                    {
                        temp.Add(number2);
                    }
                    if(number1 < number2)
                    {
                        temp.Add(number2);
                    }
                    else
                    {
                        string output = string.Join(" ", temp);
                        Console.WriteLine(output);
                        if (temp.Count > longest.Count)
                        {
                            longest.Clear();
                            longest.AddRange(temp);
                        }
                        temp.Clear();
                    }
                }
                else
                {
                    number1 = list.ElementAt(i);
                    number2 = list.ElementAt(i + 1);
                    if (!temp.Contains(number1))
                    {
                        temp.Add(number1);
                    }
                    if (number1 < number2)
                    {
                        temp.Add(number2);
                    }
                    else
                    {
                        string output = string.Join(" ", temp);
                        Console.WriteLine(output);
                        if (temp.Count > longest.Count)
                        {
                            longest.Clear();
                            longest.AddRange(temp);
                        }
                        temp.Clear();
                    }
                }
                
            }
            if (longest.Count == 0 || longest.Count < temp.Count)
            {
                longest.Clear();
                longest.AddRange(temp);
                longest.RemoveAt(longest.Count - 1);
            }
            string outputLongest = string.Join(",", longest);
            Console.WriteLine("Longest : " + outputLongest);
        }
    }
}
