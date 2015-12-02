using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LegoBlocks
{
    class Program
    {
        static void Main(string[] args)
        {
            List<List<int>> first = new List<List<int>>();
            List<List<int>> second = new List<List<int>>();
            List<List<int>> block = new List<List<int>>();
            int n = int.Parse(Console.ReadLine());
            bool areEqual = true;
            for(int i = 0; i < n; i++)
            {
                first.Add(Console.ReadLine().Split(' ').Select(int.Parse).ToList());
            }
            for (int i = 0; i < n; i++)
            {
                second.Add(Console.ReadLine().Split(' ').Select(int.Parse).Reverse().ToList());
            }
            for(int i = 0; i < n; i++)
            {
                List<int> tempList = new List<int>();
                tempList.AddRange(first.ElementAt(i));
                tempList.AddRange(second.ElementAt(i));
                block.Add(tempList);
            }
            int count = block.ElementAt(0).Count;
            foreach(var row in block)
            {
                if (row.Count != count)
                    areEqual = false;
            }
            if(areEqual)
            {
                foreach(var row in block)
                {
                    Console.WriteLine(string.Join(", ", row));
                }
            }
            else
            {
                int cells = 0;
                foreach(var row in block)
                {
                    cells += row.Count;
                }
                Console.WriteLine("Total number of cells is " + cells);
            }
        }
    }
}
